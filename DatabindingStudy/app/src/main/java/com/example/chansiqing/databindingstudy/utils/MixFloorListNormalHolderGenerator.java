package com.example.chansiqing.databindingstudy.utils;

import android.content.Context;
import android.view.ViewGroup;

import com.example.chansiqing.databindingstudy.data.AutoAdapterFloorData;
import com.example.chansiqing.databindingstudy.data.BindingAdapterTestFloorData;
import com.example.chansiqing.databindingstudy.data.FloorData;
import com.example.chansiqing.databindingstudy.data.ListTestFloorData;
import com.example.chansiqing.databindingstudy.data.ListTestFloorItemData;
import com.example.chansiqing.databindingstudy.data.RotateFloorData;
import com.example.chansiqing.databindingstudy.data.ScrollData;
import com.example.chansiqing.databindingstudy.floor.AutoAdapterFloor;
import com.example.chansiqing.databindingstudy.floor.BindingAdapterTestFloor;
import com.example.chansiqing.databindingstudy.floor.FloorMatchDataInterface;
import com.example.chansiqing.databindingstudy.floor.ListTestFloor;
import com.example.chansiqing.databindingstudy.floor.RotateAnimFloor;
import com.example.chansiqing.databindingstudy.floor.ScrollFloor;
import com.example.chansiqing.databindingstudy.floor.listHolder.MixFloorBaseHolder;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.chansiqing.databindingstudy.utils.FloorTypeUtil.FLOOR_AUTO_ADAPTER;
import static com.example.chansiqing.databindingstudy.utils.FloorTypeUtil.FLOOR_BINDING_TEST;
import static com.example.chansiqing.databindingstudy.utils.FloorTypeUtil.FLOOR_LIST_TEST;
import static com.example.chansiqing.databindingstudy.utils.FloorTypeUtil.FLOOR_ROTATE_ANIM;
import static com.example.chansiqing.databindingstudy.utils.FloorTypeUtil.FLOOR_SCROLL;

/**
 * 混合楼层中每个楼层生成器
 * 优势是：读起来比较容易理解
 * 缺点是：1、相应的楼层类文件增加
 * 2、比用dataBinding结合的holder要多实现一个接口MixFloorBaseHolder，且每个楼层都必须自主实现
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
        return new MixFloorBaseHolder(pickFloor(parent.getContext(), viewType));
    }

    /**
     * 数据绑定操作
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
        Object data = translateData(floorType, item);
        if (data == null) return;
        holder.bindData(data);
    }

    /**
     * 根据楼层将json转化成对应数据类型
     * 楼层增加只要在这里进行更改
     *
     * @param floorType
     * @param item
     * @return
     */
    private static Object translateData(int floorType, FloorData item) {
        Object data = null;
        switch (floorType) {
            case FLOOR_AUTO_ADAPTER:
                data = new Gson().fromJson(item.getFloorJson(), AutoAdapterFloorData.class);
                break;
            case FLOOR_LIST_TEST:
                ListTestFloorItemData[] listTestFloorItemData = new Gson().fromJson(item.getFloorJson(), ListTestFloorItemData[].class);
                data = new ArrayList(Arrays.asList(listTestFloorItemData));
                break;
            case FLOOR_BINDING_TEST:
                data = new Gson().fromJson(item.getFloorJson(), BindingAdapterTestFloorData.class);
                break;
            case FLOOR_SCROLL:
                data = new Gson().fromJson(item.getFloorJson(), ScrollData.class);
                break;
            case FLOOR_ROTATE_ANIM:
                data = new Gson().fromJson(item.getFloorJson(), RotateFloorData.class);
                break;
        }
        return data;
    }

    /**
     * 根据type拿到对应的楼层实体
     * 新增楼层需要在此处增加枚举和view
     *
     * @param context
     * @param viewType
     * @return
     */
    private static FloorMatchDataInterface pickFloor(Context context, int viewType) {
        FloorMatchDataInterface view = null;
        switch (viewType) {
            case FLOOR_AUTO_ADAPTER:
                view = new AutoAdapterFloor(context);
                break;
            case FLOOR_LIST_TEST:
                view = new ListTestFloor(context);
                break;
            case FLOOR_BINDING_TEST:
                view = new BindingAdapterTestFloor(context);
                break;
            case FLOOR_SCROLL:
                view = new ScrollFloor(context);
                break;
            case FLOOR_ROTATE_ANIM:
                view = new RotateAnimFloor(context);
                break;
        }
        return view;
    }
}
