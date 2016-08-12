package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import java.util.List;

/**
 * Created by fudiyang on 2016/8/3.
 * Author fudiyang
 * Description :
 */
public class SeeGuWenResultBean {

    public String totalBroker;
    public List<BrokerSeeVosBean> brokerSeeVos;

    @Override
    public String toString() {
        return "SeeGuWenResultBean{" +
                "totalBroker='" + totalBroker + '\'' +
                ", brokerSeeVos=" + brokerSeeVos +
                '}';
    }
}
