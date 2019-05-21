package com.example.chansiqing.databindingstudy.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.example.chansiqing.databindingstudy.utils.UIUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * 单行的可点击滚动条
 *
 * @author: chansiqing
 * @date: 2019-03-11 15:34
 */
public class BabelSingleFlipperView extends LinearLayout {
    private ValueAnimator upAnimator;
    private int layoutHeight = ViewGroup.LayoutParams.MATCH_PARENT;
    private int layoutWidth = ViewGroup.LayoutParams.MATCH_PARENT;
    private List<ViewGroup> views;
    private OnAnimOnceFinishedListener listener;
    private float firstY, secondY;
    private boolean hasGetOriginY;
    private boolean isVisible, userPresent = true;
    private Handler handler = new Handler();

    public void setListener(OnAnimOnceFinishedListener listener) {
        this.listener = listener;
    }

    public interface OnAnimOnceFinishedListener {
        void onFinish(ViewGroup viewGroup);
    }

    public List<ViewGroup> getViews() {
        return views;
    }

    public int getLayoutHeight() {
        return layoutHeight;
    }

    public void setLayoutHeight(int layoutHeight) {
        this.layoutHeight = layoutHeight;
    }

    public int getLayoutWidth() {
        return layoutWidth;
    }

    public void setLayoutWidth(int layoutWidth) {
        this.layoutWidth = layoutWidth;
    }

    public BabelSingleFlipperView(Context context) {
        super(context);
    }

    public BabelSingleFlipperView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 添加一行布局
     *
     * @param layout
     */
    public void addLayout(ViewGroup layout) {
        if (views == null) {
            views = new ArrayList<>();
        }
        views.add(layout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(layoutWidth, layoutHeight);
        layout.setLayoutParams(layoutParams);
        addView(layout);
        if (views.size() > 1 && upAnimator == null) {
            initAnim();
        }

    }


    private void initAnim() {
        upAnimator = ValueAnimator.ofFloat(0f, 1f);
        upAnimator.setDuration(2000);
        upAnimator.setStartDelay(2000);
        upAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float scale = (float) animation.getAnimatedValue();
                if (!hasGetOriginY) {
                    firstY = views.get(0).getY();
                    secondY = views.get(1).getY();
                    hasGetOriginY = true;
                }
                views.get(0).setY(firstY - scale * layoutHeight);
                views.get(1).setY(secondY - scale * layoutHeight);
                Log.d("current_0_position ", firstY + "");
                Log.d("current_1_position ", secondY + "");
            }
        });
        upAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (listener != null) {
                    listener.onFinish(views.get(0));
                }
                views.get(0).setY(secondY);
                views.add(views.get(0));
                views.remove(0);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (userPresent) {
                            startAnim();
                        }
                    }
                });

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_USER_PRESENT);

        // OK, this is gross but needed. This class is supported by the
        // remote views machanism and as a part of that the remote views
        // can be inflated by a context for another user without the app
        // having interact users permission - just for loading resources.
        // For exmaple, when adding widgets from a user profile to the
        // home screen. Therefore, we register the receiver as the current
        // user not the one the context is for.
        getContext().registerReceiver(mReceiver, filter);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().unregisterReceiver(mReceiver);
        isVisible = false;
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        isVisible = visibility == VISIBLE;
        if (userPresent) {
            startAnim();
        }
    }


    /**
     * 播放动画
     */
    public void startAnim() {
        if (upAnimator != null && !upAnimator.isRunning() && isVisible) {
            upAnimator.start();
        }
    }

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            if (Intent.ACTION_SCREEN_OFF.equals(action)) {
                userPresent = false;
            } else if (Intent.ACTION_USER_PRESENT.equals(action)) {
                userPresent = true;
                startAnim();
            }
        }
    };
}
