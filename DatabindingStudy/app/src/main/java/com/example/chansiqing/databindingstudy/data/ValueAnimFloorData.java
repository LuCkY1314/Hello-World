package com.example.chansiqing.databindingstudy.data;

import android.os.Parcel;

import java.util.List;

/**
 * 属性动画的楼层数据model
 *
 * @author: chansiqing
 * @date: 2019-01-25 18:42
 */
public class ValueAnimFloorData extends BaseData {
    private int margin;
    private List<ItemData> items;

    public List<ItemData> getItems() {
        return items;
    }

    public void setItems(List<ItemData> items) {
        this.items = items;
    }

    public int getMargin() {
        return margin;
    }

    public void setMargin(int margin) {
        this.margin = margin;
    }

    public ValueAnimFloorData() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.margin);
        dest.writeTypedList(this.items);
    }

    protected ValueAnimFloorData(Parcel in) {
        this.margin = in.readInt();
        this.items = in.createTypedArrayList(ItemData.CREATOR);
    }

    public static final Creator<ValueAnimFloorData> CREATOR = new Creator<ValueAnimFloorData>() {
        @Override
        public ValueAnimFloorData createFromParcel(Parcel source) {
            return new ValueAnimFloorData(source);
        }

        @Override
        public ValueAnimFloorData[] newArray(int size) {
            return new ValueAnimFloorData[size];
        }
    };

    public static class ItemData extends BaseData {
        private String url;
        private String text;
        private String expo;

        public String getExpo() {
            return expo;
        }

        public void setExpo(String expo) {
            this.expo = expo;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public ItemData() {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.url);
            dest.writeString(this.text);
            dest.writeString(this.expo);
        }

        protected ItemData(Parcel in) {
            this.url = in.readString();
            this.text = in.readString();
            this.expo = in.readString();
        }

        public static final Creator<ItemData> CREATOR = new Creator<ItemData>() {
            @Override
            public ItemData createFromParcel(Parcel source) {
                return new ItemData(source);
            }

            @Override
            public ItemData[] newArray(int size) {
                return new ItemData[size];
            }
        };
    }
}
