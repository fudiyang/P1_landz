package landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse;


import android.view.View;
import android.widget.ScrollView;


import com.google.gson.Gson;
import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseActivity;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.GuWenResultBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.HouseDetailResultBean;

import landz.fdy.com.p1_landz.freamwork.http.HttpHelper;
import landz.fdy.com.p1_landz.freamwork.http.HttpRequestAsynctask;
import landz.fdy.com.p1_landz.freamwork.image.ImageLoader;
import landz.fdy.com.p1_landz.freamwork.utils.LogUtils;
import landz.fdy.com.p1_landz.landz.MyApplication;
import landz.fdy.com.p1_landz.landz.UI.welcome.View.HouseDetailBottomView;
import landz.fdy.com.p1_landz.landz.UI.welcome.View.HouseDetailTitleBar;
import landz.fdy.com.p1_landz.landz.UI.welcome.View.OtherHousePopWindow;
import landz.fdy.com.p1_landz.landz.UI.welcome.fragment.DetailFragment_1;
import landz.fdy.com.p1_landz.landz.UI.welcome.fragment.DetailFragment_2;
import landz.fdy.com.p1_landz.landz.UI.welcome.fragment.DetailFragment_3;
import landz.fdy.com.p1_landz.landz.UI.welcome.fragment.DetailFragment_4;
import landz.fdy.com.p1_landz.landz.UI.welcome.fragment.DetailFragment_5;
import landz.fdy.com.p1_landz.landz.UI.welcome.fragment.DetailFragment_6;
import landz.fdy.com.p1_landz.landz.UI.welcome.fragment.DetailFragment_7;


public class HouseOneDetailActivity extends BaseActivity implements DetailFragment_7.showPopPic {

     private HouseDetailTitleBar titleBar;

     private ScrollView scrollView;

     private String houseOneId,resblockId;

     private ImageLoader imageLoader;

     private DetailFragment_1 detailFragment_1;//ViewPager 展示

     private DetailFragment_2 detailFragment_2;//房源描述

    private DetailFragment_3 detailFragment_3;//本房顾问

    private DetailFragment_4 detailFragment_4;//房源基本信息

    private DetailFragment_5 detailFragment_5;//房源基本信息

    private DetailFragment_6 detailFragment_6;//更多推荐

    private DetailFragment_7 detailFragment_7;//其他推荐

    private HouseDetailBottomView bottomView;


    @Override
    public int getContentViewId() {
        return R.layout.activity_house_one_detail;
    }

    @Override
    public void beforeInitView() {
        imageLoader=new ImageLoader();
        houseOneId=getIntent().getStringExtra("houseOneId");
        resblockId=getIntent().getStringExtra("resblockId");

    }

    @Override
    public void InitView() {
        titleBar=findViewByIdNoCast(R.id.titleBar);
        bottomView=findViewByIdNoCast(R.id.bottomView);
        scrollView=findViewByIdNoCast(R.id.scrollView);
        detailFragment_1= (DetailFragment_1) getSupportFragmentManager().findFragmentById(R.id.detail_fragment1);
        detailFragment_2= (DetailFragment_2) getSupportFragmentManager().findFragmentById(R.id.detail_fragment2);
        detailFragment_3= (DetailFragment_3) getSupportFragmentManager().findFragmentById(R.id.detail_fragment3);
        detailFragment_4= (DetailFragment_4) getSupportFragmentManager().findFragmentById(R.id.detail_fragment4);
        detailFragment_5= (DetailFragment_5) getSupportFragmentManager().findFragmentById(R.id.detail_fragment5);
        detailFragment_6= (DetailFragment_6) getSupportFragmentManager().findFragmentById(R.id.detail_fragment6);
        detailFragment_7= (DetailFragment_7) getSupportFragmentManager().findFragmentById(R.id.detail_fragment7);

    }

    @Override
    public void InitData() {

        detailFragment_6.setOneHouseDetailId(houseOneId,resblockId);
        getData();
        getGuWenData();


    }

    public  void getData(){
        HttpHelper.getDetail(this, houseOneId, new HttpRequestAsynctask.Callback() {

            @Override
            public void OnSuccess(String result) {
                LogUtils.e("msg","result:"+result);
                HouseDetailResultBean resultBean=new Gson().fromJson(result,HouseDetailResultBean.class);
                if(resultBean!=null&& resultBean.result!=null){

                             titleBar.setTitle(resultBean.result.resblockOneName,resultBean.result.totalprBegin+ "-" +resultBean.result.totalprEnd + "万"+" "+resultBean.result.gfa+ "平米"+" "+resultBean.result.bedroomAmount + "室" +resultBean.result.parlorAmount + "厅" +resultBean.result.parlorAmount + "卫");
                             detailFragment_1.setImgUrlArr(resultBean.result.imgUrlArr);
                    MyApplication.getApplication().setImgUrlArr(resultBean.result.imgUrlArr);
                             detailFragment_2.setResultBean(resultBean,imageLoader);
                             detailFragment_4.setResult(resultBean.result);
                             String desc=resultBean.result.bedroomAmount+"室"+resultBean.result.parlorAmount+"厅"+resultBean.result.parlorAmount+"卫"
                                     +" "+resultBean.result.innenbereichSize+"平米";
                            detailFragment_7.setDesc(desc);
                          if (resultBean.result.imgUrlArr != null && !resultBean.result.imgUrlArr.isEmpty())
                            detailFragment_7.setOther_house(resultBean.result.imgUrlArr.get(0).picName);
                            detailFragment_5.setResult(resultBean.result);
                             scrollView.scrollTo(0,0);
                }

            }

            @Override
            public void Onfailed(String errMsg) {

            }
        });
    }

    public  void getGuWenData(){
         HttpHelper.getDetailLook(this, houseOneId, new HttpRequestAsynctask.Callback() {
             @Override
             public void OnSuccess(String result) {
                 LogUtils.e("msg","result-name:"+result);
                 GuWenResultBean resultBean=new Gson().fromJson(result,GuWenResultBean.class);
                 LogUtils.e("msg","resultBean-name"+resultBean.toString());
                 if(resultBean!=null){
                        detailFragment_3.setResult(resultBean.result);
                     if(resultBean.result.showArr!=null&&!resultBean.result.showArr.isEmpty()){
                            bottomView.setShowArr(HouseOneDetailActivity.this,resultBean.result.showArr.get(0),imageLoader);
                     }
                 }

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
    public void showPop(String url) {
        LogUtils.e("Url:   " + url);
        OtherHousePopWindow otherHousePopWindow=new OtherHousePopWindow(this,url);
        otherHousePopWindow.showPopwindow(titleBar);
    }
}


