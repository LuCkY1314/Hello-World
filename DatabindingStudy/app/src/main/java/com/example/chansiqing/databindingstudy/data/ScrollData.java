package com.example.chansiqing.databindingstudy.data;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;
import android.os.Parcel;

import com.example.chansiqing.databindingstudy.BR;

/**
 * 滑动楼层数据
 *
 * @author: chansiqing
 * @date: 2018-12-26 19:38
 */
public class ScrollData extends BaseData implements Observable {
    private String bgUrl;
    private String contentUrl;
    private transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();


    @Bindable
    public String getBgUrl() {
        return bgUrl;
    }

    public void setBgUrl(String bgUrl) {
        this.bgUrl = bgUrl;
        notifyChange(BR.bgUrl);
    }

    @Bindable
    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
        notifyChange(BR.contentUrl);
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.bgUrl);
        dest.writeString(this.contentUrl);
    }

    public ScrollData() {
    }

    protected ScrollData(Parcel in) {
        this.bgUrl = in.readString();
        this.contentUrl = in.readString();
    }

    public static final Creator<ScrollData> CREATOR = new Creator<ScrollData>() {
        @Override
        public ScrollData createFromParcel(Parcel source) {
            return new ScrollData(source);
        }

        @Override
        public ScrollData[] newArray(int size) {
            return new ScrollData[size];
        }
    };
}
