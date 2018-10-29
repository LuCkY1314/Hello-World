package com.example.chansiqing.databindingstudy.data;

import android.os.Parcel;

/**
 * 混合楼层的存每个楼层数据基类
 *
 * @author: chansiqing
 * @date: 2018-10-26 10:45
 */
public class FloorData extends BaseData {
    private String type;      //楼层类型
    private String floorJson; //楼层内数据源json

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFloorJson() {
        return floorJson;
    }

    public void setFloorJson(String floorJson) {
        this.floorJson = floorJson;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeString(this.floorJson);
    }

    public FloorData() {
    }

    protected FloorData(Parcel in) {
        this.type = in.readString();
        this.floorJson = in.readString();
    }

    public static final Creator<FloorData> CREATOR = new Creator<FloorData>() {
        @Override
        public FloorData createFromParcel(Parcel source) {
            return new FloorData(source);
        }

        @Override
        public FloorData[] newArray(int size) {
            return new FloorData[size];
        }
    };
}
