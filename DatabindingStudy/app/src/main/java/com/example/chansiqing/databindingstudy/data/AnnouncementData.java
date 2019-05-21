package com.example.chansiqing.databindingstudy.data;

import android.os.Parcel;

import java.util.List;


/**
 * 循环轮播通告model
 *
 * @author: chansiqing
 * @date: 2019-03-12 10:22
 */


public class AnnouncementData extends BaseData {
    private String url;
    private String adText;
    private String operateText;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdText() {
        return adText;
    }

    public void setAdText(String adText) {
        this.adText = adText;
    }

    public String getOperateText() {
        return operateText;
    }

    public void setOperateText(String operateText) {
        this.operateText = operateText;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.adText);
        dest.writeString(this.operateText);
    }

    public AnnouncementData() {
    }

    protected AnnouncementData(Parcel in) {
        this.url = in.readString();
        this.adText = in.readString();
        this.operateText = in.readString();
    }

    public static final Creator<AnnouncementData> CREATOR = new Creator<AnnouncementData>() {
        @Override
        public AnnouncementData createFromParcel(Parcel source) {
            return new AnnouncementData(source);
        }

        @Override
        public AnnouncementData[] newArray(int size) {
            return new AnnouncementData[size];
        }
    };
}


