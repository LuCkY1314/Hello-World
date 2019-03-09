package com.example.chansiqing.databindingstudy.floors.floorCommonInterface;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/**
 * 每个楼层view需要实现的接口，用于在混合楼层中统一调用方法
 *
 * @author: chansiqing
 * @date: 2018-10-30 18:58
 */
public interface FloorMatchDataInterface {
    /**
     * 适配数据
     *
     * @param data
     */
    void adapterData(Object data);

    /**
     * 拿到根布局（view已经实现了，所以实现该接口的自定义view不用实现该方法）
     *
     * @return
     */
    View getRootView();

    /**
     * 拿到view的父容器
     *
     * @return
     */
    ViewParent getParent();

    /**
     * 设置该楼层高度
     */
    int getFloorHeight();
}
