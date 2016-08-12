package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

/**
 * Created by fudiyang on 2016/8/4.
 * Author fudiyang
 * Description :
 */
public class GuwenlistResultBean {
    public String resultStatus;
    public String resultMsg;
    public SeeGuwenlistResultBean result;

    @Override
    public String toString() {
        return "GuwenlistResultBean{" +
                "resultStatus='" + resultStatus + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", result=" + result +
                '}';
    }
}
