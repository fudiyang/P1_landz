package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fudiyang on 2016/7/26.
 * Author fudiyang
 * Description :
 */
public class ImgUrlArrBean implements Parcelable {

    public String resourceId;//id
    public String picName;//图片地址
    public String picType;//图片的类型

    public int textSize;
    @Override
    public String toString() {
        return "ImgUrlArrBean{" +
                "resourceId='" + resourceId + '\'' +
                ", picName='" + picName + '\'' +
                ", picType='" + picType + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.resourceId);
        dest.writeString(this.picName);
        dest.writeString(this.picType);
    }

    public ImgUrlArrBean() {
    }

    protected ImgUrlArrBean(Parcel in) {
        this.resourceId = in.readString();
        this.picName = in.readString();
        this.picType = in.readString();
    }

    public static final Parcelable.Creator<ImgUrlArrBean> CREATOR = new Parcelable.Creator<ImgUrlArrBean>() {
        @Override
        public ImgUrlArrBean createFromParcel(Parcel source) {
            return new ImgUrlArrBean(source);
        }

        @Override
        public ImgUrlArrBean[] newArray(int size) {
            return new ImgUrlArrBean[size];
        }
    };
}
