package com.example.chansiqing.databindingstudy.utils;

import com.example.chansiqing.databindingstudy.data.AutoAdapterFloorData;
import com.example.chansiqing.databindingstudy.data.BindingAdapterTestFloorData;
import com.example.chansiqing.databindingstudy.data.ListTestFloorData;
import com.example.chansiqing.databindingstudy.data.ListTestFloorItemData;
import com.example.chansiqing.databindingstudy.data.RotateFloorData;
import com.example.chansiqing.databindingstudy.data.ScrollData;
import com.example.chansiqing.databindingstudy.data.ValueAnimFloorData;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * 范例json
 *
 * @author: chansiqing
 * @date: 2018-10-25 21:30
 */
public class JsonResource {
    public static final String url = "https://m.360buyimg.com/mobilecms/jfs/t23650/360/507299913/19947/9d079f65/5b3349d7n36ef9fdb.jpg!q70.jpg.webp";
    public static final String url2 = "https://m.360buyimg.com/mobilecms/jfs/t19042/334/481621482/316610/571aaa33/5a7c2b43N3dd6ea25.jpeg!q70.jpg.webp";
    public static final String url3 = "https://m.360buyimg.com/mobilecms/s285x285_jfs/t1/17043/31/4663/199895/5c33fbd2E3a4d4bc2/0019e5c76c8bc53a.jpg!q70.jpg.webp";
    public static String[] urls = new String[]{url, url2, url3};
    public static final String listTestJson = getListTestJson();
    public static final String listTestNewJson = getListTestNewJson();
    public static final String autoAdapterJson = getAutoAdapterJson();
    public static final String bindingAdapterTestJson = getBindingAdapterTestJson();
    public static final String scrollFloorJson = getScrollFloorJson();
    public static final String rotateFloorJson = getRotateFloorJson();
    public static final String valueAnimFloorJson = getValueAnimFloorJson();
    public static final String[] list = new String[]{autoAdapterJson, bindingAdapterTestJson, listTestJson};
    public static final String[] listNew = new String[]{autoAdapterJson, bindingAdapterTestJson, scrollFloorJson, rotateFloorJson, valueAnimFloorJson, listTestNewJson};

    private static String getAutoAdapterJson() {
        AutoAdapterFloorData data = new AutoAdapterFloorData();
        data.setText("开始测试");
        data.setNeedColor(true);
        return new Gson().toJson(data);
    }

    private static String getListTestJson() {
        ArrayList<ListTestFloorItemData> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ListTestFloorItemData data2 = new ListTestFloorItemData();
            data2.setImgUrl(url);
            data2.setName("京东好货嚯嚯嚯");
            data2.setPrice("1024");
            data2.setTime(1538712000 + i * 86400);
            data2.setMarginHorizon(12);
            list.add(data2);
        }
        ListTestFloorData data = new ListTestFloorData();
        data.setList(list);
        return new Gson().toJson(data);
    }

    private static String getListTestNewJson() {
        ArrayList<ListTestFloorItemData> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ListTestFloorItemData data2 = new ListTestFloorItemData();
            data2.setImgUrl(url);
            data2.setName("京东好货嚯嚯嚯");
            data2.setPrice("1024");
            data2.setTime(1538712000 + i * 86400);
            data2.setMarginHorizon(12);
            list.add(data2);
        }
        return new Gson().toJson(list);
    }

    private static String getBindingAdapterTestJson() {
        BindingAdapterTestFloorData data = new BindingAdapterTestFloorData();
        data.setShowDefault(true);
        data.setUrl(url);
        data.setUrl2(url2);
        return new Gson().toJson(data);
    }

    private static String getScrollFloorJson() {
        ScrollData data = new ScrollData();
        data.setBgUrl("");
        data.setContentUrl("");
        return new Gson().toJson(data);
    }

    private static String getRotateFloorJson() {
        RotateFloorData data = new RotateFloorData();
        data.setTimes(2);
        return new Gson().toJson(data);
    }

    private static String getValueAnimFloorJson() {
        List<ValueAnimFloorData.ItemData> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            ValueAnimFloorData.ItemData data = new ValueAnimFloorData.ItemData();
            data.setText("这是第" + i + "个坑");
            if (JsonResource.urls != null) {
                data.setUrl(JsonResource.urls[i % 3]);
            }
            data.setExpo("expo" + i);
            list.add(data);
        }
        ValueAnimFloorData data = new ValueAnimFloorData();
        data.setItems(list);
        data.setMargin(UIUtil.dp2px(15));
        return new Gson().toJson(data);
    }

    public static void main(String[] args) {
        System.out.println(getAutoAdapterJson());
        System.out.println(getListTestJson());
        System.out.println(getValueAnimFloorJson());
    }
}