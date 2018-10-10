/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.chansiqing.databindingstudy.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.data.FlipperData;
import com.example.chansiqing.databindingstudy.databinding.ActivityComplexFloorBinding;
import com.example.chansiqing.databindingstudy.databinding.ViewFlipperChildBinding;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2018-10-10 10:38
 */
public class ComplexFloorActivity extends AppCompatActivity {
    private static final String url = "https://m.360buyimg.com/mobilecms/jfs/t23650/360/507299913/19947/9d079f65/5b3349d7n36ef9fdb.jpg!q70.jpg.webp";
    private GenericDraweeHierarchy hierarchy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hierarchy = getGenericDraweeHierarchy();
        ActivityComplexFloorBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_complex_floor);
        initViewSetting(binding);
        initMockData(binding);
    }

    /**
     * mock数据
     *
     * @param binding
     */
    private void initMockData(ActivityComplexFloorBinding binding) {
        for (int i = 0; i < 4; i++) {
            FlipperData data = new FlipperData();
            data.setText("这是一条资讯 " + i);
            data.setUrl(url);
            View view = initEachFlipperView(data);
            if (view != null) {
                binding.flipper.addView(view);
            }
        }
    }

    /**
     * 生成flipper的子view
     *
     * @param data
     * @return
     */
    private View initEachFlipperView(FlipperData data) {
        if (data == null) return null;
        ViewFlipperChildBinding childBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.view_flipper_child, null, false);
        childBinding.photo.setImageURI(data.getUrl());
        childBinding.photo.setHierarchy(hierarchy);
        childBinding.setItem(data);
        return childBinding.getRoot();
    }

    /**
     * 初始化flipper动画设置
     *
     * @param binding
     */
    private void initViewSetting(ActivityComplexFloorBinding binding) {
        binding.flipper.setInAnimation(this, R.anim.anim_in);
        binding.flipper.setOutAnimation(this, R.anim.anim_out);
        binding.flipper.setFlipInterval(2000);
        binding.flipper.setAutoStart(true);
    }

    /**
     * 提供fresco图片的hierarchy
     *
     * @return
     */
    private final GenericDraweeHierarchy getGenericDraweeHierarchy() {
        GenericDraweeHierarchy mHierarchy;
        RoundingParams imgRound = RoundingParams.asCircle();
        imgRound.setOverlayColor(0xFFFFFFFF);
        mHierarchy = GenericDraweeHierarchyBuilder.newInstance(getResources()).setRoundingParams(imgRound)
                .setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP)
                .build();
        return mHierarchy;
    }

}
