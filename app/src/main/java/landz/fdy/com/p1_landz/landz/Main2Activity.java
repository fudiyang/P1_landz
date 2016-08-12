package landz.fdy.com.p1_landz.landz;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseActivity;
import landz.fdy.com.p1_landz.freamwork.share.ShareprenceHelper;
import landz.fdy.com.p1_landz.freamwork.tools.AppManager;
import landz.fdy.com.p1_landz.freamwork.utils.ToastUtil;

public class Main2Activity extends BaseActivity {


     private TextView tv_hello;



    @Override
    public int getContentViewId() {
        return R.layout.activity_main2;
    }

    @Override
    public void beforeInitView() {
        AppManager.getInstance().killActivity(MainActivity.class);
    }

    @Override
    public void InitView() {


    }

    @Override
    public void InitData() {

    }

    @Override
    public void onClick(View view) {

    }
}
