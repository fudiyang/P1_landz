package landz.fdy.com.p1_landz.landz;

import android.app.Application;
import android.app.Service;
import android.content.Context;

import java.util.List;

import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ImgUrlArrBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ImgUrlArrSeebuildBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.onlineHouseBean;
import landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse.OnlineHouseActivity;

/**
 * Created by fudiyang on 2016/7/13.
 * Author fudiyang
 * Description :自定义Application 。
 *   1.可以全局变量或者对象（整个app）
 *   2.app一启动最先创建application
 *   3.一个app只有一个application,但是没多加一个进程都会初始化一次Application
 *   4.如果像初始化一次的话，可以只在一个进程中初始化(实际用的时候说)
 */
public class MyApplication extends Application {
    private String str;
    private onlineHouseBean onlinehouseBean;
    private static MyApplication app;
    public List<ImgUrlArrBean> imgUrlArr;//详情展示图
    public List<ImgUrlArrSeebuildBean> imgUrlArrSeebuild;

    public List<ImgUrlArrSeebuildBean> getImgUrlArrSeebuild() {
        return imgUrlArrSeebuild;
    }

    public void setImgUrlArrSeebuild(List<ImgUrlArrSeebuildBean> imgUrlArrSeebuild) {
        this.imgUrlArrSeebuild = imgUrlArrSeebuild;
    }

    public List<ImgUrlArrBean> getImgUrlArr() {
        return imgUrlArr;
    }

    public void setImgUrlArr(List<ImgUrlArrBean> imgUrlArr) {
        this.imgUrlArr = imgUrlArr;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        str="123";
        app=this;
    }
    public static MyApplication getApplication(){
        return app;
    }
    public static Context getAppContext(){
     return app.getApplicationContext();
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
    public onlineHouseBean getonlineHouseBean(){
        return onlinehouseBean;
    }
    public void setonlinehouseBean(onlineHouseBean onlinehouseBean){
        this.onlinehouseBean=onlinehouseBean;
    }
}
