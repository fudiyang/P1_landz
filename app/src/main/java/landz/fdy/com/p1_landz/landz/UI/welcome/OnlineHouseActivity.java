package landz.fdy.com.p1_landz.landz.UI.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseActivity;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.HouseArrBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.HouseOneArrBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.OnlineHouseResult;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ResultBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.onlineHouseBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.paramListBean;
import landz.fdy.com.p1_landz.freamwork.http.HttpHelper;
import landz.fdy.com.p1_landz.freamwork.http.HttpRequestAsynctask;
import landz.fdy.com.p1_landz.freamwork.utils.IntentUtils;
import landz.fdy.com.p1_landz.freamwork.utils.LogUtils;
import landz.fdy.com.p1_landz.freamwork.utils.ToastUtil;
import landz.fdy.com.p1_landz.landz.MyApplication;
import landz.fdy.com.p1_landz.landz.UI.welcome.CallBack.TosatCallBack;
import landz.fdy.com.p1_landz.landz.UI.welcome.View.MyPopwindow;
import landz.fdy.com.p1_landz.landz.UI.welcome.View.RefreshListView;
import landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse.HouseOneDetailActivity;
import landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse.OnlineHouseAdapter;
import landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse.SelectMoreActivity;
import landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse.onlineAdapter;
import landz.fdy.com.p1_landz.landz.UI.welcome.request.OnLineHouseRequest;

public class OnlineHouseActivity extends BaseActivity implements TosatCallBack {
    private onlineHouseBean onlinehouseBean;

    private TextView tv_location, tv_price, tv_room, tv_type, tv_more;

    //加载数据的ListView
    private RefreshListView lv_online_house;

    private int currentPos = -1;//popwindow标志位

    private List<Object> totalList;

    private Handler handler;

    private OnLineHouseRequest  request;//请求对象

    private OnlineHouseAdapter onlineHouseAdapter;//适配器

    @Override
    public int getContentViewId() {
        return R.layout.activity_online_house;
    }

    @Override
    public void beforeInitView() {
        request = new OnLineHouseRequest();
        request.resblockName=getIntent().getStringExtra("resblockName");
        request.circleTypeCode=getIntent().getStringExtra("circleTypeCode");
        totalList = new ArrayList<>();
        onlinehouseBean = MyApplication.getApplication().getonlineHouseBean();
        LogUtils.e("msg", onlinehouseBean.toString());
    }

    @Override
    public void InitView() {
        tv_location = findViewByIdNoCast(R.id.tv_location);
        tv_price = findViewByIdNoCast(R.id.tv_price);
        tv_room = findViewByIdNoCast(R.id.tv_room);
        tv_type = findViewByIdNoCast(R.id.tv_type);
        tv_more = findViewByIdNoCast(R.id.tv_more);
        lv_online_house = findViewByIdNoCast(R.id.lv_online_house);
    }

    @Override
    public void InitData() {
        setOnClick(tv_location, tv_price, tv_room, tv_type, tv_more);
        onlineHouseAdapter = new OnlineHouseAdapter(this);
        lv_online_house.setAdapter(onlineHouseAdapter);
        lv_online_house.setOnLoadMoreListener(new RefreshListView.OnLoadMoreListener() {
            @Override
            public void loadMore() {
                request.pageNo++;
                getData();

            }

            @Override
            public void onRefresh() {
                totalList.clear();
                request.pageNo = 0;
                getData();
            }
        });
        lv_online_house.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                  if(position>0){
                      if(onlineHouseAdapter.getItem(position-1) instanceof HouseOneArrBean){
                           HouseOneArrBean bean= (HouseOneArrBean) onlineHouseAdapter.getItem(position-1);
                          Bundle bundle=new Bundle();
                          bundle.putString("houseOneId",bean.houseOneId);
                          IntentUtils.openActivity(OnlineHouseActivity.this, HouseOneDetailActivity.class,bundle);
                      }

                  }
            }
        });
        getData();
    }

    public void getData() {
        showProgressBar();
        if(request.pageNo==0)
            totalList.clear();
        HttpHelper.getOnLineHouseList(this, request, new HttpRequestAsynctask.Callback() {
            @Override
            public void OnSuccess(String result) {
                lv_online_house.setOnComplete();
                dismissProgressBar();
                LogUtils.e("result:" + result);
                 OnlineHouseResult resultBean = new Gson().fromJson(result, OnlineHouseResult.class);
                resultBean.initListData(resultBean, totalList);
                onlineHouseAdapter.setTotalList(totalList);
                onlineHouseAdapter.notifyDataSetChanged();

            }

            @Override
            public void Onfailed(String errMsg) {
                lv_online_house.setOnComplete();
                dismissProgressBar();
                ToastUtil.showToast(errMsg);
            }
        });


    }

    @Override
    public void onClick(View view) {
        LogUtils.e("msg", "fffffffffffffffff");
        switch (view.getId()) {
            case R.id.tv_location:
                List<paramListBean> paramList = null;
                for (ResultBean resultBean : onlinehouseBean.result) {
                    if ("1001".equals(resultBean.paramType)) {
                        paramList = resultBean.paramList;
                        LogUtils.e("msg", "fffffffffffffffff");

                    }
                }
                MyPopwindow myPopwindow = new MyPopwindow(OnlineHouseActivity.this, new TosatCallBack() {
                    @Override
                    public void isToast(paramListBean paramlistBean) {
                        ToastUtil.showToast(paramlistBean.name.toString());
                        if (paramlistBean == null) {
                            return;
                        }
                        tv_location.setText("" + paramlistBean.name);
                        request.circleTypeCode = paramlistBean.key;
                        request.pageNo = 0;
                        totalList.clear();
                        getData();
                    }
                });

                myPopwindow.setParamListBean(paramList, false);
                LogUtils.e("msg", "paramList:" + paramList.toString());
                myPopwindow.showPopWindow(tv_location);
                break;
            case R.id.tv_price:
                List<paramListBean> paramList1 = null;
                for (ResultBean resultBean : onlinehouseBean.result) {
                    if ("1008".equals(resultBean.paramType)) {
                        paramList1 = resultBean.paramList;
                        LogUtils.e("msg", "fffffffffffffffff");

                    }
                }
                MyPopwindow myPopwindow1 = new MyPopwindow(OnlineHouseActivity.this, new TosatCallBack() {
                    @Override
                    public void isToast(paramListBean paramlistBean) {
                        ToastUtil.showToast(paramlistBean.name.toString());
                        if (paramlistBean == null) {
                            return;
                        }
                        tv_price.setText("" + paramlistBean.name);
                        LogUtils.e("msg", "paramlistBean.minValue" + paramlistBean.minValue);
                        LogUtils.e("msg", "paramlistBean.maxValue" + paramlistBean.maxValue);
                        request.totalPricesBegin = paramlistBean.minValue;
                        request.totalPricesEnd = paramlistBean.maxValue;
                         request.pageNo = 0;
                        totalList.clear();
                        getData();
                    }
                });

                myPopwindow1.setParamListBean(paramList1, true);
                LogUtils.e("msg", "paramList:" + paramList1.toString());
                myPopwindow1.showPopWindow(tv_price);
                break;
            case R.id.tv_room:
                List<paramListBean> paramList2 = null;
                for (ResultBean resultBean : onlinehouseBean.result) {
                    if ("1005".equals(resultBean.paramType)) {
                        paramList2 = resultBean.paramList;
                        LogUtils.e("msg", "fffffffffffffffff");

                    }
                }
                MyPopwindow myPopwindow2 = new MyPopwindow(OnlineHouseActivity.this, new TosatCallBack() {
                    @Override
                    public void isToast(paramListBean paramlistBean) {
                        ToastUtil.showToast(paramlistBean.name.toString());
                        if (paramlistBean == null) {
                            return;
                        }
                        tv_room.setText("" + paramlistBean.name);
                        request.bedroomAmount = paramlistBean.value;
                        request.pageNo = 0;
                        totalList.clear();
                        getData();
                    }
                });

                myPopwindow2.setParamListBean(paramList2, true);
                LogUtils.e("msg", "paramList:" + paramList2.toString());
                myPopwindow2.showPopWindow(tv_room);
                break;
            case R.id.tv_type:
                List<paramListBean> paramList3 = null;
                for (ResultBean resultBean : onlinehouseBean.result) {
                    if ("1006".equals(resultBean.paramType)) {
                        paramList3 = resultBean.paramList;
                        LogUtils.e("msg", "fffffffffffffffff");

                    }
                }
                MyPopwindow myPopwindow3 = new MyPopwindow(OnlineHouseActivity.this, new TosatCallBack() {
                    @Override
                    public void isToast(paramListBean paramlistBean) {
                        ToastUtil.showToast(paramlistBean.name.toString());
                        if (paramlistBean == null) {
                            return;
                        }
                        tv_type.setText("" + paramlistBean.name);
                        request.buildingType = paramlistBean.name;
                        request.pageNo = 0;
                        totalList.clear();
                        getData();
                    }
                });

                myPopwindow3.setParamListBean(paramList3, true);
                LogUtils.e("msg", "paramList:" + paramList3.toString());
                myPopwindow3.showPopWindow(tv_type);
                break;
            case R.id.tv_more:
//                List<paramListBean> paramList4 = null;
//                for (ResultBean resultBean : onlinehouseBean.result) {
//                    if ("1006".equals(resultBean.paramType)) {
//                        paramList4 = resultBean.paramList;
//                        LogUtils.e("msg","fffffffffffffffff");
//
//                    }
//                }
//                MyPopwindow myPopwindow4 = new MyPopwindow(OnlineHouseActivity.this, new TosatCallBack() {
//                    @Override
//                    public void isToast(paramListBean paramlistBean) {
//                        ToastUtil.showToast(paramlistBean.toString());
//                        ToastUtil.showToast(paramlistBean.childList.toString());
//                    }
//                });
//
//                myPopwindow4.setParamListBean(paramList4);
//                LogUtils.e("msg","paramList:"+paramList4.toString());
//                myPopwindow4.showPopWindow(tv_more);
                Intent intent = new Intent(OnlineHouseActivity.this, SelectMoreActivity.class);
                startActivityForResult(intent, 1);

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 100) {
            if (data != null) {
                request.sort = data.getStringExtra("sort");
                request.buildSizeBegin = data.getStringExtra("buildSizeBegin");
                request.buildSizeEnd = data.getStringExtra("buildSizeEnd");
                request.feature = data.getStringExtra("feature");
                request.onlyLook = data.getStringExtra("onlyLook");
                request.pageNo = 0;
                getData();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void isToast(paramListBean paramlistBean) {

    }

}