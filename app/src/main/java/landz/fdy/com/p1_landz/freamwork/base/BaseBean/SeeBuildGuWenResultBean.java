package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

/**
 * Created by fudiyang on 2016/8/3.
 * Author fudiyang
 * Description :
 */
public class SeeBuildGuWenResultBean {
    public String resultStatus;
    public String resultMsg;
    public SeeGuWenResultBean result;

    @Override
    public String toString() {
        return "SeeBuildGuWenResultBean{" +
                "resultStatus='" + resultStatus + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", result=" + result +
                '}';
    }
}
