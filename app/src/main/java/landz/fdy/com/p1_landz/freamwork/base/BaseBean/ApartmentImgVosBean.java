package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fudiyang on 2016/8/3.
 * Author fudiyang
 * Description :
 */
public class ApartmentImgVosBean implements Parcelable {
    public  String totalprBegin;
    public  String totalprEnd;
    public  String innenbereichSize;
    public  String bedroomAmount;
    public  String parlorAmount;
    public  String toiletAmount;
    public  String imgUrl;

    @Override
    public String toString() {
        return "ApartmentImgVosBean{" +
                "totalprBegin='" + totalprBegin + '\'' +
                ", totalprEnd='" + totalprEnd + '\'' +
                ", innenbereichSize='" + innenbereichSize + '\'' +
                ", bedroomAmount='" + bedroomAmount + '\'' +
                ", parlorAmount='" + parlorAmount + '\'' +
                ", toiletAmount='" + toiletAmount + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.totalprBegin);
        dest.writeString(this.totalprEnd);
        dest.writeString(this.innenbereichSize);
        dest.writeString(this.bedroomAmount);
        dest.writeString(this.parlorAmount);
        dest.writeString(this.toiletAmount);
        dest.writeString(this.imgUrl);
    }

    public ApartmentImgVosBean() {
    }

    protected ApartmentImgVosBean(Parcel in) {
        this.totalprBegin = in.readString();
        this.totalprEnd = in.readString();
        this.innenbereichSize = in.readString();
        this.bedroomAmount = in.readString();
        this.parlorAmount = in.readString();
        this.toiletAmount = in.readString();
        this.imgUrl = in.readString();
    }

    public static final Parcelable.Creator<ApartmentImgVosBean> CREATOR = new Parcelable.Creator<ApartmentImgVosBean>() {
        @Override
        public ApartmentImgVosBean createFromParcel(Parcel source) {
            return new ApartmentImgVosBean(source);
        }

        @Override
        public ApartmentImgVosBean[] newArray(int size) {
            return new ApartmentImgVosBean[size];
        }
    };
}
