package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseActivity;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.GuwenlistResultBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.SeeGuwenListBean;
import landz.fdy.com.p1_landz.freamwork.http.HttpHelper;
import landz.fdy.com.p1_landz.freamwork.http.HttpRequestAsynctask;
import landz.fdy.com.p1_landz.freamwork.utils.LogUtils;
import landz.fdy.com.p1_landz.freamwork.utils.ToastUtil;
import landz.fdy.com.p1_landz.landz.UI.welcome.View.RefreshListView;
import landz.fdy.com.p1_landz.landz.UI.welcome.request.SeeBuildRequest;

public class SeeBuildGuwenActivity extends BaseActivity{

    private String prodelId;

    private  GuwenlistAdapter guwenlistAdapter;

    private RefreshListView lv_guwenlist;

    private SeeBuildRequest request;

//    private List<SeeGuwenListBean> result;
//
//    public void setResult(List<SeeGuwenListBean> result) {
//        this.result = result;
//        getGuwenlist();
//        InitData();
//    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_see_build_guwen;
    }

    @Override
    public void beforeInitView() {
        prodelId=getIntent().getStringExtra("resblockOneId");
        request=new SeeBuildRequest();
    }

    @Override
    public void InitView() {
        lv_guwenlist=findViewByIdNoCast(R.id.lv_guwenlist);
        getGuwenlist();
    }
 private int pageNo=0;
    @Override
    public void InitData() {
        lv_guwenlist.setOnLoadMoreListener(new RefreshListView.OnLoadMoreListener() {
            @Override
            public void loadMore() {
//                int no=Integer.parseInt(request.pageNo);
//                no++;
//                request.pageNo=no+"";
                pageNo++;
                LogUtils.e("msg","pageNo"+pageNo);
                getGuwenlist();
            }

            @Override
            public void onRefresh() {
                pageNo=0;
                getGuwenlist();
            }
        });


    }
    int i=0;
    List<SeeGuwenListBean> new_list=new ArrayList<>();
    private void getGuwenlist(){
         showProgressBar();
         HttpHelper.getSeeGuWenList(this, pageNo,prodelId, new HttpRequestAsynctask.Callback() {
            @Override
            public void OnSuccess(String result) {
                lv_guwenlist.setOnComplete();
                dismissProgressBar();
                LogUtils.e("result——顾问列表"+result);
                GuwenlistResultBean resultBean=new Gson().fromJson(result,GuwenlistResultBean.class);
                LogUtils.e("resultBean--顾问结果"+resultBean.toString());
//                if(resultBean!=null){
//                    SeeBuildGuwenActivity seeBuildGuwen=new SeeBuildGuwenActivity();
//                    seeBuildGuwen.setResult(resultBean.result.brokerSeeVos);
//                }
                   if(pageNo==0){
                       if(resultBean!=null){
                           LogUtils.e("msg","加载了数据");
                           guwenlistAdapter=new GuwenlistAdapter(SeeBuildGuwenActivity.this,resultBean.result.brokerSeeVos);
                           lv_guwenlist.setAdapter(guwenlistAdapter);
                       }

                   }

                new_list.addAll(resultBean.result.brokerSeeVos);
                guwenlistAdapter.setBrokerSeeVos(new_list);
                guwenlistAdapter.notifyDataSetChanged();
                LogUtils.e("msg","i====="+i);




            }

            @Override
            public void Onfailed(String errMsg) {
                lv_guwenlist.setOnComplete();
                dismissProgressBar();
                ToastUtil.showToast(errMsg);
            }
        });
    }


    @Override
    public void onClick(View view) {

    }
}
