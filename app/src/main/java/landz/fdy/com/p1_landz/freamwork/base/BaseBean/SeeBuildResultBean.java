package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import java.util.List;

/**
 * Created by fudiyang on 2016/8/2.
 * Author fudiyang
 * Description :
 */
public class SeeBuildResultBean {

    public List<ResblockArrBean> resblockArr;
    public List<ResblockOneArrBean> resblockOneArr;

    @Override
    public String toString() {
        return "SeeBuildResultBean{" +
                "resblockArr=" + resblockArr +
                ", resblockOneArr=" + resblockOneArr +
                '}';
    }
}
