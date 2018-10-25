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
import android.widget.LinearLayout;

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.data.AutoAdapterFloorData;
import com.example.chansiqing.databindingstudy.data.BindingAdapterTestFloorData;
import com.example.chansiqing.databindingstudy.data.FlipperData;
import com.example.chansiqing.databindingstudy.data.ListTestFloorData;
import com.example.chansiqing.databindingstudy.databinding.ActivityComplexFloorBinding;
import com.example.chansiqing.databindingstudy.databinding.ViewFlipperChildBinding;
import com.example.chansiqing.databindingstudy.floor.AutoAdapterFloor;
import com.example.chansiqing.databindingstudy.floor.BindingAdapterTestFloor;
import com.example.chansiqing.databindingstudy.floor.ListTestFloor;
import com.example.chansiqing.databindingstudy.utils.UIUtil;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;

import java.util.ArrayList;
import java.util.List;

/**
 * 多楼层实验基地
 *
 * @author: chansiqing
 * @date: 2018-10-10 10:38
 */
public class ComplexFloorActivity extends AppCompatActivity {
    private static final String url = "https://m.360buyimg.com/mobilecms/jfs/t23650/360/507299913/19947/9d079f65/5b3349d7n36ef9fdb.jpg!q70.jpg.webp";
    private static final String url2 = "https://m.360buyimg.com/mobilecms/jfs/t19042/334/481621482/316610/571aaa33/5a7c2b43N3dd6ea25.jpeg!q70.jpg.webp";
    private GenericDraweeHierarchy hierarchy;
    private LinearLayout.LayoutParams linearLayoutParam;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hierarchy = getGenericDraweeHierarchy();
        linearLayoutParam = getLinearLayoutParam();
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

        AutoAdapterFloorData data = new AutoAdapterFloorData();
        data.setText("开始测试");
        data.setNeedColor(true);
        AutoAdapterFloor autoAdapterFloor = new AutoAdapterFloor(this);
        binding.content.addView(autoAdapterFloor, linearLayoutParam);
        autoAdapterFloor.setData(data);

        BindingAdapterTestFloorData data1 = new BindingAdapterTestFloorData();
        data1.setShowDefault(true);
        data1.setUrl(url);
        data1.setUrl2(url2);
        BindingAdapterTestFloor bindingAdapterTestFloor = new BindingAdapterTestFloor(this);
        binding.content.addView(bindingAdapterTestFloor, linearLayoutParam);
        bindingAdapterTestFloor.setData(data1);
        //autoAdapterFloor.setModel(data1);
        List<ListTestFloorData> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ListTestFloorData data2 = new ListTestFloorData();
            data2.setImgUrl(url);
            data2.setName("京东好货嚯嚯嚯");
            data2.setPrice("1024");
            data2.setTime(1538712000 + i * 86400);
            data2.setMarginHorizon(12);
            list.add(data2);
        }
        ListTestFloor listTestFloor = new ListTestFloor(this);
        binding.content.addView(listTestFloor, linearLayoutParam);
        listTestFloor.setData(list);
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

    /**
     * 提供公共LinearLayout.layoutParam
     *
     * @return
     */
    public final LinearLayout.LayoutParams getLinearLayoutParam() {
        LinearLayout.LayoutParams linearLayoutParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayoutParam.setMargins(0, UIUtil.dp2px(20), 0, 0);
        return linearLayoutParam;
    }
}
