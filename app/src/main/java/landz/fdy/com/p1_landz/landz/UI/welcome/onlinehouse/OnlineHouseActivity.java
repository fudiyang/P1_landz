package landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ResultBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.onlineHouseBean;
import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseActivity;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.paramListBean;
import landz.fdy.com.p1_landz.freamwork.utils.LogUtils;
import landz.fdy.com.p1_landz.freamwork.utils.ToastUtil;
import landz.fdy.com.p1_landz.landz.MyApplication;
import landz.fdy.com.p1_landz.landz.UI.welcome.View.MyPopwindow;

public class OnlineHouseActivity extends BaseActivity {

    private onlineHouseBean onlinehouseBean;

   private TextView tv_location,tv_price, tv_room, tv_type, tv_more;
    @Override
    public int getContentViewId() {
        return R.layout.activity_online_house;
    }

    @Override
    public void beforeInitView() {
      onlinehouseBean= MyApplication.getApplication().getonlineHouseBean();
    }

    @Override
    public void InitView() {
        tv_location = findViewByIdNoCast(R.id.tv_location);
        tv_price = findViewByIdNoCast(R.id.tv_price);
        tv_room = findViewByIdNoCast(R.id.tv_room);
        tv_type = findViewByIdNoCast(R.id.tv_type);
        tv_more = findViewByIdNoCast(R.id.tv_more);


    }

    @Override
    public void InitData() {
   setOnClick(tv_location,tv_price, tv_room, tv_type, tv_more);

    }

    @Override
    public void onClick(View view) {
        LogUtils.e("msg","fffffffffffffffff");

        switch (view.getId()){
            case R.id.tv_location:
                List<paramListBean> paramList=null;
                LogUtils.e("msg","fffffffffffffffff");
                for(ResultBean resultBean:onlinehouseBean.result){
                    if("1001".equals(resultBean.paramType)){
                        paramList=resultBean.paramList;
                        LogUtils.e("fffffffffffffffff");

                    }
                }



                break;
        }
    }
}
