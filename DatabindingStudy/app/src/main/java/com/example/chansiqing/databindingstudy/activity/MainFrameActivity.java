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

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.data.MainFrameData;
import com.example.chansiqing.databindingstudy.databinding.ActivityMainFrameBinding;
import com.example.chansiqing.databindingstudy.utils.UIUtil;
import com.example.chansiqing.databindingstudy.viewModel.MainFramePresenter;

/**
 * 启动页面
 *
 * @author: chansiqing
 * @date: 2018-09-30 14:29
 */
public class MainFrameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainFrameBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main_frame);
        binding.setItem(initMockData());
        binding.setPresenter(new MainFramePresenter());
    }

    private MainFrameData initMockData() {
        MainFrameData data = new MainFrameData();
        MainFrameData.ItemBtnData btnData1 = new MainFrameData.ItemBtnData();
        btnData1.setSimpleBtnName("普通addView楼层");
        btnData1.setSimpleBtnVisible(true);
        btnData1.setMarginHorizon(UIUtil.dp2px(20));
        btnData1.setSimpleBtnDrawableUrl("http://m.360buyimg.com/mobilecms/jfs/t27775/135/517402683/124382/348be7c3/5bb06cc6N0a8b634a.jpeg!q70.jpg.webp");
        MainFrameData.ItemBtnData btnData2 = new MainFrameData.ItemBtnData();
        btnData2.setSimpleBtnName("bindingHolder混合楼层");
        btnData2.setSimpleBtnVisible(true);
        btnData2.setMarginVertical(UIUtil.dp2px(20));
        btnData2.setMarginHorizon(UIUtil.dp2px(20));
        btnData2.setSimpleBtnDrawableUrl("http://m.360buyimg.com/mobilecms/jfs/t27775/135/517402683/124382/348be7c3/5bb06cc6N0a8b634a.jpeg!q70.jpg.webp");
        MainFrameData.ItemBtnData btnData3 = new MainFrameData.ItemBtnData();
        btnData3.setSimpleBtnName("复用view的混合楼层");
        btnData3.setSimpleBtnVisible(true);
        btnData3.setMarginHorizon(UIUtil.dp2px(20));
        btnData3.setMarginVertical(UIUtil.dp2px(20));
        btnData3.setSimpleBtnDrawableUrl("http://m.360buyimg.com/mobilecms/jfs/t27775/135/517402683/124382/348be7c3/5bb06cc6N0a8b634a.jpeg!q70.jpg.webp");
        MainFrameData.ItemBtnData btnData4 = new MainFrameData.ItemBtnData();
        btnData4.setSimpleBtnName("仅为好看凑数的按钮");
        btnData4.setSimpleBtnVisible(true);
        btnData4.setMarginHorizon(UIUtil.dp2px(20));
        btnData4.setMarginVertical(UIUtil.dp2px(20));
        btnData4.setSimpleBtnDrawableUrl("http://m.360buyimg.com/mobilecms/jfs/t27775/135/517402683/124382/348be7c3/5bb06cc6N0a8b634a.jpeg!q70.jpg.webp");
        data.setBtn1(btnData1);
        data.setBtn2(btnData2);
        data.setBtn3(btnData3);
        data.setBtn4(btnData4);
        return data;
    }
}
