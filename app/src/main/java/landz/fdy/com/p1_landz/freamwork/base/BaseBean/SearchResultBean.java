package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import java.util.List;

/**
 * Created by fudiyang on 2016/7/25.
 * Author fudiyang
 * Description :
 */
public class SearchResultBean {

    public String resultStatus;
    public String resultMsg;
    public List<SearchBean> result;

    @Override
    public String toString() {
        return "SearchResultBean{" +
                "resultStatus='" + resultStatus + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", result=" + result +
                '}';
    }
}
