/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.chansiqing.databindingstudy.data;

import android.databinding.Bindable;
import android.databinding.PropertyChangeRegistry;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.chansiqing.databindingstudy.BR;

import java.util.Observable;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2018-10-10 10:40
 */
public class AllFloorData extends Observable implements Parcelable, android.databinding.Observable {
    private String text;
    private transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyChange(BR.text);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.text);
    }

    public AllFloorData() {
    }

    protected AllFloorData(Parcel in) {
        this.text = in.readString();
    }

    public static final Creator<AllFloorData> CREATOR = new Creator<AllFloorData>() {
        @Override
        public AllFloorData createFromParcel(Parcel source) {
            return new AllFloorData(source);
        }

        @Override
        public AllFloorData[] newArray(int size) {
            return new AllFloorData[size];
        }
    };

    private synchronized void notifyChange(int propertyId) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.notifyChange(this, propertyId);
    }

    @Override
    public synchronized void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.add(callback);

    }

    @Override
    public synchronized void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry != null) {
            propertyChangeRegistry.remove(callback);
        }
    }
}
