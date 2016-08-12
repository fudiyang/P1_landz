package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import java.util.List;

/**
 * Created by fudiyang on 2016/7/28.
 * Author fudiyang
 * Description :
 */
public class OneHouseMoreResultBean {

    public String resultStatus;
    public String resultMsg;
    public List<HouseOneArrBean> result;

    @Override
    public String toString() {
        return "OneHouseMoreResultBean{" +
                "resultStatus='" + resultStatus + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", result=" + result +
                '}';
    }
}
