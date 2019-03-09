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

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.utils.UIUtil;

/**
 * 用valueAnim实现走马灯效果的view
 *
 * @author: chansiqing
 * @date: 2019-01-31 11:15
 */
public class MyFlipperView extends LinearLayout {
    private LinearLayout A_Layout, B_Layout;//两个动画替换容器
    public static final int FIRST_LAYOUT_ID = 1, SECOND_LAYOUT_ID = 2;
    private static final int AtoB = 0, BtoA = 1, END = 2;
    private static final String Y_TRANSLATE = "translationY";
    private static final String X_TRANSLATE = "translationX";
    private AnimatorSet upAnimatorSet, downAnimatorSet;//AB向上，AB向下动画组合
    private final AnimRunnable animRunnable = new AnimRunnable();//动画执行runnable，满足延迟需求，并且可以移除重复执行
    private Handler handler = new Handler(getContext().getMainLooper());
    private AnimatorSet currentAnimator;
    private boolean isManuallyEnd;
    private boolean hasPlayed;//是否已经被播放了

    //================================= 设置参数 =================================================
    private static final int EACH_LINE_DEFAULT_HEIGHT = UIUtil.dp2px(80);
    private static final int EACH_LINE_DEFAULT_WIDTH = UIUtil.getScreenWidth();
    private int eachLineHeight = EACH_LINE_DEFAULT_HEIGHT;//每个容器的高度
    private int eachLineWidth = EACH_LINE_DEFAULT_WIDTH;//每个容器的宽度
    public static final int VERTICAL = 0, HORIZON = 1;
    private int orientation = VERTICAL;//移动方向
    public static final int A_SIDE = 0, B_SIDE = 1, BOTH_SIDE = 2, NONE_SIDE = 3;//面枚举
    private int currentSide = A_SIDE;//当前是哪面 用于resume的时候判断当前flipper处于什么初始状态
    private boolean canPlay;
    private boolean needSlowlyScroll;//开启高性能开关
    private boolean ifHasShowA, ifHasShowB;//统计在未切换界面的时候，已经展示的面

    public boolean isNeedSlowlyScroll() {
        return needSlowlyScroll;
    }

    public void setNeedSlowlyScroll(boolean needSlowlyScroll) {
        this.needSlowlyScroll = needSlowlyScroll;
    }

    public boolean getCanPlay() {
        return canPlay;
    }

    public void setCanPlay(boolean canPlay) {
        this.canPlay = canPlay;
    }

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

        void onBothSideShow(boolean ifHasShowA, boolean ifHasShowB);
    }

    public MyFlipperView(Context context, int orientation) {
        super(context);
        this.orientation = orientation;
        if (this.orientation == VERTICAL) {
            setOrientation(LinearLayout.VERTICAL);
        } else {
            setOrientation(LinearLayout.HORIZONTAL);
        }
    }

    public MyFlipperView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setClipChildren(false);
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
        if (orientation == VERTICAL) {
            setOrientation(LinearLayout.VERTICAL);
        } else {
            setOrientation(LinearLayout.HORIZONTAL);
        }
    }

    /**
     * 添加A面布局
     *
     * @param a_Layout
     */
    public void addA_Layout(LinearLayout a_Layout) {
        A_Layout = a_Layout;
        LinearLayout.LayoutParams A_Params = new LinearLayout.LayoutParams(eachLineWidth, eachLineHeight);
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
        LinearLayout.LayoutParams B_Params = new LinearLayout.LayoutParams(eachLineWidth, eachLineHeight);
        B_Layout.setId(SECOND_LAYOUT_ID);
        addView(B_Layout, B_Params);
        //A，B面都添加好之后，才去初始化动画
        initAnim();
    }

    /**
     * 初始化两个替换容器的flipper动画
     */
    private void initAnim() {
        //默认竖直方向的滑动
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

        currentAnimator = upAnimatorSet = new AnimatorSet();
        upAnimatorSet.setDuration(3000);
        upAnimatorSet.setStartDelay(2000);
        upAnimatorSet.play(A_ToUpAnim).with(B_ToUpAnim);
        upAnimatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                currentSide = BOTH_SIDE;
                ifHasShowA = true;
                hasPlayed = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                currentSide = B_SIDE;
                if (!isManuallyEnd) {
                    currentAnimator = downAnimatorSet;
                    currentAnimator.start();
                }
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
        downAnimatorSet.setStartDelay(1500);
        downAnimatorSet.play(A_ToBottomAnim).with(B_ToBottomAnim);
        downAnimatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                currentSide = BOTH_SIDE;
                ifHasShowB = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                currentSide = A_SIDE;
                currentAnimator = null;
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    /**
     * 重置初始状态参数
     */
    public void resetStateParams() {
        hasPlayed = false;
        canPlay = false;
        currentAnimator = upAnimatorSet;
        currentSide = A_SIDE;
    }

    /**
     * 刷新开始动画
     */
    public void initStartAnim() {
        if (canPlay) {
            currentAnimator.start();
        }
    }

    public void initStart() {
        resetStateParams();
        if (canPlay) {
            currentAnimator.start();
        }
    }

    /**
     * 暂停动画
     */
    public void pauseAnimWhenScroll() {
        if (currentAnimator == null) return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && needSlowlyScroll) {
            currentAnimator.pause();
        } else {
            if (currentAnimator == upAnimatorSet && currentSide == BOTH_SIDE)
                isManuallyEnd = true;
        }
    }

    /**
     * 暂停动画
     */
    public void pauseAnimWhenChangePage() {
        if (currentAnimator == null) return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && needSlowlyScroll) {
            currentAnimator.pause();
        } else {
            if (currentAnimator.isRunning()) {
                if (currentAnimator == upAnimatorSet) {
                    isManuallyEnd = true;
                }
                currentAnimator.end();
            }
        }
        setHasShowSide();
    }

    /**
     * 重置埋点标记参数
     */
    public void resetMaidianFlag() {
        ifHasShowB = false;
        ifHasShowA = false;
    }

    /**
     * 切换页面状态下恢复播放动画
     */
    public void restartAnimWhenChangePage() {
        resetMaidianFlag();
        if (canPlay) {
            if (currentAnimator == null) return;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && needSlowlyScroll) {
                if (currentAnimator.isPaused()) {
                    currentAnimator.resume();
                } else if (!hasPlayed) {
                    currentAnimator.start();
                }
            } else {
                if (!hasPlayed) {
                    currentAnimator.start();
                } else if (currentSide == B_SIDE) {
                    isManuallyEnd = false;
                    currentAnimator = downAnimatorSet;
                    currentAnimator.start();
                }
            }
            setHasShowSide();
        } else {
            if (UIUtil.isDisplayed(this, 10)) {
                setHasShowSide();
            }
        }
    }

    /**
     * 设置埋点参数标记
     */
    private void setHasShowSide() {
        ifHasShowA = currentSide == A_SIDE || currentSide == BOTH_SIDE;
        ifHasShowB = currentSide == B_SIDE || currentSide == BOTH_SIDE;
    }

    /**
     * 滑动状态下恢复动画
     */
    public void restartAnimWhenScroll() {
        if (currentAnimator == null || !canPlay) return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && needSlowlyScroll) {
            if (currentAnimator.isPaused()) {
                currentAnimator.resume();
            } else if (!hasPlayed) {
                currentAnimator.start();
            }
        } else {
            if (!hasPlayed && !currentAnimator.isRunning()) {
                currentAnimator.start();
            } else if (currentSide == B_SIDE && !currentAnimator.isStarted()) {
                isManuallyEnd = false;
                currentAnimator = downAnimatorSet;
                currentAnimator.start();
            }
        }
    }

    /**
     * 去除残留的runnable
     */
    public void removeAllCallback() {
        handler.removeCallbacks(animRunnable);
    }

    /**
     * 检验埋点状态 —— fragment两种情况下需要主动调用：
     * 1.stop
     * 2.start
     */
    public void checkMaidian() {
        if (maidianListener != null)
            maidianListener.onBothSideShow(ifHasShowA, ifHasShowB);
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
            if (canPlay) {
                switch (animType) {
                    case AtoB:
                        currentAnimator = upAnimatorSet;
                        break;
                    case BtoA:
                        currentAnimator = downAnimatorSet;
                        break;
                    case END:
                        return;
                }
                currentAnimator.start();
            } else {
                handler.postDelayed(this, 2000);
            }
        }
    }
}

