package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

/**
 * Created by fudiyang on 2016/7/26.
 * Author fudiyang
 * Description :
 */
public class HouseDetailResultBean {

    public String resultStatus;
    public String resultMsg;
    public HouseDetailBean result;

    @Override
    public String toString() {
        return "HouseDetailResultBean{" +
                "resultStatus='" + resultStatus + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", result=" + result +
                '}';
    }
}
