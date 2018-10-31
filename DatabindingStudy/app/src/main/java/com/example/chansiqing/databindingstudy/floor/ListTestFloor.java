package com.example.chansiqing.databindingstudy.floor;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.chansiqing.databindingstudy.BR;
import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.data.ListTestFloorData;
import com.example.chansiqing.databindingstudy.databinding.FloorListTestFloorBinding;
import com.example.chansiqing.databindingstudy.floor.listHolder.MixFloorBaseHolder;
import com.example.chansiqing.databindingstudy.viewModel.ListTestFloorPresenter;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * 列表楼层
 *
 * @author: chansiqing
 * @date: 2018-10-24 16:01
 */
public class ListTestFloor extends LinearLayout implements FloorMatchDataInterface {
    private FloorListTestFloorBinding binding;

    public ListTestFloor(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.floor_list_test_floor, this, true);
        binding.recycle.setLayoutManager(new LinearLayoutManager(context));
        binding.setPresenter(new ListTestFloorPresenter());
    }

    /**
     * 设置数据源
     *
     * @param data
     */
    public void setModel(ArrayList<ListTestFloorData> data) {
//        ListTestFloorListAdapterSimple adapter = new ListTestFloorListAdapterSimple();
//        adapter.adapterData(data);
//        binding.recycle.setAdapter(adapter);
        binding.setVariable(BR.item, data);
    }

    @Override
    public void adapterData(Object data) {
        if (data instanceof ArrayList) {
            setModel((ArrayList<ListTestFloorData>) data);
        }
    }
}
