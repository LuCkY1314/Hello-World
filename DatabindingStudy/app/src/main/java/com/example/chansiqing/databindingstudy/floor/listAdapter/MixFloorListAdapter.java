package com.example.chansiqing.databindingstudy.floor.listAdapter;

import android.databinding.ViewDataBinding;
import android.view.ViewGroup;

import com.example.chansiqing.databindingstudy.data.FloorData;
import com.example.chansiqing.databindingstudy.floor.listHolder.BaseBindingHolder;
import com.example.chansiqing.databindingstudy.utils.MixFloorListHolderGenerator;


/**
 * 混合楼层list adapter
 *
 * @author: chansiqing
 * @date: 2018-10-26 10:43
 */
public class MixFloorListAdapter extends BaseBindingListAdapter<FloorData, ViewDataBinding> {

    @Override
    public BaseBindingHolder createMyViewHolder(ViewGroup parent, int viewType) {
        return MixFloorListHolderGenerator.generateView(parent, viewType);
    }

    @Override
    public int getItemViewType(int position) {
        FloorData item = data.get(position);
        String type = item.getType();
        try {
            int floorType = Integer.parseInt(type);
            return floorType;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public void onBindViewHolder(BaseBindingHolder<FloorData, ViewDataBinding> holder, int position) {
        MixFloorListHolderGenerator.bindView(data.get(position), position, holder);
    }
}
