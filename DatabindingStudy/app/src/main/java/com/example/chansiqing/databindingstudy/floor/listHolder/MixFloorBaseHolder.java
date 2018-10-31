package com.example.chansiqing.databindingstudy.floor.listHolder;

import android.support.v7.widget.RecyclerView;

import com.example.chansiqing.databindingstudy.floor.FloorMatchDataInterface;

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
    }

    public void bindData(Object data) {
        rootView.adapterData(data);
    }
}
