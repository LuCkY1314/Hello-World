package com.example.chansiqing.databindingstudy.floors.anim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;

/**
 * 简单平移动画
 *
 * @author: chansiqing
 * @date: 2019-01-30 17:16
 */
public class SimpleTranslateValueAnim extends ValueAnimator {
    public static final int HORIZON = 0;
    public static final int VERTICAL = 1;
    private TranslateAnimListener listener;

    public TranslateAnimListener getListener() {
        return listener;
    }

    public void setListener(TranslateAnimListener listener) {
        this.listener = listener;
    }

    public interface TranslateAnimListener {
        void onStart();

        void onEnd();

        void onCancel();
    }

    public SimpleTranslateValueAnim(View view, int start, int end, int duration, int orientation) {
        ObjectAnimator animator = new ObjectAnimator();
        switch (orientation) {
            case HORIZON:
                animator = ObjectAnimator.ofFloat(view, "translationX", start, end);
                break;
            case VERTICAL:
                animator = ObjectAnimator.ofFloat(view, "translationY", start, end);
                break;
        }
        animator.setDuration(duration);
        animator.addListener(new AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (listener != null) {
                    listener.onStart();
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (listener != null) {
                    listener.onEnd();
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                if (listener != null) {
                    listener.onCancel();
                }
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
