package com.example.chansiqing.databindingstudy.floors.wrapContentParentFloor;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.chansiqing.databindingstudy.floors.floorCommonInterface.FloorMatchDataInterface;

/**
 * 线性布局floor 自适应高度
 *
 * @author: chansiqing
 * @date: 2019-01-29 18:45
 */
public abstract class LinearLayoutFloor extends LinearLayout implements FloorMatchDataInterface {

    public LinearLayoutFloor(Context context) {
        super(context);
    }

    public LinearLayoutFloor(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LinearLayoutFloor(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int getFloorHeight() {
        return ViewGroup.LayoutParams.WRAP_CONTENT;
    }
}
