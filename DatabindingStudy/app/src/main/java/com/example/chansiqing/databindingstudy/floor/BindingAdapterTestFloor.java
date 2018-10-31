package com.example.chansiqing.databindingstudy.floor;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.data.BindingAdapterTestFloorData;
import com.example.chansiqing.databindingstudy.databinding.FloorBindingAdapterTestBinding;
import com.example.chansiqing.databindingstudy.floor.listHolder.MixFloorBaseHolder;

/**
 * 自定义xml属性适配实验楼层
 *
 * @author: chansiqing
 * @date: 2018-10-12 14:51
 */
public class BindingAdapterTestFloor extends LinearLayout implements FloorMatchDataInterface {
    private FloorBindingAdapterTestBinding binding;

    public BindingAdapterTestFloor(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.floor_binding_adapter_test, this, true);
    }

    public void setModel(BindingAdapterTestFloorData data) {
        binding.setItem(data);
        //如果不用dataBinding，此处要给相应控件赋值
    }

    @Override
    public void adapterData(Object data) {
        if (data instanceof BindingAdapterTestFloorData)
            setModel((BindingAdapterTestFloorData) data);
    }
}
