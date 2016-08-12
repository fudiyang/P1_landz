package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fudiyang on 2016/8/2.
 * Author fudiyang
 * Description :
 */
public class ResblockArrBean implements Parcelable {

    public String resblockName;
    public String avergPrice;
    public String circleTypeName;
    public String imgUrl;
    public String resblockId;
    public String sortNum;
    public String totalNumber;

    @Override
    public String toString() {
        return "ResblockArrBean{" +
                "resblockName='" + resblockName + '\'' +
                ", avergPrice='" + avergPrice + '\'' +
                ", circleTypeName='" + circleTypeName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", resblockId='" + resblockId + '\'' +
                ", sortNum='" + sortNum + '\'' +
                ", totalNumber='" + totalNumber + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.resblockName);
        dest.writeString(this.avergPrice);
        dest.writeString(this.circleTypeName);
        dest.writeString(this.imgUrl);
        dest.writeString(this.resblockId);
        dest.writeString(this.sortNum);
        dest.writeString(this.totalNumber);
    }

    public ResblockArrBean() {
    }

    protected ResblockArrBean(Parcel in) {
        this.resblockName = in.readString();
        this.avergPrice = in.readString();
        this.circleTypeName = in.readString();
        this.imgUrl = in.readString();
        this.resblockId = in.readString();
        this.sortNum = in.readString();
        this.totalNumber = in.readString();
    }

    public static final Parcelable.Creator<ResblockArrBean> CREATOR = new Parcelable.Creator<ResblockArrBean>() {
        @Override
        public ResblockArrBean createFromParcel(Parcel source) {
            return new ResblockArrBean(source);
        }

        @Override
        public ResblockArrBean[] newArray(int size) {
            return new ResblockArrBean[size];
        }
    };
}
