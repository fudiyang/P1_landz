package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import java.util.List;

/**
 * Created by fudiyang on 2016/7/15.
 * Author fudiyang
 * Description :
 */
public class onlineHouseBean {
    public String resultStatus;
    public String resultMsg;
    public List<ResultBean> result;

    @Override
    public String toString() {
        return "onlineHouseBean{" +
                "resultStatus='" + resultStatus + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", result=" + result +
                '}';
    }
}
