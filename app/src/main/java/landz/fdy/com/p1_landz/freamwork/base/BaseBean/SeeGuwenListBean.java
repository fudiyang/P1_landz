package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fudiyang on 2016/8/4.
 * Author fudiyang
 * Description :
 */
public class SeeGuwenListBean implements Parcelable {

    public String houseSeetotal;
    public String brokerId;
    public String brokerName;
    public String phone;
    public String inductionDate;
    public String education;
    public String userLevel;
    public String photo;

    @Override
    public String toString() {
        return "SeeGuwenListBean{" +
                "houseSeetotal='" + houseSeetotal + '\'' +
                ", brokerId='" + brokerId + '\'' +
                ", brokerName='" + brokerName + '\'' +
                ", phone='" + phone + '\'' +
                ", inductionDate='" + inductionDate + '\'' +
                ", education='" + education + '\'' +
                ", userLevel='" + userLevel + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.houseSeetotal);
        dest.writeString(this.brokerId);
        dest.writeString(this.brokerName);
        dest.writeString(this.phone);
        dest.writeString(this.inductionDate);
        dest.writeString(this.education);
        dest.writeString(this.userLevel);
        dest.writeString(this.photo);
    }

    public SeeGuwenListBean() {
    }

    protected SeeGuwenListBean(Parcel in) {
        this.houseSeetotal = in.readString();
        this.brokerId = in.readString();
        this.brokerName = in.readString();
        this.phone = in.readString();
        this.inductionDate = in.readString();
        this.education = in.readString();
        this.userLevel = in.readString();
        this.photo = in.readString();
    }

    public static final Parcelable.Creator<SeeGuwenListBean> CREATOR = new Parcelable.Creator<SeeGuwenListBean>() {
        @Override
        public SeeGuwenListBean createFromParcel(Parcel source) {
            return new SeeGuwenListBean(source);
        }

        @Override
        public SeeGuwenListBean[] newArray(int size) {
            return new SeeGuwenListBean[size];
        }
    };
}
