package com.example.chansiqing.databindingstudy.floors.listHolder;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.chansiqing.databindingstudy.floors.floorCommonInterface.FloorMatchDataInterface;

/**
 * 混合楼层holder
 *
 * @author: chansiqing
 * @date: 2018-10-30 17:53
 */
public class MixFloorBaseHolder extends RecyclerView.ViewHolder {
    private FloorMatchDataInterface rootView;

    public MixFloorBaseHolder(FloorMatchDataInterface itemView) {
        super(itemView.getRootView());
        rootView = itemView;
        //设置楼层高度
        rootView.getRootView().setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,itemView.getFloorHeight()));
    }

    public void bindData(Object data) {
        rootView.adapterData(data);
    }
}
