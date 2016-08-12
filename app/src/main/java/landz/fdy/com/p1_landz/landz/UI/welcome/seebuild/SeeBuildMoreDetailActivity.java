package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;

import com.google.gson.Gson;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseActivity;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.GuwenlistResultBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.MoreTuijianResultBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.SeeBuildDetailResultBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.SeeBuildGuWenResultBean;
import landz.fdy.com.p1_landz.freamwork.http.HttpHelper;
import landz.fdy.com.p1_landz.freamwork.http.HttpRequestAsynctask;
import landz.fdy.com.p1_landz.freamwork.image.ImageLoader;
import landz.fdy.com.p1_landz.freamwork.utils.LogUtils;
import landz.fdy.com.p1_landz.landz.MyApplication;
import landz.fdy.com.p1_landz.landz.UI.welcome.View.HouseDetailTitleBar;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild_fragment.SeeBuild_Fragment_1;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild_fragment.SeeBuild_Fragment_2;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild_fragment.SeeBuild_Fragment_3;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild_fragment.SeeBuild_Fragment_4;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild_fragment.SeeBuild_Fragment_5;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild_fragment.SeeBuild_Fragment_6;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild_fragment.SeeBuild_Fragment_7;

public class SeeBuildMoreDetailActivity extends BaseActivity implements SeeBuild_Fragment_6.showImgPop{

   private String prodelId,resblockOneName;

    private HouseDetailTitleBar seebuild_titleBar;

    private ScrollView seebuild_ScrollView;

    private ImageLoader imageLoader;

    private SeeBuild_Fragment_1 seeBuild_fragment_1;//ViewPager 展示

    private SeeBuild_Fragment_2 seeBuild_fragment_2;//房源介绍

    private SeeBuild_Fragment_3 seeBuild_fragment_3;//项目特点描述

    private SeeBuild_Fragment_4 seeBuild_fragment_4;//顾问

    private SeeBuild_Fragment_5 seeBuild_fragment_5;//楼盘描述

    private SeeBuild_Fragment_6 seeBuild_fragment_6;//主力户型

    private SeeBuild_Fragment_7 seeBuild_fragment_7;//更多推荐

    private SeeBuildBottomView seeBuildBottomView;



    @Override
    public int getContentViewId() {
        return R.layout.activity_see_build_more_detail;
    }

    @Override
    public void beforeInitView() {
        imageLoader=new ImageLoader();
        prodelId=getIntent().getStringExtra("resblockOneId");
        LogUtils.e("------------------"+prodelId);
        resblockOneName=getIntent().getStringExtra("resblockOneName");
    }

    @Override
    public void InitView() {
        seebuild_titleBar=findViewByIdNoCast(R.id.seebuild_titleBar);
        seeBuildBottomView=findViewByIdNoCast(R.id.seebuild_bottomView);
        seebuild_ScrollView=findViewByIdNoCast(R.id.seebuild_scrollView);
        seeBuild_fragment_1= (SeeBuild_Fragment_1) getSupportFragmentManager().findFragmentById(R.id.seebuild_detail_fragment_1);
        seeBuild_fragment_2= (SeeBuild_Fragment_2) getSupportFragmentManager().findFragmentById(R.id.seebuild_detail_fragment_2);
        seeBuild_fragment_3= (SeeBuild_Fragment_3) getSupportFragmentManager().findFragmentById(R.id.seebuild_detail_fragment_3);
        seeBuild_fragment_4= (SeeBuild_Fragment_4) getSupportFragmentManager().findFragmentById(R.id.seebuild_detail_fragment_4);
        seeBuild_fragment_5= (SeeBuild_Fragment_5) getSupportFragmentManager().findFragmentById(R.id.seebuild_detail_fragment_5);
        seeBuild_fragment_6= (SeeBuild_Fragment_6) getSupportFragmentManager().findFragmentById(R.id.seebuild_detail_fragment_6);
        seeBuild_fragment_7= (SeeBuild_Fragment_7) getSupportFragmentManager().findFragmentById(R.id.seebuild_detail_fragment_7);
    }

    @Override
    public void InitData() {
        getData();
        getGuWen();
        getMoreTuijian();

    }

    private void getData(){
        HttpHelper.getSeebuildDetail(this, prodelId, new HttpRequestAsynctask.Callback() {
            @Override
            public void OnSuccess(String result) {
                LogUtils.e("result_detail---"+result);
                SeeBuildDetailResultBean resultBean=new Gson().fromJson(result,SeeBuildDetailResultBean.class);
                LogUtils.e("resultBean_detail---"+resultBean);
                if(resultBean!=null&&resultBean.result!=null){
                    seebuild_titleBar.setTitle(resultBean.result.resblockOneName,resultBean.result.apartmentBegin+"-"+resultBean.result.apartmentEnd+"居"+" "+
                    resultBean.result.unitprBegin+"-"+resultBean.result.unitprEnd+"万元/平米"+" "+
                    resultBean.result.totalprBegin+"-"+resultBean.result.totalprEnd+"万");
                    seeBuild_fragment_1.setImgUrlArrSeebuild(resultBean.result.imgUrlArr);
                    MyApplication.getApplication().setImgUrlArrSeebuild(resultBean.result.imgUrlArr);
                    seeBuild_fragment_2.setResult(resultBean.result);
                    seeBuild_fragment_6.setResult(resultBean.result.apartmentImgVos);
                    seeBuild_fragment_3.setResult(resultBean.result);
                    seeBuild_fragment_5.setResult(resultBean.result);
                    seebuild_ScrollView.scrollTo(0,0);
                }

            }

            @Override
            public void Onfailed(String errMsg) {

            }
        });
    }

    private void getGuWen(){
        HttpHelper.getSeeGuWen(this, prodelId, new HttpRequestAsynctask.Callback() {
            @Override
            public void OnSuccess(String result) {
                LogUtils.e("result_guwen---"+result);
                SeeBuildGuWenResultBean resultBean=new Gson().fromJson(result,SeeBuildGuWenResultBean.class);
                LogUtils.e("result_resultBean"+resultBean.toString());
                if(resultBean!=null){
                    seeBuild_fragment_4.setResult(resultBean.result);
                    seeBuild_fragment_4.setProdelId(prodelId);
                    if(resultBean.result.brokerSeeVos!=null&&!resultBean.result.brokerSeeVos.isEmpty()){
                        seeBuildBottomView.setBrokerSeeVosBean(SeeBuildMoreDetailActivity.this,resultBean.result.brokerSeeVos.get(0),imageLoader);
                    }
                 }
                seebuild_ScrollView.scrollTo(0,0);
            }

            @Override
            public void Onfailed(String errMsg) {

            }
        });
    }

    private void getMoreTuijian(){
        HttpHelper.getMoreTuijian(this, resblockOneName, new HttpRequestAsynctask.Callback() {
            @Override
            public void OnSuccess(String result) {
                LogUtils.e("result_more更多推荐"+result);
                MoreTuijianResultBean resultBean=new Gson().fromJson(result,MoreTuijianResultBean.class);
                LogUtils.e("更多推荐正确"+resultBean.toString());
                if(resultBean!=null){
                    seeBuild_fragment_7.setMoreTuijianBeen(resultBean.result);
                    seeBuild_fragment_7.setResblockOneName(resblockOneName);
                    seeBuild_fragment_7.setProdelId(prodelId);
                }
                seebuild_ScrollView.scrollTo(0,0);
            }

            @Override
            public void Onfailed(String errMsg) {

            }
        });

    }



    @Override
    public void onClick(View view) {

    }

    @Override
    public void showpop(String url) {
       HuxingPopWindow huxingPopWindow=new HuxingPopWindow(this,url);
        huxingPopWindow.showAsDropDown(seebuild_titleBar);
    }


}
