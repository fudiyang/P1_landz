package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fudiyang on 2016/7/20.
 * Author fudiyang
 * Description :
 */
public class HouseOneArrBean implements Parcelable {
    public String resblockOneId;
    public String houseOneId;
    public String resblockOneName;
    public String bedroomAmount;
    public String parlorAmount;
    public String buildSize;
    public String totalprBegin;
    public String totalprEnd;
    public String titlepicImg;
    public String circleTypeName;
    public String resblockType;
    public String totalShowing;
    public String sortNum;
    public String unitprBegin;
    public String unitprEnd;
    public String totalNumber;

    @Override
    public String toString() {
        return "HouseOneArrBean{" +
                "resblockOneId='" + resblockOneId + '\'' +
                ", houseOneId='" + houseOneId + '\'' +
                ", resblockOneName='" + resblockOneName + '\'' +
                ", bedroomAmount='" + bedroomAmount + '\'' +
                ", parlorAmount='" + parlorAmount + '\'' +
                ", buildSize='" + buildSize + '\'' +
                ", totalprBegin='" + totalprBegin + '\'' +
                ", totalprEnd='" + totalprEnd + '\'' +
                ", titlepicImg='" + titlepicImg + '\'' +
                ", circleTypeName='" + circleTypeName + '\'' +
                ", resblockType='" + resblockType + '\'' +
                ", totalShowing='" + totalShowing + '\'' +
                ", sortNum='" + sortNum + '\'' +
                ", unitprBegin='" + unitprBegin + '\'' +
                ", unitprEnd='" + unitprEnd + '\'' +
                ", totalNumber='" + totalNumber + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.resblockOneId);
        dest.writeString(this.houseOneId);
        dest.writeString(this.resblockOneName);
        dest.writeString(this.bedroomAmount);
        dest.writeString(this.parlorAmount);
        dest.writeString(this.buildSize);
        dest.writeString(this.totalprBegin);
        dest.writeString(this.totalprEnd);
        dest.writeString(this.titlepicImg);
        dest.writeString(this.circleTypeName);
        dest.writeString(this.resblockType);
        dest.writeString(this.totalShowing);
        dest.writeString(this.sortNum);
        dest.writeString(this.unitprBegin);
        dest.writeString(this.unitprEnd);
        dest.writeString(this.totalNumber);
    }

    public HouseOneArrBean() {
    }

    protected HouseOneArrBean(Parcel in) {
        this.resblockOneId = in.readString();
        this.houseOneId = in.readString();
        this.resblockOneName = in.readString();
        this.bedroomAmount = in.readString();
        this.parlorAmount = in.readString();
        this.buildSize = in.readString();
        this.totalprBegin = in.readString();
        this.totalprEnd = in.readString();
        this.titlepicImg = in.readString();
        this.circleTypeName = in.readString();
        this.resblockType = in.readString();
        this.totalShowing = in.readString();
        this.sortNum = in.readString();
        this.unitprBegin = in.readString();
        this.unitprEnd = in.readString();
        this.totalNumber = in.readString();
    }

    public static final Parcelable.Creator<HouseOneArrBean> CREATOR = new Parcelable.Creator<HouseOneArrBean>() {
        @Override
        public HouseOneArrBean createFromParcel(Parcel source) {
            return new HouseOneArrBean(source);
        }

        @Override
        public HouseOneArrBean[] newArray(int size) {
            return new HouseOneArrBean[size];
        }
    };
}
