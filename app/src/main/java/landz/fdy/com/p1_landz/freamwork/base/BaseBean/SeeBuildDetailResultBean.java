package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import java.util.List;

/**
 * Created by fudiyang on 2016/8/3.
 * Author fudiyang
 * Description :
 */
public class SeeBuildDetailResultBean {
    public String resultStatus;
    public String resultMsg;
    public SeeDetailResultBean result;

    @Override
    public String toString() {
        return "SeeBuildDetailResultBean{" +
                "resultStatus='" + resultStatus + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", result=" + result +
                '}';
    }
}
