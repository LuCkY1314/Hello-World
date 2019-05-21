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

/**
 * 启动页数据
 *
 * @author: chansiqing
 * @date: 2018-09-30 14:41
 */
public class MainFrameData extends BaseData {
    private ItemBtnData btn1, btn2, btn3, btn4, btn5;

    public MainFrameData() {
    }

    public ItemBtnData getBtn1() {
        return btn1;
    }

    public void setBtn1(ItemBtnData btn1) {
        this.btn1 = btn1;
    }

    public ItemBtnData getBtn2() {
        return btn2;
    }

    public void setBtn2(ItemBtnData btn2) {
        this.btn2 = btn2;
    }

    public ItemBtnData getBtn3() {
        return btn3;
    }

    public void setBtn3(ItemBtnData btn3) {
        this.btn3 = btn3;
    }

    public ItemBtnData getBtn4() {
        return btn4;
    }

    public void setBtn4(ItemBtnData btn4) {
        this.btn4 = btn4;
    }

    public ItemBtnData getBtn5() {
        return btn5;
    }

    public void setBtn5(ItemBtnData btn5) {
        this.btn5 = btn5;
    }

    public static class ItemBtnData implements Parcelable {
        private String simpleBtnName;
        private boolean simpleBtnVisible;
        private String simpleBtnDrawableUrl;
        private int marginHorizon;
        private int marginVertical;

        public String getSimpleBtnName() {
            return simpleBtnName;
        }

        public void setSimpleBtnName(String simpleBtnName) {
            this.simpleBtnName = simpleBtnName;
        }

        public boolean isSimpleBtnVisible() {
            return simpleBtnVisible;
        }

        public void setSimpleBtnVisible(boolean simpleBtnVisible) {
            this.simpleBtnVisible = simpleBtnVisible;
        }

        public String getSimpleBtnDrawableUrl() {
            return simpleBtnDrawableUrl;
        }

        public void setSimpleBtnDrawableUrl(String simpleBtnDrawableUrl) {
            this.simpleBtnDrawableUrl = simpleBtnDrawableUrl;
        }

        public int getMarginHorizon() {
            return marginHorizon;
        }

        public void setMarginHorizon(int marginHorizon) {
            this.marginHorizon = marginHorizon;
        }

        public int getMarginVertical() {
            return marginVertical;
        }

        public void setMarginVertical(int marginVertical) {
            this.marginVertical = marginVertical;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.simpleBtnName);
            dest.writeByte(this.simpleBtnVisible ? (byte) 1 : (byte) 0);
            dest.writeString(this.simpleBtnDrawableUrl);
            dest.writeInt(this.marginHorizon);
            dest.writeInt(this.marginVertical);
        }

        public ItemBtnData() {
        }

        protected ItemBtnData(Parcel in) {
            this.simpleBtnName = in.readString();
            this.simpleBtnVisible = in.readByte() != 0;
            this.simpleBtnDrawableUrl = in.readString();
            this.marginHorizon = in.readInt();
            this.marginVertical = in.readInt();
        }

        public static final Creator<ItemBtnData> CREATOR = new Creator<ItemBtnData>() {
            @Override
            public ItemBtnData createFromParcel(Parcel source) {
                return new ItemBtnData(source);
            }

            @Override
            public ItemBtnData[] newArray(int size) {
                return new ItemBtnData[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.btn1, flags);
        dest.writeParcelable(this.btn2, flags);
        dest.writeParcelable(this.btn3, flags);
        dest.writeParcelable(this.btn4, flags);
        dest.writeParcelable(this.btn5, flags);
    }

    protected MainFrameData(Parcel in) {
        this.btn1 = in.readParcelable(ItemBtnData.class.getClassLoader());
        this.btn2 = in.readParcelable(ItemBtnData.class.getClassLoader());
        this.btn3 = in.readParcelable(ItemBtnData.class.getClassLoader());
        this.btn4 = in.readParcelable(ItemBtnData.class.getClassLoader());
        this.btn5 = in.readParcelable(ItemBtnData.class.getClassLoader());
    }

    public static final Creator<MainFrameData> CREATOR = new Creator<MainFrameData>() {
        @Override
        public MainFrameData createFromParcel(Parcel source) {
            return new MainFrameData(source);
        }

        @Override
        public MainFrameData[] newArray(int size) {
            return new MainFrameData[size];
        }
    };
}
