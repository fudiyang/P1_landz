package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fudiyang on 2016/7/20.
 * Author fudiyang
 * Description :
 */
public class HouseArrBean implements Parcelable {
    public String housedelId;
    public String resblockId;
    public String resblockName;
    public String circleTypeCode;
    public String circleTypeName;
    public String totalPrices;
    public String bedroomAmount;
    public String parlorAmount;
    public String buildSize;
    public String houseLabel;
    public String salesTrait;
    public String titleImg;
    public String isFocus;
    public String isBasilic;
    public String isKey;
    public String maxCanLookTime;
    public String totalShowing;
    public String score;
    public String orientation;
    public String usageType;
    public String sortNum;
    public String totalNumber;

    @Override
    public String toString() {
        return "HouseArrBean{" +
                "housedelId='" + housedelId + '\'' +
                ", resblockId='" + resblockId + '\'' +
                ", resblockName='" + resblockName + '\'' +
                ", circleTypeCode='" + circleTypeCode + '\'' +
                ", circleTypeName='" + circleTypeName + '\'' +
                ", totalPrices='" + totalPrices + '\'' +
                ", bedroomAmount='" + bedroomAmount + '\'' +
                ", parlorAmount='" + parlorAmount + '\'' +
                ", buildSize='" + buildSize + '\'' +
                ", houseLabel='" + houseLabel + '\'' +
                ", salesTrait='" + salesTrait + '\'' +
                ", titleImg='" + titleImg + '\'' +
                ", isFocus='" + isFocus + '\'' +
                ", isBasilic='" + isBasilic + '\'' +
                ", isKey='" + isKey + '\'' +
                ", maxCanLookTime='" + maxCanLookTime + '\'' +
                ", totalShowing='" + totalShowing + '\'' +
                ", score='" + score + '\'' +
                ", orientation='" + orientation + '\'' +
                ", usageType='" + usageType + '\'' +
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
        dest.writeString(this.housedelId);
        dest.writeString(this.resblockId);
        dest.writeString(this.resblockName);
        dest.writeString(this.circleTypeCode);
        dest.writeString(this.circleTypeName);
        dest.writeString(this.totalPrices);
        dest.writeString(this.bedroomAmount);
        dest.writeString(this.parlorAmount);
        dest.writeString(this.buildSize);
        dest.writeString(this.houseLabel);
        dest.writeString(this.salesTrait);
        dest.writeString(this.titleImg);
        dest.writeString(this.isFocus);
        dest.writeString(this.isBasilic);
        dest.writeString(this.isKey);
        dest.writeString(this.maxCanLookTime);
        dest.writeString(this.totalShowing);
        dest.writeString(this.score);
        dest.writeString(this.orientation);
        dest.writeString(this.usageType);
        dest.writeString(this.sortNum);
        dest.writeString(this.totalNumber);
    }

    public HouseArrBean() {
    }

    protected HouseArrBean(Parcel in) {
        this.housedelId = in.readString();
        this.resblockId = in.readString();
        this.resblockName = in.readString();
        this.circleTypeCode = in.readString();
        this.circleTypeName = in.readString();
        this.totalPrices = in.readString();
        this.bedroomAmount = in.readString();
        this.parlorAmount = in.readString();
        this.buildSize = in.readString();
        this.houseLabel = in.readString();
        this.salesTrait = in.readString();
        this.titleImg = in.readString();
        this.isFocus = in.readString();
        this.isBasilic = in.readString();
        this.isKey = in.readString();
        this.maxCanLookTime = in.readString();
        this.totalShowing = in.readString();
        this.score = in.readString();
        this.orientation = in.readString();
        this.usageType = in.readString();
        this.sortNum = in.readString();
        this.totalNumber = in.readString();
    }

    public static final Parcelable.Creator<HouseArrBean> CREATOR = new Parcelable.Creator<HouseArrBean>() {
        @Override
        public HouseArrBean createFromParcel(Parcel source) {
            return new HouseArrBean(source);
        }

        @Override
        public HouseArrBean[] newArray(int size) {
            return new HouseArrBean[size];
        }
    };
}
