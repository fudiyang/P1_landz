package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import java.util.List;

/**
 * Created by fudiyang on 2016/8/5.
 * Author fudiyang
 * Description :
 */
public class MoreTuijianResultBean {

    public String resultStatus;
    public String resultMsg;
    public List<MoreTuijianBean> result;

    @Override
    public String toString() {
        return "MoreTuijianResultBean{" +
                "resultStatus='" + resultStatus + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", result=" + result +
                '}';
    }
}
