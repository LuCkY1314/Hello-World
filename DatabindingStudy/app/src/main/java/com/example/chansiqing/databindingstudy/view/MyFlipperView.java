package com.example.chansiqing.databindingstudy.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.utils.UIUtil;

/**
 * 用valueAnim实现走马灯效果的view
 *
 * @author: chansiqing
 * @date: 2019-01-31 11:15
 */
public class MyFlipperView extends RelativeLayout {
    private LinearLayout A_Layout, B_Layout;//两个动画替换容器
    public static final int FIRST_LAYOUT_ID = 1, SECOND_LAYOUT_ID = 2;
    private static final int AtoB = 0, BtoA = 1;
    private static final String Y_TRANSLATE = "translationY";
    private static final String X_TRANSLATE = "translationX";
    private AnimatorSet upAnimatorSet, downAnimatorSet;//AB向上，AB向下动画组合
    private final AnimRunnable animRunnable = new AnimRunnable();//动画执行runnable，满足延迟需求，并且可以移除重复执行
    private Handler handler = new Handler(getContext().getMainLooper());
    private AnimatorSet currentAnimator;
    //================================= 设置参数 =================================================
    private static final int EACH_LINE_DEFAULT_HEIGHT = UIUtil.dp2px(80);
    private static final int EACH_LINE_DEFAULT_WIDTH = UIUtil.getScreenWidth();
    private int eachLineHeight = EACH_LINE_DEFAULT_HEIGHT;//每个容器的高度
    private int eachLineWidth = EACH_LINE_DEFAULT_WIDTH;//每个容器的宽度
    public static final int VERTICAL = 0, HORIZON = 1;
    private int orientation = VERTICAL;//移动方向
    private static final int A_SIDE = 0, B_SIDE = 1, A_SIDE_REVERT = 2;//面枚举
    private int currentSide = A_SIDE;//当前是哪面

    public int getEachLineHeight() {
        return eachLineHeight;
    }

    public void setEachLineHeight(int eachLineHeight) {
        this.eachLineHeight = eachLineHeight;
    }

    public int getEachLineWidth() {
        return eachLineWidth;
    }

    public void setEachLineWidth(int eachLineWidth) {
        this.eachLineWidth = eachLineWidth;
    }

    //================================= 埋点接口 =================================================
    private MaidianForFlipperSKU maidianListener;

    public MaidianForFlipperSKU getMaidianListener() {
        return maidianListener;
    }

    public void setMaidianListener(MaidianForFlipperSKU maidianListener) {
        this.maidianListener = maidianListener;
    }

    public interface MaidianForFlipperSKU {
        void onA_SideShow();

        void onB_sideShow();

        void onBothSideShow();
    }

    public MyFlipperView(Context context, int orientation) {
        super(context);
        this.orientation = orientation;
    }

    public MyFlipperView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyFlipperView, 0, 0);
        int indexCount = a.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.MyFlipperView_orientation:
                    orientation = a.getInt(attr, 0);
                    break;
            }
        }
        a.recycle();
    }

    /**
     * 添加A面布局
     *
     * @param a_Layout
     */
    public void addA_Layout(LinearLayout a_Layout) {
        A_Layout = a_Layout;
        RelativeLayout.LayoutParams A_Params = new RelativeLayout.LayoutParams(eachLineWidth, eachLineHeight);
        A_Layout.setId(FIRST_LAYOUT_ID);
        addView(A_Layout, A_Params);
    }

    /**
     * 添加B面布局
     *
     * @param b_Layout
     */
    public void addB_Layout(LinearLayout b_Layout) {
        B_Layout = b_Layout;
        RelativeLayout.LayoutParams B_Params = new RelativeLayout.LayoutParams(eachLineWidth, eachLineHeight);
        if (orientation == VERTICAL) {
            B_Params.addRule(BELOW, FIRST_LAYOUT_ID);
        } else {
            B_Params.addRule(RIGHT_OF, FIRST_LAYOUT_ID);
        }
        B_Layout.setId(SECOND_LAYOUT_ID);
        addView(B_Layout, B_Params);
        //A，B面都添加好之后，才去初始化动画
        initAnim();
    }

    /**
     * 初始化两个替换容器的flipper动画
     */
    private void initAnim() {
        String translateSide = Y_TRANSLATE;
        switch (orientation) {
            case VERTICAL:
                translateSide = Y_TRANSLATE;
                break;
            case HORIZON:
                translateSide = X_TRANSLATE;
                break;
        }
        ObjectAnimator A_ToUpAnim = ObjectAnimator.ofFloat(A_Layout, translateSide, 0, -eachLineHeight);
        ObjectAnimator A_ToBottomAnim = ObjectAnimator.ofFloat(A_Layout, translateSide, -eachLineHeight, 0);
        ObjectAnimator B_ToUpAnim = ObjectAnimator.ofFloat(B_Layout, translateSide, 0, -eachLineHeight);
        ObjectAnimator B_ToBottomAnim = ObjectAnimator.ofFloat(B_Layout, translateSide, -eachLineHeight, 0);

        upAnimatorSet = new AnimatorSet();
        upAnimatorSet.setDuration(3000);
        upAnimatorSet.play(A_ToUpAnim).with(B_ToUpAnim);
        upAnimatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (maidianListener != null) {
                    maidianListener.onBothSideShow();
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                animRunnable.setAnimType(BtoA);
                handler.postDelayed(animRunnable, 1500);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        downAnimatorSet = new AnimatorSet();
        downAnimatorSet.setDuration(3000);
        downAnimatorSet.play(A_ToBottomAnim).with(B_ToBottomAnim);
        downAnimatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (maidianListener != null) {
                    maidianListener.onBothSideShow();
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
//                animRunnable.setAnimType(AtoB);
//                handler.postDelayed(animRunnable, 1500);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    public void initStartAnim() {
        handler.postDelayed(animRunnable, 2000);
    }

    public void pauseAnim() {
        if (currentAnimator == null) return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            currentAnimator.pause();
//            currentAnimator.end();
        } else {
            if (!currentAnimator.isRunning()) {
                currentAnimator.end();
            }
        }
    }

    public void restartAnim() {
        if (currentAnimator == null) return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            currentAnimator.resume();
        }
    }

    public void removeAllCallback() {
        handler.removeCallbacks(animRunnable);
    }

    public void playBtoA() {
        if (downAnimatorSet != null) {
            currentAnimator = downAnimatorSet;
            downAnimatorSet.start();
        }
    }

    /**
     * 从A-B过程中停止
     */
    public void pauseForAtoB() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            upAnimatorSet.pause();
        } else {
            currentSide = B_SIDE;
        }
    }

    /**
     * 从B-A过程中停止
     */
    public void pauseForBtoA() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            downAnimatorSet.pause();
        } else {
            currentSide = A_SIDE_REVERT;
        }
    }

    /**
     * 动画runnable
     */
    public class AnimRunnable implements Runnable {
        private int animType;

        public int getAnimType() {
            return animType;
        }

        public void setAnimType(int animType) {
            this.animType = animType;
        }

        private void removeUselessRunnable() {
            if (handler != null) {
                handler.removeCallbacks(this);
            }
        }

        @Override
        public void run() {
            removeUselessRunnable();
            switch (animType) {
                case AtoB:
                    currentAnimator = upAnimatorSet;
                    break;
                case BtoA:
                    currentAnimator = downAnimatorSet;
                    break;
            }
            currentAnimator.start();
        }
    }

}
