package com.example.chansiqing.databindingstudy.floors.floor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.data.ScrollData;
import com.example.chansiqing.databindingstudy.floors.floorCommonInterface.FloorMatchDataInterface;
import com.example.chansiqing.databindingstudy.floors.wrapContentParentFloor.RelativeFloor;

/**
 * 滑动楼层实验
 *
 * @author: chansiqing
 * @date: 2018-12-21 11:44
 */
public class ScrollFloor extends RelativeFloor implements FloorMatchDataInterface {
    private HorizontalScrollView scrollView;
    private ImageView contentIv;

    public ScrollFloor(Context context) {
        super(context);
        init();
    }

    public ScrollFloor(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ScrollFloor(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.floor_scroll, this);
        contentIv = view.findViewById(R.id.content);
        scrollView = view.findViewById(R.id.scroll);
        //EventBus.getDefault().register(this);
    }

    private void setModel(ScrollData data) {

    }

    @Override
    public void adapterData(Object data) {
        if (data instanceof ScrollData) {
            setModel((ScrollData) data);
        }
    }

    @Override
    public void onViewRemoved(View child) {
        super.onViewRemoved(child);
    }
}
