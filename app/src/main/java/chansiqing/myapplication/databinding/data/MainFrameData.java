package chansiqing.myapplication.databinding.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 启动页数据
 *
 * @author: chansiqing
 * @date: 2018-09-30 14:41
 */
public class MainFrameData implements Parcelable {
    private String simpleBtnName;
    private boolean simpleBtnVisible;
    private String simpleBtnDrawableUrl;

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.simpleBtnName);
        dest.writeByte(this.simpleBtnVisible ? (byte) 1 : (byte) 0);
        dest.writeString(this.simpleBtnDrawableUrl);
    }

    public MainFrameData() {
    }

    protected MainFrameData(Parcel in) {
        this.simpleBtnName = in.readString();
        this.simpleBtnVisible = in.readByte() != 0;
        this.simpleBtnDrawableUrl = in.readString();
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
