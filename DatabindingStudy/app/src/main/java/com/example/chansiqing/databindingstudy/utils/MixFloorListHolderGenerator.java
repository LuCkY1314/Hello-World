package com.example.chansiqing.databindingstudy.utils;


import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
import com.example.chansiqing.databindingstudy.viewModel.ListTestFloorPresenter;
import com.google.gson.Gson;

import static com.example.chansiqing.databindingstudy.utils.FloorTypeUtil.FLOOR_AUTO_ADAPTER;
import static com.example.chansiqing.databindingstudy.utils.FloorTypeUtil.FLOOR_BINDING_TEST;
import static com.example.chansiqing.databindingstudy.utils.FloorTypeUtil.FLOOR_LIST_TEST;

/**
 * dataBindingHolder生成器
 * 优势是：1、可以生成匿名内部类，减少楼层类文件的数量
 * 2、dataBinding内部有自动生成的设置数据的供外部调用的方法，省去了每个viewHolder必须实现一个借口达成公共调用的过程
 * 缺点是：初次使用会感觉陌生
 *
 * @author: chansiqing
 * @date: 2018-10-26 14:50
 */
public class MixFloorListHolderGenerator {
    /**
     * 生成对应楼层的dataBinding
     * 每次新增楼层需要在此方法中新增枚举以及对应的BaseBindingHolder子类
     *
     * @param parent
     * @param viewType
     * @return
     */
    public static BaseBindingHolder generateView(final ViewGroup parent, int viewType) {
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
                        return new OnItemClickListener<AutoAdapterFloorData>() {
                            @Override
                            public void onClick(AutoAdapterFloorData item, int position) {
                                Toast.makeText(parent.getContext(), item.getClass().toString() + position, Toast.LENGTH_SHORT).show();
                            }
                        };
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
                        return new OnItemClickListener<ListTestFloorData>() {
                            @Override
                            public void onClick(ListTestFloorData item, int position) {
                                Toast.makeText(parent.getContext(), item.getClass().toString() + position, Toast.LENGTH_SHORT).show();
                            }
                        };
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
                        return new OnItemClickListener<BindingAdapterTestFloorData>() {
                            @Override
                            public void onClick(BindingAdapterTestFloorData item, int position) {
                                Toast.makeText(parent.getContext(), item.getClass().toString() + position, Toast.LENGTH_SHORT).show();
                            }
                        };
                    }
                };
            default:
                return null;
        }
    }

    /**
     * 给dataBindingHolder绑定数据
     *
     * @param item
     * @param position
     * @param holder
     */
    public static void bindView(FloorData item, final int position, final BaseBindingHolder holder) {
        String type = item.getType();
        int floorType;
        try {
            floorType = Integer.parseInt(type);
        } catch (Exception e) {
            return;
        }
        BaseData data = new Gson().fromJson(item.getFloorJson(), getDataType(floorType));
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

    /**
     * 拿到对应type的数据类型
     * 每次新增楼层需要在此处添加枚举和对应数据类型
     *
     * @param viewType
     * @return
     */
    private static Class<? extends BaseData> getDataType(int viewType) {
        switch (viewType) {
            case FLOOR_AUTO_ADAPTER:
                return AutoAdapterFloorData.class;
            case FLOOR_LIST_TEST:
                return ListTestFloorData.class;
            case FLOOR_BINDING_TEST:
                return BindingAdapterTestFloorData.class;
            default:
                return BaseData.class;
        }
    }
}
