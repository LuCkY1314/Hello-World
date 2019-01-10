package com.example.chansiqing.databindingstudy.data;

import android.os.Parcel;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2019-01-02 15:18
 */
public class RotateFloorData extends BaseData {
    private int times;

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.times);
    }

    public RotateFloorData() {
    }

    protected RotateFloorData(Parcel in) {
        this.times = in.readInt();
    }

    public static final Creator<RotateFloorData> CREATOR = new Creator<RotateFloorData>() {
        @Override
        public RotateFloorData createFromParcel(Parcel source) {
            return new RotateFloorData(source);
        }

        @Override
        public RotateFloorData[] newArray(int size) {
            return new RotateFloorData[size];
        }
    };
}
