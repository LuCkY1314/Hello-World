package com.example.chansiqing.databindingstudy.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2018-08-24 15:29
 */
public class Entity implements Parcelable {
    private String title;
    private String path;
    private int width;
    private int height;
    private String sizeOne;
    private String sizeTwo;
    private int flag;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSizeOne() {
        return sizeOne;
    }

    public void setSizeOne(String size) {
        this.sizeOne = size;
    }

    public String getSizeTwo() {
        return sizeTwo;
    }

    public void setSizeTwo(String sizeTwo) {
        this.sizeTwo = sizeTwo;
    }

    public Entity(String title, String size, String path, int width, int height) {
        this.title = title;
        this.sizeOne = size;
        this.path = path;
        this.width = width;
        this.height = height;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.path);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeString(this.sizeOne);
        dest.writeString(this.sizeTwo);
        dest.writeInt(this.flag);
    }

    protected Entity(Parcel in) {
        this.title = in.readString();
        this.path = in.readString();
        this.width = in.readInt();
        this.height = in.readInt();
        this.sizeOne = in.readString();
        this.sizeTwo = in.readString();
        this.flag = in.readInt();
    }

    public static final Creator<Entity> CREATOR = new Creator<Entity>() {
        @Override
        public Entity createFromParcel(Parcel source) {
            return new Entity(source);
        }

        @Override
        public Entity[] newArray(int size) {
            return new Entity[size];
        }
    };
}
