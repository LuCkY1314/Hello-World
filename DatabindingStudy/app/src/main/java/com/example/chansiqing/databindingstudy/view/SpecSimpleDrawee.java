/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.chansiqing.databindingstudy.view;

import android.content.Context;
import android.util.AttributeSet;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * 防止太快回收图片的SimpleDraweeView控件
 *
 * @author: chansiqing
 * @date: 2018-10-10 17:17
 */
public class SpecSimpleDrawee extends SimpleDraweeView {
    public SpecSimpleDrawee(Context context) {
        super(context);
    }

    public SpecSimpleDrawee(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SpecSimpleDrawee(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SpecSimpleDrawee(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onVisibilityAggregated(boolean isVisible) {
        super.onVisibilityAggregated(true);
    }
}
