package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fudiyang on 2016/8/5.
 * Author fudiyang
 * Description :
 */
public class MoreListBean implements Parcelable {

    public String resblockOneName;
    public String resblockType;
    public String totalprBegin;
    public String totalprEnd;
    public String prodelId;
    public String unitprBegin;
    public String unitprEnd;
    public String apartmentBegin;
    public String apartmentEnd;
    public String circleTypeName;
    public String imgUrl;
    public String url720;
    public String developers;
    public String totalShowing;
    public String avergPrice;
    public String sortNum;
    public String areaBegin;
    public String areaEnd;
    public String totalNumber;

    @Override
    public String toString() {
        return "MoreListBean{" +
                "resblockOneName='" + resblockOneName + '\'' +
                ", resblockType='" + resblockType + '\'' +
                ", totalprBegin='" + totalprBegin + '\'' +
                ", totalprEnd='" + totalprEnd + '\'' +
                ", prodelId='" + prodelId + '\'' +
                ", unitprBegin='" + unitprBegin + '\'' +
                ", unitprEnd='" + unitprEnd + '\'' +
                ", apartmentBegin='" + apartmentBegin + '\'' +
                ", apartmentEnd='" + apartmentEnd + '\'' +
                ", circleTypeName='" + circleTypeName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", url720='" + url720 + '\'' +
                ", developers='" + developers + '\'' +
                ", totalShowing='" + totalShowing + '\'' +
                ", avergPrice='" + avergPrice + '\'' +
                ", sortNum='" + sortNum + '\'' +
                ", areaBegin='" + areaBegin + '\'' +
                ", areaEnd='" + areaEnd + '\'' +
                ", totalNumber='" + totalNumber + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.resblockOneName);
        dest.writeString(this.resblockType);
        dest.writeString(this.totalprBegin);
        dest.writeString(this.totalprEnd);
        dest.writeString(this.prodelId);
        dest.writeString(this.unitprBegin);
        dest.writeString(this.unitprEnd);
        dest.writeString(this.apartmentBegin);
        dest.writeString(this.apartmentEnd);
        dest.writeString(this.circleTypeName);
        dest.writeString(this.imgUrl);
        dest.writeString(this.url720);
        dest.writeString(this.developers);
        dest.writeString(this.totalShowing);
        dest.writeString(this.avergPrice);
        dest.writeString(this.sortNum);
        dest.writeString(this.areaBegin);
        dest.writeString(this.areaEnd);
        dest.writeString(this.totalNumber);
    }

    public MoreListBean() {
    }

    protected MoreListBean(Parcel in) {
        this.resblockOneName = in.readString();
        this.resblockType = in.readString();
        this.totalprBegin = in.readString();
        this.totalprEnd = in.readString();
        this.prodelId = in.readString();
        this.unitprBegin = in.readString();
        this.unitprEnd = in.readString();
        this.apartmentBegin = in.readString();
        this.apartmentEnd = in.readString();
        this.circleTypeName = in.readString();
        this.imgUrl = in.readString();
        this.url720 = in.readString();
        this.developers = in.readString();
        this.totalShowing = in.readString();
        this.avergPrice = in.readString();
        this.sortNum = in.readString();
        this.areaBegin = in.readString();
        this.areaEnd = in.readString();
        this.totalNumber = in.readString();
    }

    public static final Parcelable.Creator<MoreListBean> CREATOR = new Parcelable.Creator<MoreListBean>() {
        @Override
        public MoreListBean createFromParcel(Parcel source) {
            return new MoreListBean(source);
        }

        @Override
        public MoreListBean[] newArray(int size) {
            return new MoreListBean[size];
        }
    };
}
