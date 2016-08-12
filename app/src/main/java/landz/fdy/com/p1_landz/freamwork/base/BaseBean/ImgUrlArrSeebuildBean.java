package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fudiyang on 2016/8/3.
 * Author fudiyang
 * Description :
 */
public class ImgUrlArrSeebuildBean implements Parcelable {
    public String resourceId;//id
    public String picName;//图片地址
    public String picType;//图片类型

    @Override
    public String toString() {
        return "ImgUrlArrSeebuildBean{" +
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

    public ImgUrlArrSeebuildBean() {
    }

    protected ImgUrlArrSeebuildBean(Parcel in) {
        this.resourceId = in.readString();
        this.picName = in.readString();
        this.picType = in.readString();
    }

    public static final Parcelable.Creator<ImgUrlArrSeebuildBean> CREATOR = new Parcelable.Creator<ImgUrlArrSeebuildBean>() {
        @Override
        public ImgUrlArrSeebuildBean createFromParcel(Parcel source) {
            return new ImgUrlArrSeebuildBean(source);
        }

        @Override
        public ImgUrlArrSeebuildBean[] newArray(int size) {
            return new ImgUrlArrSeebuildBean[size];
        }
    };
}
