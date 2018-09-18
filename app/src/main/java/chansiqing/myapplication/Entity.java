package chansiqing.myapplication;

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
    private String size;
    private int flag;

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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Entity(String title, String size, String path) {
        this.title = title;
        this.size = size;
        this.path = path;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.path);
        dest.writeString(this.size);
        dest.writeInt(this.flag);
    }

    protected Entity(Parcel in) {
        this.title = in.readString();
        this.path = in.readString();
        this.size = in.readString();
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
