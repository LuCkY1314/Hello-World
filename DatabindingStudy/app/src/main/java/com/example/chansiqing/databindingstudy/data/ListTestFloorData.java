package com.example.chansiqing.databindingstudy.data;


import android.databinding.Observable;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;


/**
 * 列表楼层总数据
 *
 * @author: chansiqing
 * @date: 2018-10-24 16:02
 */
public class ListTestFloorData extends BaseData implements Observable {
    private ArrayList<ListTestFloorItemData> list = new ArrayList<>();

    public ArrayList<ListTestFloorItemData> getList() {
        return list;
    }

    public void setList(ArrayList<ListTestFloorItemData> list) {
        this.list = list;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.list);
    }

    public ListTestFloorData() {
    }

    protected ListTestFloorData(Parcel in) {
        this.list = in.createTypedArrayList(ListTestFloorItemData.CREATOR);
    }

    public static final Creator<ListTestFloorData> CREATOR = new Creator<ListTestFloorData>() {
        @Override
        public ListTestFloorData createFromParcel(Parcel source) {
            return new ListTestFloorData(source);
        }

        @Override
        public ListTestFloorData[] newArray(int size) {
            return new ListTestFloorData[size];
        }
    };
}
