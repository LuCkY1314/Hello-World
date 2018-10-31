package com.example.chansiqing.databindingstudy.utils;

import android.view.ViewGroup;

import com.example.chansiqing.databindingstudy.data.AutoAdapterFloorData;
import com.example.chansiqing.databindingstudy.data.BindingAdapterTestFloorData;
import com.example.chansiqing.databindingstudy.data.FloorData;
import com.example.chansiqing.databindingstudy.data.ListTestFloorData;
import com.example.chansiqing.databindingstudy.floor.AutoAdapterFloor;
import com.example.chansiqing.databindingstudy.floor.BindingAdapterTestFloor;
import com.example.chansiqing.databindingstudy.floor.FloorMatchDataInterface;
import com.example.chansiqing.databindingstudy.floor.ListTestFloor;
import com.example.chansiqing.databindingstudy.floor.listHolder.MixFloorBaseHolder;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.chansiqing.databindingstudy.utils.FloorTypeUtil.FLOOR_AUTO_ADAPTER;
import static com.example.chansiqing.databindingstudy.utils.FloorTypeUtil.FLOOR_BINDING_TEST;
import static com.example.chansiqing.databindingstudy.utils.FloorTypeUtil.FLOOR_LIST_TEST;

/**
 * 混合楼层中每个楼层生成器
 *
 * @author: chansiqing
 * @date: 2018-10-30 17:44
 */
public class MixFloorListNormalHolderGenerator {

    /**
     * 楼层生成
     *
     * @param parent
     * @param viewType
     * @return
     */
    public static MixFloorBaseHolder generateHolder(ViewGroup parent, int viewType) {
        FloorMatchDataInterface view = null;
        switch (viewType) {
            case FLOOR_AUTO_ADAPTER:
                view = new AutoAdapterFloor(parent.getContext());
                break;
            case FLOOR_LIST_TEST:
                view = new ListTestFloor(parent.getContext());
                break;
            case FLOOR_BINDING_TEST:
                view = new BindingAdapterTestFloor(parent.getContext());
                break;
        }
        return new MixFloorBaseHolder(view);
    }

    /**
     * 数据绑定
     *
     * @param item
     * @param position
     * @param holder
     */
    public static void bindData(FloorData item, int position, MixFloorBaseHolder holder) {
        String type = item.getType();
        int floorType;
        try {
            floorType = Integer.parseInt(type);
        } catch (Exception e) {
            return;
        }
        Object data = null;
        switch (floorType) {
            case FLOOR_AUTO_ADAPTER:
                data = new Gson().fromJson(item.getFloorJson(), AutoAdapterFloorData.class);
                break;
            case FLOOR_LIST_TEST:
                ListTestFloorData[] listTestFloorData = new Gson().fromJson(item.getFloorJson(), ListTestFloorData[].class);
                data = new ArrayList(Arrays.asList(listTestFloorData));
                break;
            case FLOOR_BINDING_TEST:
                data = new Gson().fromJson(item.getFloorJson(), BindingAdapterTestFloorData.class);
                break;
        }
        if (data == null) return;
        holder.bindData(data);
    }
}
