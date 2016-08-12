package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseActivity;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.HouseOneArrBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ResblockOneArrBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ResultBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.SeeBuildResult;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.onlineHouseBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.paramListBean;
import landz.fdy.com.p1_landz.freamwork.http.HttpHelper;
import landz.fdy.com.p1_landz.freamwork.http.HttpRequestAsynctask;
import landz.fdy.com.p1_landz.freamwork.utils.IntentUtils;
import landz.fdy.com.p1_landz.freamwork.utils.LogUtils;
import landz.fdy.com.p1_landz.freamwork.utils.ToastUtil;
import landz.fdy.com.p1_landz.landz.MyApplication;
import landz.fdy.com.p1_landz.landz.UI.welcome.CallBack.TosatCallBack;
import landz.fdy.com.p1_landz.landz.UI.welcome.Serch.SerchActivity;
import landz.fdy.com.p1_landz.landz.UI.welcome.View.MyPopwindow;
import landz.fdy.com.p1_landz.landz.UI.welcome.View.RefreshListView;
import landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse.OnlineHouseAdapter;
import landz.fdy.com.p1_landz.landz.UI.welcome.request.SeeBuildRequest;

public class SeeBuildActivity extends BaseActivity {

    private onlineHouseBean onlinehouseBean;

   private SeeBuildRequest request;

    private TextView tv_seebuild_location, tv_seebuild_price, tv_seebuild_room, tv_seebuild_type, tv_seebuild_more;

    //加载数据的ListView
    private RefreshListView lv_seebuild;

    private List<Object> totalList;

    private SeeBuildAdapter seeBuildAdapter;

    private OnlineHouseAdapter onlineHouseAdapter;//适配器
    @Override
    public int getContentViewId() {
        return R.layout.activity_see_build;
    }

    @Override
    public void beforeInitView() {
         request=new SeeBuildRequest();
        onlinehouseBean = MyApplication.getApplication().getonlineHouseBean();
        totalList=new ArrayList<>();
    }

    @Override
    public void InitView() {
        tv_seebuild_location=findViewByIdNoCast(R.id.tv_seebuild_location);
        tv_seebuild_price=findViewByIdNoCast(R.id.tv_seebuild_price);
        tv_seebuild_room=findViewByIdNoCast(R.id.tv_seebuild_room);
        tv_seebuild_type=findViewByIdNoCast(R.id.tv_seebuild_type);
        tv_seebuild_more=findViewByIdNoCast(R.id.tv_seebuild_more);
        lv_seebuild=findViewByIdNoCast(R.id.lv_seebuild);


    }

    @Override
    public void InitData() {

        setOnClick(tv_seebuild_location,tv_seebuild_price,tv_seebuild_room,tv_seebuild_type,tv_seebuild_more);
        setOnClick(R.id.et_seebuild_title);
        seeBuildAdapter=new SeeBuildAdapter(this);
        lv_seebuild.setAdapter(seeBuildAdapter);
        lv_seebuild.setOnLoadMoreListener(new RefreshListView.OnLoadMoreListener() {
            @Override
            public void loadMore() {
               int no=Integer.parseInt(request.pageNo);
                no++;
                request.pageNo=no+"";
                getData();
            }

            @Override
            public void onRefresh() {

                 request.pageNo="0";
                getData();
            }
        });
       lv_seebuild.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               if(position>0){
                   if(seeBuildAdapter.getItem(position-1)instanceof ResblockOneArrBean){
                   ResblockOneArrBean bean= (ResblockOneArrBean) seeBuildAdapter.getItem(position-1);
                   Bundle bundle=new Bundle();
                   bundle.putString("resblockOneId",bean.prodelId);
                   bundle.putString("resblockOneName",bean.resblockOneName);
                   IntentUtils.openActivity(SeeBuildActivity.this,SeeBuildMoreDetailActivity.class,bundle);
                   }
               }
           }
       });
        getData();
    }

    public void getData(){
        showProgressBar();
        if(request.pageNo.equals("0")){
            totalList.clear();
        }
        HttpHelper.getSeeBuild(this,request, new HttpRequestAsynctask.Callback() {
            @Override
            public void OnSuccess(String result) {
                lv_seebuild.setOnComplete();
                dismissProgressBar();
                LogUtils.e("result_seebuild---"+result);
                SeeBuildResult resultBean=new Gson().fromJson(result,SeeBuildResult.class);
                LogUtils.e("result_resultBean---"+resultBean.toString());
                resultBean.initListData(resultBean,totalList);
                seeBuildAdapter.setTotalList(totalList);
                seeBuildAdapter.notifyDataSetChanged();
            }

            @Override
            public void Onfailed(String errMsg) {
               lv_seebuild.setOnComplete();
                dismissProgressBar();
                ToastUtil.showToast(errMsg);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.et_seebuild_title:
                Bundle bundle=new Bundle();
                bundle.putInt("type",2);
                Intent intent1=new Intent(SeeBuildActivity.this, SerchActivity.class);
                intent1.putExtras(bundle);
                startActivity(intent1);
                break;
            case R.id.tv_seebuild_location:
                List<paramListBean> paramList1 = null;
                for(ResultBean resultBean :onlinehouseBean.result)
                if("1001".equals(resultBean.paramType)){
                    paramList1=resultBean.paramList;
                }
                MyPopwindow myPopwindow1=new MyPopwindow(SeeBuildActivity.this, new TosatCallBack() {
                    @Override
                    public void isToast(paramListBean paramlistBean) {
                        ToastUtil.showToast(paramlistBean.name.toString());
                        if(paramlistBean==null){
                            return;
                        }
                        tv_seebuild_location.setText(""+paramlistBean.name);
                        request.circleTypeCode=paramlistBean.key;
                        request.pageNo="0";
                        totalList.clear();
                        getData();
                    }
                });
                myPopwindow1.setParamListBean(paramList1,false);
                myPopwindow1.showPopWindow(tv_seebuild_location);
                break;
            case R.id.tv_seebuild_price:
                List<paramListBean> paramList2=null;
                for(ResultBean resultBean : onlinehouseBean.result)
                if("1003".equals(resultBean.paramType)){
                    paramList2=resultBean.paramList;
                }
                MyPopwindow myPopwindow2=new MyPopwindow(SeeBuildActivity.this, new TosatCallBack() {
                    @Override
                    public void isToast(paramListBean paramlistBean) {
                        ToastUtil.showToast(paramlistBean.name.toString());
                        if(paramlistBean==null){
                            return;
                        }
                        tv_seebuild_price.setText(""+paramlistBean.name);
                        request.avgPriceBegin=paramlistBean.minValue;
                        request.avgPriceEnd=paramlistBean.maxValue;
                        request.pageNo="0";
                        totalList.clear();
                        getData();
                    }
                });
                myPopwindow2.setParamListBean(paramList2,true);
                myPopwindow2.showPopWindow(tv_seebuild_price);
                break;
            case R.id.tv_seebuild_room:
                List<paramListBean> paramList3=null;
                for(ResultBean resultBean : onlinehouseBean.result){
                    if("1005".equals(resultBean.paramType)){
                       paramList3=resultBean.paramList;
                    }
                }
                MyPopwindow myPopwindow3=new MyPopwindow(SeeBuildActivity.this, new TosatCallBack() {
                    @Override
                    public void isToast(paramListBean paramlistBean) {
                        if(paramlistBean==null){
                            return;
                        }
                        tv_seebuild_room.setText(""+paramlistBean.name);
                        request.roomNumber=paramlistBean.value;
                        request.pageNo="0";
                        totalList.clear();
                        getData();
                    }
                });
                  myPopwindow3.setParamListBean(paramList3,true);
                 myPopwindow3.showPopWindow(tv_seebuild_room);
                break;
            case R.id.tv_seebuild_type:
                  List<paramListBean> paramList4=null;
                for(ResultBean resultBean :onlinehouseBean.result){
                    if("1006".equals(resultBean.paramType)){
                        paramList4=resultBean.paramList;
                    }
                }
                MyPopwindow myPopwindow4=new MyPopwindow(SeeBuildActivity.this, new TosatCallBack() {
                    @Override
                    public void isToast(paramListBean paramlistBean) {
                        if(paramlistBean==null){
                            return;
                        }
                        tv_seebuild_type.setText(""+paramlistBean.name);
                        request.resblockType=paramlistBean.name;
                        request.pageNo="0";
                        totalList.clear();
                        getData();
                    }
                });
                 myPopwindow4.setParamListBean(paramList4,true);
                 myPopwindow4.showPopWindow(tv_seebuild_type);
                break;
            case R.id.tv_seebuild_more:
                Intent intent=new Intent(SeeBuildActivity.this,SeeBuildSelectMoreActivity.class);
                startActivityForResult(intent,1);
                break;

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==200){
            if(data!=null){
               request.circleTypeCode=data.getStringExtra("circleTypeCode");
                request.isFavorable=data.getStringExtra("isFavorable");
                request.onlyLook=data.getStringExtra("onlyLook");
                request.pageNo="0";
                getData();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
