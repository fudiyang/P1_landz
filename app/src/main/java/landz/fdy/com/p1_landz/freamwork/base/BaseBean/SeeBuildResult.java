package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import landz.fdy.com.p1_landz.landz.UI.welcome.CallBack.TosatCallBack;

/**
 * Created by fudiyang on 2016/8/2.
 * Author fudiyang
 * Description :
 */
public class SeeBuildResult implements TosatCallBack{

    public String resultStatus;

    public String resultMsg;

    public SeeBuildResultBean result;

    public  void initListData(SeeBuildResult resultBean, List<Object>totalList) {

        if(resultBean!=null){
            final List<ResblockArrBean> resblockArr=resultBean.result.resblockArr;
            List<ResblockOneArrBean> resblockOneArr=resultBean.result.resblockOneArr;
            List<Object> newTotalList=new ArrayList<>();

            if(resblockArr!=null&&!resblockArr.isEmpty()){
                newTotalList.addAll(resblockArr);
            }
            if(resblockOneArr!=null&&!resblockOneArr.isEmpty()){
                newTotalList.addAll(resblockOneArr);
            }
            Collections.sort(newTotalList, new Comparator<Object>() {

                @Override
                public int compare(Object t0, Object t1) {
                    int a,b=0;
                    if(t0 instanceof ResblockArrBean){
                        a=Integer.parseInt(((ResblockArrBean)t0).sortNum);
                    }else {
                        a=Integer.parseInt(((ResblockOneArrBean)t0).sortNum);
                    }
                    if(t1 instanceof ResblockArrBean){
                        b=Integer.parseInt(((ResblockArrBean)t1).sortNum);
                    }else {
                        b=Integer.parseInt(((ResblockOneArrBean)t1).sortNum);
                    }
                    if(a>b){
                        return 1;
                    }if(a<b){
                        return  -1;
                    }
                    return 0;
                }
            });
            totalList.addAll(newTotalList);
        }
     }

    @Override
    public String toString() {
        return "SeeBuildResult{" +
                "resultStatus='" + resultStatus + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", result=" + result +
                '}';
    }

    @Override
    public void isToast(paramListBean paramlistBean) {

    }
}
