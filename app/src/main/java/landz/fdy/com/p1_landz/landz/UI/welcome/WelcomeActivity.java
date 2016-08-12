package landz.fdy.com.p1_landz.landz.UI.welcome;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseActivity;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.onlineHouseBean;
import landz.fdy.com.p1_landz.freamwork.share.ShareprenceHelper;
import landz.fdy.com.p1_landz.freamwork.utils.IntentUtils;
import landz.fdy.com.p1_landz.freamwork.utils.LogUtils;
import landz.fdy.com.p1_landz.landz.MainActivity;
import landz.fdy.com.p1_landz.landz.MyApplication;

public class WelcomeActivity extends BaseActivity implements Handler.Callback{

   private Handler handler;

    @Override
    public int getContentViewId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void beforeInitView() {
    handler=new Handler(this);
    }

    @Override
    public void InitView() {

    }

    @Override
    public void InitData() {
        handler=new Handler(this);
       handler.sendEmptyMessageDelayed(1,3000);
        try {
            InputStream inputStream=getAssets().open("study_type.txt");
            int length=inputStream.available();
            byte[] bytes=new byte[length];
            inputStream.read(bytes);
            String string=new String(bytes,"utf-8");
            Gson gson=new Gson();
           onlineHouseBean onlinehousebean =gson.fromJson(string, onlineHouseBean.class);
            MyApplication.getApplication().setonlinehouseBean(onlinehousebean);
            LogUtils.e("msg","onlinehousebean:"+onlinehousebean.toString());
            LogUtils.e(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean handleMessage(Message message) {
        if(ShareprenceHelper.getInstance(this).isFirst()){
            IntentUtils.openActivity(this,GuideActivity.class);
        }else {
            IntentUtils.openActivity(this, MainActivity.class);
        }

        finish();
        return false;
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
