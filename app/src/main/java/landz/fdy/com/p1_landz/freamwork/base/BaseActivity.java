package landz.fdy.com.p1_landz.freamwork.base;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;


import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.tools.AppManager;

/**
 * Created by fudiyang on 2016/7/13.
 * Author fudiyang
 * Description : Activity基本类
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener,Handler.Callback{
    private Dialog dialog;
    private  Handler handler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        if(getSupportActionBar()!=null)
        {getSupportActionBar().hide();}
        AppManager.getInstance().addActivity(this);
        setTranslucentStatus();
        beforeInitView();
        InitView();
        InitData();
        handler = new Handler(this);
    }

    public abstract int getContentViewId();//放layoutid

    public abstract void beforeInitView();//初始化view前做的事

    public abstract void InitView();//初始化view

    public abstract void InitData();//初始化数据

    /**
     * 不用强转的findVeiwByid
     * @param id
     * @param <T>
     * @return
     */

    public <T extends View> T findViewByIdNoCast(int id){
        return (T)findViewById(id);
    }

    public void setOnClick(int...ids){
       for(int id:ids)
           findViewById(id).setOnClickListener(this);
    }

    public void setOnClick(View...views){
        for(View view:views)
            view.setOnClickListener(this);
    }

    public void setTranslucentStatus(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            Window window=getWindow();
            WindowManager.LayoutParams layoutParams=window.getAttributes();
            layoutParams.flags |=WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            window.setAttributes(layoutParams);
        }
    }

    public void showProgressBar(){
        if(dialog==null){
            dialog=new Dialog(this,android.R.style.Theme_DeviceDefault_Dialog_NoActionBar);
        }

        View view=View.inflate(this, R.layout.dialog_progressbar,null);
        dialog.setContentView(view);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        ImageView img_progressbar= (ImageView) view.findViewById(R.id.img_progressbar);
        AnimationDrawable animationDrawable= (AnimationDrawable) img_progressbar.getDrawable();
        animationDrawable.start();
        dialog.show();

    }

    public  void dismissProgressBar(){
            handler.sendEmptyMessageDelayed(0,1000);
    }

    @Override
    public boolean handleMessage(Message message) {
       if(dialog!=null&&dialog.isShowing()){
           dialog.dismiss();
       }
        return false;
    }

    /**
     * 本段代码用来处理如果输入法还显示的话就消失掉输入键盘
     */
    protected void dismissSoftKeyboard(Activity activity) {
        try {
            InputMethodManager inputMethodManage = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManage.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示键盘
     *
     * @param view
     */
    protected void showKeyboard(View view) {
        try {
            InputMethodManager inputMethodManage = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManage.showSoftInput(view, InputMethodManager.SHOW_FORCED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
      AppManager.getInstance().remove(this);
        super.onDestroy();
    }
}
