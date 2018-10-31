package com.example.chansiqing.databindingstudy.floor.listAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.chansiqing.databindingstudy.data.FloorData;
import com.example.chansiqing.databindingstudy.floor.listHolder.MixFloorBaseHolder;
import com.example.chansiqing.databindingstudy.utils.MixFloorListNormalHolderGenerator;

import java.util.List;

/**
 * 混合楼层整体的适配器
 *
 * @author: chansiqing
 * @date: 2018-10-30 17:41
 */
public class MixFloorListNormalAdapter extends RecyclerView.Adapter<MixFloorBaseHolder> {
    private List<FloorData> list;

    @Override
    public MixFloorBaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return MixFloorListNormalHolderGenerator.generateHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(MixFloorBaseHolder holder, int position) {
        FloorData item = list.get(position);
        if (item == null) return;
        MixFloorListNormalHolderGenerator.bindData(item, position, holder);
    }

    @Override
    public int getItemViewType(int position) {
        FloorData item = list.get(position);
        String type = item.getType();
        try {
            int floorType = Integer.parseInt(type);
            return floorType;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public void setData(List<FloorData> data) {
        if (data == null) return;
        list = data;
    }
}
