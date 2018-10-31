package com.example.chansiqing.databindingstudy.floor;

import android.view.View;

/**
 * 每个楼层view需要实现的接口，用于在混合楼层中统一调用方法
 *
 * @author: chansiqing
 * @date: 2018-10-30 18:58
 */
public interface FloorMatchDataInterface {
    void adapterData(Object data);

    View getRootView();

}
