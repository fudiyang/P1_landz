package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by fudiyang on 2016/7/20.
 * Author fudiyang
 * Description :
 */
public class OnlineHouseResult {
    public String resultStatus;
    public String resultMsg;
    public OnlineHouseResultBean result;


    public void initListData(OnlineHouseResult resultBean, List<Object> totalList) {
        if (resultBean != null) {
            List<HouseArrBean> houseArr = resultBean.result.houseArr;
            List<HouseOneArrBean> houseOneArr = resultBean.result.houseOneArr;
            List<Object> newTotalList = new ArrayList<>();
            if (houseArr != null && !houseArr.isEmpty()) {
                newTotalList.addAll(houseArr);
            }
            if (houseOneArr != null && !houseOneArr.isEmpty()) {
                newTotalList.addAll(houseOneArr);
            }

            Collections.sort(newTotalList, new Comparator<Object>() {
                @Override
                public int compare(Object o1, Object o2) {
                    int a, b = 0;
                    if (o1 instanceof HouseArrBean) {
                        a = Integer.parseInt(((HouseArrBean) o1).sortNum);
                    } else
                        a = Integer.parseInt(((HouseOneArrBean) o1).sortNum);

                    if (o2 instanceof HouseArrBean) {
                        b = Integer.parseInt(((HouseArrBean) o2).sortNum);
                    } else
                        b = Integer.parseInt(((HouseOneArrBean) o2).sortNum);

                    if (a > b) {
                        return 1;
                    }
                    if (a < b) {
                        return -1;
                    }
                    return 0;
                }
            });
            totalList.addAll(newTotalList);

        }

    }

    @Override
    public String toString() {
        return "OnlineHouseResult{" +
                "resultStatus='" + resultStatus + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", result=" + result +
                '}';
    }
}
