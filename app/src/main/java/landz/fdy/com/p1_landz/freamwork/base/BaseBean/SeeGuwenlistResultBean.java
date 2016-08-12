package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import java.util.List;

/**
 * Created by fudiyang on 2016/8/4.
 * Author fudiyang
 * Description :
 */
public class SeeGuwenlistResultBean {
    public String totalBroker;
    public List<SeeGuwenListBean> brokerSeeVos;

    @Override
    public String toString() {
        return "SeeGuwenlistResultBean{" +
                "totalBroker='" + totalBroker + '\'' +
                ", brokerSeeVos=" + brokerSeeVos +
                '}';
    }
}
