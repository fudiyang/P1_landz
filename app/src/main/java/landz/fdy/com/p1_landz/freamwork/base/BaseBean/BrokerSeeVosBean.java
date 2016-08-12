package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fudiyang on 2016/8/3.
 * Author fudiyang
 * Description :
 */
public class BrokerSeeVosBean implements Parcelable {
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
        return "BrokerSeeVosBean{" +
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

    public BrokerSeeVosBean() {
    }

    protected BrokerSeeVosBean(Parcel in) {
        this.houseSeetotal = in.readString();
        this.brokerId = in.readString();
        this.brokerName = in.readString();
        this.phone = in.readString();
        this.inductionDate = in.readString();
        this.education = in.readString();
        this.userLevel = in.readString();
        this.photo = in.readString();
    }

    public static final Parcelable.Creator<BrokerSeeVosBean> CREATOR = new Parcelable.Creator<BrokerSeeVosBean>() {
        @Override
        public BrokerSeeVosBean createFromParcel(Parcel source) {
            return new BrokerSeeVosBean(source);
        }

        @Override
        public BrokerSeeVosBean[] newArray(int size) {
            return new BrokerSeeVosBean[size];
        }
    };
}
