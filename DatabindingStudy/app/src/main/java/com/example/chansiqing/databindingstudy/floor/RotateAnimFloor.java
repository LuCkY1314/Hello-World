package com.example.chansiqing.databindingstudy.floor;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.utils.UIUtil;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2019-01-02 14:59
 */
public class RotateAnimFloor extends RelativeLayout implements FloorMatchDataInterface {
    private ImageView rotateIv;
    private Animation animation;
    private ViewFlipper flipper;
    private int count;
    private Context context;

    public RotateAnimFloor(Context context) {
        super(context);
        this.context = context;
        init(context);
    }

    private void init(final Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.floor_rotate_anim, this);
        flipper = view.findViewById(R.id.flipper);
        SimpleDraweeView translateIv = new SimpleDraweeView(context);
        translateIv.setScaleType(ImageView.ScaleType.FIT_XY);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, UIUtil.dp2px(70));
        translateIv.setImageResource(R.drawable.scroll_back);
        SimpleDraweeView translateIv1 = new SimpleDraweeView(context);
        translateIv1.setScaleType(ImageView.ScaleType.FIT_XY);
        translateIv1.setImageResource(R.drawable.scroll_content);
        flipper.addView(translateIv, params);
        flipper.addView(translateIv1, params);
        setAnim();
        flipper.setAutoStart(true);
        flipper.setFlipInterval(1000);
        flipper.startFlipping();
        animation = AnimationUtils.loadAnimation(context, R.anim.anim_in_cover);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(-1);
        //rotateIv = view.findViewById(R.id.rotate_iv);
//        ObjectAnimator animator = ObjectAnimator.ofFloat(rotateIv, "translationY", 0, 200, -1200,0);
//        animator.setDuration(2000);
//        animator.setRepeatCount(-1);
//        animator.start();
        //rotateIv.startAnimation(animation);
        //rotateAnim();
    }


    private void setAnim() {
        flipper.setInAnimation(context, R.anim.anim_in);
        flipper.setOutAnimation(context, R.anim.anim_out);
        flipper.getInAnimation().setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                count++;
                Toast.makeText(context, "翻转次数:" + count, Toast.LENGTH_SHORT);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                coverAnim();
                Log.d("Animation_End", "翻转次数" + count);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.d("Animation_Repeat", "翻转次数" + count);
            }
        });
    }

    private void coverAnim() {
        flipper.setInAnimation(context, R.anim.anim_in_cover);
        flipper.setOutAnimation(context, R.anim.anim_out_cover);
        flipper.getInAnimation().setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                count++;
                Toast.makeText(context, "翻转次数:" + count, Toast.LENGTH_SHORT);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                flipper.stopFlipping();
                Log.d("Animation_End", "翻转次数" + count);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.d("Animation_Repeat", "翻转次数" + count);
            }
        });
    }

    public void rotateAnim() {
        Animation anim = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setFillAfter(true); // 设置保持动画最后的状态
        anim.setDuration(3000); // 设置动画时间
        anim.setInterpolator(new AccelerateInterpolator()); // 设置插入器
        rotateIv.startAnimation(anim);
    }

    public RotateAnimFloor(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RotateAnimFloor(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    public void adapterData(Object data) {

    }
}
