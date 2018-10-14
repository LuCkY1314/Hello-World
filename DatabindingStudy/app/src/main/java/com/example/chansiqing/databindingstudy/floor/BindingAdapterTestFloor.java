package com.example.chansiqing.databindingstudy.floor;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.data.BindingAdapterTestFloorData;
import com.example.chansiqing.databindingstudy.databinding.FloorBindingAdapterTestBinding;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2018-10-12 14:51
 */
public class BindingAdapterTestFloor extends LinearLayout {
    private FloorBindingAdapterTestBinding binding;

    public BindingAdapterTestFloor(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.floor_binding_adapter_test, this, true);
    }

    public void setData(BindingAdapterTestFloorData data) {
        binding.setItem(data);
    }
}
