package com.example.chansiqing.databindingstudy.data;

import android.os.Parcel;

/**
 * 底部导航栏数据结构
 *
 * @author: chansiqing
 * @date: 2019-02-13 14:42
 */
public class TabData extends BaseData {
    private String image;
    private String text;
    private boolean hasPoint;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isHasPoint() {
        return hasPoint;
    }

    public void setHasPoint(boolean hasPoint) {
        this.hasPoint = hasPoint;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.image);
        dest.writeString(this.text);
        dest.writeByte(this.hasPoint ? (byte) 1 : (byte) 0);
    }

    public TabData() {
    }

    protected TabData(Parcel in) {
        this.image = in.readString();
        this.text = in.readString();
        this.hasPoint = in.readByte() != 0;
    }

    public static final Creator<TabData> CREATOR = new Creator<TabData>() {
        @Override
        public TabData createFromParcel(Parcel source) {
            return new TabData(source);
        }

        @Override
        public TabData[] newArray(int size) {
            return new TabData[size];
        }
    };
}
