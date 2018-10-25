package com.example.chansiqing.databindingstudy.floor;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.data.ListTestFloorData;
import com.example.chansiqing.databindingstudy.databinding.FloorListTestFloorBinding;
import com.example.chansiqing.databindingstudy.floor.listAdapter.ListTestFloorListAdapterSimple;

import java.util.List;

/**
 * 列表楼层
 *
 * @author: chansiqing
 * @date: 2018-10-24 16:01
 */
public class ListTestFloor extends LinearLayout {
    private FloorListTestFloorBinding binding;

    public ListTestFloor(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.floor_list_test_floor, this, true);
        binding.recycleView.setLayoutManager(new LinearLayoutManager(context));
    }

    /**
     * 设置数据源
     *
     * @param data
     */
    public void setData(List<ListTestFloorData> data) {
        ListTestFloorListAdapterSimple adapter = new ListTestFloorListAdapterSimple();
        adapter.setData(data);
        binding.recycleView.setAdapter(adapter);
    }

}
