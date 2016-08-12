package landz.fdy.com.p1_landz.landz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseActivity;
import landz.fdy.com.p1_landz.freamwork.share.ShareprenceHelper;
import landz.fdy.com.p1_landz.freamwork.tools.AppManager;
import landz.fdy.com.p1_landz.freamwork.utils.DrawableUtils;
import landz.fdy.com.p1_landz.freamwork.utils.IntentUtils;
import landz.fdy.com.p1_landz.freamwork.utils.ToastUtil;
import landz.fdy.com.p1_landz.landz.UI.welcome.OnlineHouseActivity;
import landz.fdy.com.p1_landz.landz.UI.welcome.Serch.SerchActivity;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild.SeeBuildActivity;

public class MainActivity  extends BaseActivity implements Handler.Callback{

    private TextView tv_main_online;
    private TextView tv_main_seebuild;
    private TextView tv_main_wait_rent;
    private TextView tv_main_onehouse;
    private TextView tv_main_map;
    private TextView tv_main_study;
    private TextView tv_main_man;
    private TextView tv_main_myhouse;


    private TextView[] textViews;
    private Integer[] normal_ids=new Integer[]{R.mipmap.main_online_normal, R.mipmap.main_seebuild_normal
            , R.mipmap.main_wait_rent_normal, R.mipmap.main_onehouse_normal,R.mipmap.main_map_normal,R.mipmap.main_study_normal
    ,R.mipmap.main_man_normal,R.mipmap.main_myhouse_normal};
    private Integer[] select_ids=new Integer[]{R.mipmap.main_online, R.mipmap.main_seebuild
            , R.mipmap.main_wait_rent, R.mipmap.main_onehouse,R.mipmap.main_map,R.mipmap.main_study
            ,R.mipmap.main_man,R.mipmap.main_myhouse};

    private Handler handler;
    @Override
    public int getContentViewId() {

        return R.layout.activity_main;
    }

    @Override
    public void beforeInitView() {
            handler=new Handler(this);
    }

    @Override
    public void InitView() {
        tv_main_online = findViewByIdNoCast(R.id.tv_main_online);
        tv_main_seebuild = findViewByIdNoCast(R.id.tv_main_seebuild);
        tv_main_wait_rent = findViewByIdNoCast(R.id.tv_main_wait_rent);
        tv_main_onehouse = findViewByIdNoCast(R.id.tv_main_onehouse);
        tv_main_map = findViewByIdNoCast(R.id.tv_main_map);
        tv_main_study = findViewByIdNoCast(R.id.tv_main_study);
        tv_main_man = findViewByIdNoCast(R.id.tv_main_man);
        tv_main_myhouse = findViewByIdNoCast(R.id.tv_main_myhouse);

    }

    @Override
    public void InitData() {
        textViews=new TextView[]{tv_main_online,tv_main_seebuild,tv_main_wait_rent,tv_main_onehouse
        ,tv_main_map,tv_main_study,tv_main_man,tv_main_myhouse};
        setOnClick(tv_main_online,tv_main_seebuild,tv_main_wait_rent,tv_main_onehouse
                ,tv_main_map,tv_main_study,tv_main_man,tv_main_myhouse);
        setOnClick(R.id.et_main_search);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.et_main_search:
                Bundle bundle=new Bundle();
                bundle.putInt("type",5);
                Intent intent=new Intent(MainActivity.this, SerchActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.tv_main_online:
                setSelect(0);
                IntentUtils.openActivity(MainActivity.this, OnlineHouseActivity.class);
                break;
            case R.id.tv_main_seebuild:
                setSelect(1);
                IntentUtils.openActivity(MainActivity.this, SeeBuildActivity.class);
                break;
            case R.id.tv_main_wait_rent:
                setSelect(2);
                break;
            case R.id.tv_main_onehouse:
                setSelect(3);
                break;
            case R.id.tv_main_map:
                setSelect(4);
                break;
            case R.id.tv_main_study:
                setSelect(5);
                break;
            case R.id.tv_main_man:
                setSelect(6);
                break;
            case R.id.tv_main_myhouse:
                setSelect(7);
                break;
        }

    }
    public void setSelect(int position){
    for(int i=0;i<textViews.length;i++){
         if(i==position){
             textViews[i].setTextColor(Color.BLUE);
             DrawableUtils.drawableTop(MainActivity.this,textViews[i],select_ids[i]);
         }else {
              textViews[i].setTextColor(Color.WHITE);
              DrawableUtils.drawableTop(MainActivity.this,textViews[i],normal_ids[i]);
         }
    }
    }



    private static final int TIMES=2000;
    private boolean isBack=true;

    public boolean onKeyDown(int keyCode,KeyEvent event){
         if(event.getAction()==KeyEvent.ACTION_DOWN&&keyCode==KeyEvent.KEYCODE_BACK) {
             if (isBack) {
                 ToastUtil.showToast("再点一次退出");
                 isBack = false;
                 handler.sendEmptyMessageDelayed(1, 2000);
             } else {
                 System.exit(0);
             }
             return false;
         }
        return super.onKeyDown(keyCode,event);
    }
    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what){
            case 1:
                isBack=true;
                break;
        }
        return false;
    }
}
