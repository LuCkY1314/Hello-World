package com.example.chansiqing.databindingstudy.floors.wrapContentParentFloor;


import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.chansiqing.databindingstudy.floors.floorCommonInterface.FloorMatchDataInterface;

/**
 * 相对布局楼层 高度自适应
 *
 * @author: chansiqing
 * @date: 2019-01-28 11:49
 */
public abstract class RelativeFloor extends RelativeLayout implements FloorMatchDataInterface {

    public RelativeFloor(Context context) {
        super(context);
    }

    public RelativeFloor(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RelativeFloor(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void adapterData(Object data) {

    }

    @Override
    public int getFloorHeight() {
        return ViewGroup.LayoutParams.WRAP_CONTENT;
    }
}
