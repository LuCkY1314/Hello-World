/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.chansiqing.databindingstudy.utils;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chansiqing.databindingstudy.data.BaseData;
import com.example.chansiqing.databindingstudy.data.BindingAdapterTestFloorData;
import com.example.chansiqing.databindingstudy.floor.listAdapter.BaseBindingListAdapter;
import com.example.chansiqing.databindingstudy.view.MyRecycleView;
import com.facebook.drawee.view.SimpleDraweeView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2018-10-09 15:36
 */
public class MyBindingAdapter {
    @BindingAdapter("android:layout_marginLeft")
    public static void setMarginLeft(View view, int leftMargin) {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        layoutParams.setMargins(leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        view.setLayoutParams(layoutParams);
    }

    @BindingAdapter("android:layout_marginRight")
    public static void setMarginRight(View view, int rightMargin) {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, rightMargin, layoutParams.bottomMargin);
        view.setLayoutParams(layoutParams);
    }

    @BindingAdapter("android:layout_marginTop")
    public static void setMarginTop(View view, int topMargin) {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        view.setLayoutParams(layoutParams);
    }

    @BindingAdapter("android:layout_marginBottom")
    public static void setMarginBottom(View view, int bottomMargin) {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, bottomMargin);
        view.setLayoutParams(layoutParams);
    }

    //===================================== 自定义全局方法 ========================================================================
    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, int drawableResId) {
        view.setImageResource(drawableResId);
    }

    @BindingAdapter("frescoOnly:image_url")
    public static void setImageUrl(SimpleDraweeView view, String url) {
        if (TextUtils.isEmpty(url)) return;
        view.setImageURI(url);
    }

    @BindingAdapter("data")
    public static void setData(MyRecycleView view, List<? extends BaseData> list) {
        if (list == null || list.size() == 0) return;
        view.setData(list);
    }

    //===================================== 自定义转化方法 ================================================================


}