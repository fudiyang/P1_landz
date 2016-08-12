package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import java.util.List;

/**
 * Created by fudiyang on 2016/7/15.
 * Author fudiyang
 * Description :
 */
public class ResultBean {
    public String paramType;
    public List<paramListBean> paramList;

    @Override
    public String toString() {
        return "ResultBean{" +
                "paramType='" + paramType + '\'' +
                ", paramList=" + paramList +
                '}';
    }
}
