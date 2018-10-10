/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.chansiqing.databindingstudy.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Observable;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2018-10-10 10:40
 */
public class AllFloorData extends Observable implements Parcelable{
    protected AllFloorData(Parcel in) {
    }

    public static final Creator<AllFloorData> CREATOR = new Creator<AllFloorData>() {
        @Override
        public AllFloorData createFromParcel(Parcel in) {
            return new AllFloorData(in);
        }

        @Override
        public AllFloorData[] newArray(int size) {
            return new AllFloorData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
