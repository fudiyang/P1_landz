package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Lizhangfeng on 2016/7/26 0026.
 * Description: 户型bean
 */
public class ApartmentImgVoBean implements Parcelable {
    /** 总价开始 */
    public double totalprBegin;
    /** 总价结束 */
    public double totalprEnd;
    /** 占地面积 */
    public double innenbereichSize;
    /** 居室 */
    public int bedroomAmount;
    /** 厅数 */
    public int parlorAmount;
    /** 卫数 */
    public int toiletAmount;
    /** 图片 */
    public String imgUrl;

    @Override
    public String toString() {
        return "ApartmentImgVoBean{" +
                "totalprBegin=" + totalprBegin +
                ", totalprEnd=" + totalprEnd +
                ", innenbereichSize=" + innenbereichSize +
                ", bedroomAmount=" + bedroomAmount +
                ", parlorAmount=" + parlorAmount +
                ", toiletAmount=" + toiletAmount +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.totalprBegin);
        dest.writeDouble(this.totalprEnd);
        dest.writeDouble(this.innenbereichSize);
        dest.writeInt(this.bedroomAmount);
        dest.writeInt(this.parlorAmount);
        dest.writeInt(this.toiletAmount);
        dest.writeString(this.imgUrl);
    }

    public ApartmentImgVoBean() {
    }

    protected ApartmentImgVoBean(Parcel in) {
        this.totalprBegin = in.readDouble();
        this.totalprEnd = in.readDouble();
        this.innenbereichSize = in.readDouble();
        this.bedroomAmount = in.readInt();
        this.parlorAmount = in.readInt();
        this.toiletAmount = in.readInt();
        this.imgUrl = in.readString();
    }

    public static final Parcelable.Creator<ApartmentImgVoBean> CREATOR = new Parcelable.Creator<ApartmentImgVoBean>() {
        @Override
        public ApartmentImgVoBean createFromParcel(Parcel source) {
            return new ApartmentImgVoBean(source);
        }

        @Override
        public ApartmentImgVoBean[] newArray(int size) {
            return new ApartmentImgVoBean[size];
        }
    };
}
