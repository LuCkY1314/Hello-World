package com.example.chansiqing.databindingstudy.utils;


import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chansiqing.databindingstudy.BR;
import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.data.AutoAdapterFloorData;
import com.example.chansiqing.databindingstudy.data.BaseData;
import com.example.chansiqing.databindingstudy.data.BindingAdapterTestFloorData;
import com.example.chansiqing.databindingstudy.data.FloorData;
import com.example.chansiqing.databindingstudy.data.ListTestFloorData;
import com.example.chansiqing.databindingstudy.databinding.FloorAutoAdapterBinding;
import com.example.chansiqing.databindingstudy.databinding.FloorBindingAdapterTestBinding;
import com.example.chansiqing.databindingstudy.databinding.FloorListTestFloorBinding;
import com.example.chansiqing.databindingstudy.floor.listHolder.BaseBindingHolder;
import com.example.chansiqing.databindingstudy.viewModel.AutoAdapterFloorPresenter;
import com.example.chansiqing.databindingstudy.viewModel.BasePresenter;
import com.example.chansiqing.databindingstudy.viewModel.BindingAdapterTestFloorPresenter;
import com.example.chansiqing.databindingstudy.viewModel.ListTestFloorItemPresenter;
import com.example.chansiqing.databindingstudy.viewModel.ListTestFloorPresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.chansiqing.databindingstudy.utils.FloorTypeUtil.FLOOR_AUTO_ADAPTER;
import static com.example.chansiqing.databindingstudy.utils.FloorTypeUtil.FLOOR_BINDING_TEST;
import static com.example.chansiqing.databindingstudy.utils.FloorTypeUtil.FLOOR_LIST_TEST;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2018-10-26 14:50
 */
public class MixFloorListHolderGenerator {
    public static BaseBindingHolder generateView(ViewGroup parent, int viewType) {
        switch (viewType) {
            case FLOOR_AUTO_ADAPTER:
                FloorAutoAdapterBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.floor_auto_adapter, parent, false);
                return new BaseBindingHolder<AutoAdapterFloorData, FloorAutoAdapterBinding>(binding) {
                    @Override
                    public BasePresenter getPresenter() {
                        return new AutoAdapterFloorPresenter();
                    }

                    @Override
                    public OnItemClickListener<AutoAdapterFloorData> getOnItemClickListener() {
                        return super.getOnItemClickListener();
                    }
                };
            case FLOOR_LIST_TEST:
                FloorListTestFloorBinding listTestFloorBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.floor_list_test_floor, parent, true);
                return new BaseBindingHolder<ListTestFloorData, FloorListTestFloorBinding>(listTestFloorBinding) {
                    @Override
                    public BasePresenter getPresenter() {
                        return new ListTestFloorPresenter();
                    }

                    @Override
                    public OnItemClickListener<ListTestFloorData> getOnItemClickListener() {
                        return super.getOnItemClickListener();
                    }
                };
            case FLOOR_BINDING_TEST:
                FloorBindingAdapterTestBinding bindingAdapterTestBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.floor_binding_adapter_test, parent, false);
                return new BaseBindingHolder<BindingAdapterTestFloorData, FloorBindingAdapterTestBinding>(bindingAdapterTestBinding) {
                    @Override
                    public BasePresenter getPresenter() {
                        return new BindingAdapterTestFloorPresenter();
                    }

                    @Override
                    public OnItemClickListener<BindingAdapterTestFloorData> getOnItemClickListener() {
                        return super.getOnItemClickListener();
                    }
                };
            default:
                return null;
        }
    }

    public static void bindView(final FloorData item, final int position, final BaseBindingHolder holder) {
        String type = item.getType();
        int floorType;
        try {
            floorType = Integer.parseInt(type);
        } catch (Exception e) {
            return;
        }
        BaseData data = null;
        ArrayList list = new ArrayList<>();
        switch (floorType) {
            case FLOOR_AUTO_ADAPTER:
                data = new Gson().fromJson(item.getFloorJson(), AutoAdapterFloorData.class);
                break;
            case FLOOR_LIST_TEST:
                ListTestFloorData[] listTestFloorData = new Gson().fromJson(item.getFloorJson(), ListTestFloorData[].class);
                list = new ArrayList(Arrays.asList(listTestFloorData));
                break;
            case FLOOR_BINDING_TEST:
                data = new Gson().fromJson(item.getFloorJson(), BindingAdapterTestFloorData.class);
                break;
        }
        if (list.size() > 0) {
            holder.getDataBinding().setVariable(BR.item, list);
            final List<? extends BaseData> finalList = list;
            holder.getDataBinding().getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BaseBindingHolder.OnItemClickListener onItemClickListener = holder.getOnItemClickListener();
                    if (onItemClickListener == null) return;
                    onItemClickListener.onClick(finalList, position);
                }
            });
            return;
        }
        if (data == null) return;
        holder.getDataBinding().setVariable(BR.item, data);
        final BaseData finalData = data;
        holder.getDataBinding().getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseBindingHolder.OnItemClickListener onItemClickListener = holder.getOnItemClickListener();
                if (onItemClickListener == null) return;
                onItemClickListener.onClick(finalData, position);
            }
        });
    }
}
