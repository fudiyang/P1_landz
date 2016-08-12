package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import java.util.List;

/**
 * Created by fudiyang on 2016/8/5.
 * Author fudiyang
 * Description :
 */
public class MoreListResultBean {

    public String resultStatus;
    public String resultMsg;
    public List<MoreListBean> result;

    @Override
    public String toString() {
        return "MoreListResultBean{" +
                "resultStatus='" + resultStatus + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", result=" + result +
                '}';
    }
}
