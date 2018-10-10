/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.chansiqing.databindingstudy.data;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.chansiqing.databindingstudy.BR;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2018-10-10 11:18
 */
public class FlipperData extends BaseObservable implements Parcelable {
    private String url;
    private String text;

    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.text);
    }

    public FlipperData() {
    }

    protected FlipperData(Parcel in) {
        this.url = in.readString();
        this.text = in.readString();
    }

    public static final Creator<FlipperData> CREATOR = new Creator<FlipperData>() {
        @Override
        public FlipperData createFromParcel(Parcel source) {
            return new FlipperData(source);
        }

        @Override
        public FlipperData[] newArray(int size) {
            return new FlipperData[size];
        }
    };
}
