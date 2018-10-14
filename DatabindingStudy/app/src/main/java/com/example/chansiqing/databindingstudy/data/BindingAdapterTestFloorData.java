package com.example.chansiqing.databindingstudy.data;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.chansiqing.databindingstudy.BR;

/**
 * bindingAdapter注解使用test数据源
 *
 * @author: chansiqing
 * @date: 2018-10-12 14:53
 */
public class BindingAdapterTestFloorData extends BaseObservable implements Parcelable, Observable {
    private boolean showDefault;
    private String url;
    private String url2;
    private transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();


    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        notifyChange(BR.url);
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

    public BindingAdapterTestFloorData() {
    }

    @Bindable
    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
        notifyChange(BR.url2);
    }

    @Bindable
    public boolean getShowDefault() {
        return showDefault;
    }

    public void setShowDefault(boolean showDefault) {
        this.showDefault = showDefault;
        notifyChange(BR.showDefault);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.showDefault ? (byte) 1 : (byte) 0);
        dest.writeString(this.url);
        dest.writeString(this.url2);
    }

    protected BindingAdapterTestFloorData(Parcel in) {
        this.showDefault = in.readByte() != 0;
        this.url = in.readString();
        this.url2 = in.readString();
    }

    public static final Creator<BindingAdapterTestFloorData> CREATOR = new Creator<BindingAdapterTestFloorData>() {
        @Override
        public BindingAdapterTestFloorData createFromParcel(Parcel source) {
            return new BindingAdapterTestFloorData(source);
        }

        @Override
        public BindingAdapterTestFloorData[] newArray(int size) {
            return new BindingAdapterTestFloorData[size];
        }
    };
}
