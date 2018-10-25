package com.example.chansiqing.databindingstudy.data;

import android.databinding.Bindable;
import android.os.Parcel;

import com.example.chansiqing.databindingstudy.BR;

/**
 * 双向绑定楼层数据
 *
 * @author: chansiqing
 * @date: 2018-10-11 14:17
 */
public class AutoAdapterFloorData extends BaseData {
    private String text;
    private String count;
    private boolean needColor;

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }

    @Bindable
    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
        notifyPropertyChanged(BR.count);
    }

    @Bindable
    public boolean isNeedColor() {
        return needColor;
    }

    public void setNeedColor(boolean needColor) {
        this.needColor = needColor;
        notifyPropertyChanged(BR.needColor);
    }

    public AutoAdapterFloorData() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.text);
        dest.writeString(this.count);
        dest.writeByte(this.needColor ? (byte) 1 : (byte) 0);
    }

    protected AutoAdapterFloorData(Parcel in) {
        this.text = in.readString();
        this.count = in.readString();
        this.needColor = in.readByte() != 0;
    }

    public static final Creator<AutoAdapterFloorData> CREATOR = new Creator<AutoAdapterFloorData>() {
        @Override
        public AutoAdapterFloorData createFromParcel(Parcel source) {
            return new AutoAdapterFloorData(source);
        }

        @Override
        public AutoAdapterFloorData[] newArray(int size) {
            return new AutoAdapterFloorData[size];
        }
    };
}
