package com.example.chansiqing.databindingstudy.data;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;
import android.os.Parcel;

import com.example.chansiqing.databindingstudy.BR;


/**
 * 列表楼层数据
 *
 * @author: chansiqing
 * @date: 2018-10-24 16:02
 */
public class ListTestFloorData extends BaseData implements Observable {
    private String imgUrl; //商品展示图
    private String price;   //商品价格
    private String name;   //商品名
    private long time;     //发布时间
    private boolean isNew; //是否最新发布
    private int marginHorizon;//左右边距


    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    private transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();

    @Bindable
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        notifyChange(BR.imgUrl);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyChange(BR.name);
    }

    @Bindable
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
        notifyChange(BR.price);
    }

    @Bindable
    public int getMarginHorizon() {
        return marginHorizon;
    }

    public void setMarginHorizon(int marginHorizon) {
        this.marginHorizon = marginHorizon;
        notifyChange(BR.marginHorizon);
    }

    @Bindable
    public boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
        notifyChange(BR.isNew);
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

    public ListTestFloorData() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imgUrl);
        dest.writeString(this.price);
        dest.writeString(this.name);
        dest.writeLong(this.time);
        dest.writeByte(this.isNew ? (byte) 1 : (byte) 0);
        dest.writeInt(this.marginHorizon);
    }

    protected ListTestFloorData(Parcel in) {
        this.imgUrl = in.readString();
        this.price = in.readString();
        this.name = in.readString();
        this.time = in.readLong();
        this.isNew = in.readByte() != 0;
        this.marginHorizon = in.readInt();
    }

    public static final Creator<ListTestFloorData> CREATOR = new Creator<ListTestFloorData>() {
        @Override
        public ListTestFloorData createFromParcel(Parcel source) {
            return new ListTestFloorData(source);
        }

        @Override
        public ListTestFloorData[] newArray(int size) {
            return new ListTestFloorData[size];
        }
    };
}
