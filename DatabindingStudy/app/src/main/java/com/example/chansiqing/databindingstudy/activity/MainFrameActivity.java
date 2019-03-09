/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.chansiqing.databindingstudy.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.chansiqing.databindingstudy.fragment.BaseFragment;
import com.example.chansiqing.databindingstudy.fragment.HomeFragment;
import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.data.TabData;
import com.example.chansiqing.databindingstudy.fragment.ListFragment;
import com.example.chansiqing.databindingstudy.fragment.NewListFragment;
import com.example.chansiqing.databindingstudy.fragment.PageViewFragment;
import com.example.chansiqing.databindingstudy.utils.JsonResource;
import com.example.chansiqing.databindingstudy.utils.UIUtil;
import com.example.chansiqing.databindingstudy.view.TabView;

/**
 * 启动页面
 *
 * @author: chansiqing
 * @date: 2018-09-30 14:29
 */
public class MainFrameActivity extends AppCompatActivity {
    private static final String ONE = "one", TWO = "two", THREE = "three", FOUR = "four";
    private static final int TAB_NUM = 4;
    private View.OnClickListener tabClickListener;
    private LinearLayout tabLl;
    private final FragmentManager manager = getSupportFragmentManager();
    private BaseFragment homeFragment, newListFragment, listFragment, gridFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFrame();
        initTabClickListener();
        initTab(TAB_NUM);
    }

    /**
     * 主布局初始化
     */
    private void initFrame() {
        setContentView(R.layout.activity_main_frame);
        tabLl = findViewById(R.id.tab_ll);
        manager.beginTransaction().add(R.id.frame_rl, new HomeFragment(), ONE).commit();
    }

    /**
     * 底部导航栏的点击监听
     */
    private void initTabClickListener() {
        tabClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tag = (String) v.getTag();
                generateAndReplaceFragment(tag);
            }
        };
    }

    /**
     * 生成并替换fragment
     *
     * @param tag
     */
    private void generateAndReplaceFragment(String tag) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.setTransitionStyle(android.R.style.Animation_Translucent);
        switch (tag) {
            case ONE:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                }
                fragmentTransaction.replace(R.id.frame_rl, homeFragment, ONE).commit();
                break;
            case TWO:
                if (newListFragment == null) {
                    newListFragment = new NewListFragment();
                }
                fragmentTransaction.replace(R.id.frame_rl, newListFragment, TWO).commit();
                break;
            case THREE:
                if (listFragment == null) {
                    listFragment = new ListFragment();
                }
                fragmentTransaction.replace(R.id.frame_rl, listFragment, THREE).commit();
                break;
            case FOUR:
                if (gridFragment == null) {
                    gridFragment = new PageViewFragment();
                }
                fragmentTransaction.replace(R.id.frame_rl, gridFragment, FOUR).commit();
                break;
            default:
                break;
        }
    }

    /**
     * 生成底部的导航栏
     *
     * @param tabNum
     */
    private void initTab(int tabNum) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.width = UIUtil.getScreenWidth() / tabNum;
        params.gravity = Gravity.CENTER_VERTICAL;
        for (int i = 0; i < tabNum; i++) {
            TabView tabView = new TabView(this);
            TabData data = new TabData();
            data.setHasPoint(i % 2 == 0);
            data.setText("tab" + i);
            data.setImage(JsonResource.urls[i % JsonResource.urls.length]);
            tabView.adapterData(data);
            tabView.setOnClickListener(tabClickListener);
            tabLl.addView(tabView, params);
            tabLl.setGravity(Gravity.CENTER_VERTICAL);
            switch (i) {
                case 0:
                    tabView.setTag(ONE);
                    break;
                case 1:
                    tabView.setTag(TWO);
                    break;
                case 2:
                    tabView.setTag(THREE);
                    break;
                case 3:
                    tabView.setTag(FOUR);
                    break;
            }
        }
    }
}
