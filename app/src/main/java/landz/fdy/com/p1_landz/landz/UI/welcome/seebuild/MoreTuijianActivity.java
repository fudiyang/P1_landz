package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseActivity;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.MoreListBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.MoreListResultBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ResblockOneArrBean;
import landz.fdy.com.p1_landz.freamwork.http.HttpHelper;
import landz.fdy.com.p1_landz.freamwork.http.HttpRequestAsynctask;
import landz.fdy.com.p1_landz.freamwork.utils.IntentUtils;
import landz.fdy.com.p1_landz.freamwork.utils.LogUtils;
import landz.fdy.com.p1_landz.freamwork.utils.ToastUtil;
import landz.fdy.com.p1_landz.landz.UI.welcome.View.RefreshListView;
import landz.fdy.com.p1_landz.landz.UI.welcome.request.SeeBuildRequest;

public class MoreTuijianActivity extends BaseActivity {

    private String resblockOneName, prodelId;

    private MoreTuijianlistAdapter moreTuijianlistAdapter;

    private RefreshListView lv_morelist;

    private SeeBuildRequest request;

    @Override
    public int getContentViewId() {
        return R.layout.activity_more_tuijian;
    }

    @Override
    public void beforeInitView() {
        resblockOneName = getIntent().getStringExtra("resblockOneName");
        prodelId = getIntent().getStringExtra("prodelId");
        request = new SeeBuildRequest();
    }

    @Override
    public void InitView() {
        lv_morelist = findViewByIdNoCast(R.id.lv_morelist);
        getMoreList();
    }

    private int pageNo = 0;

    @Override
    public void InitData() {
        lv_morelist.setOnLoadMoreListener(new RefreshListView.OnLoadMoreListener() {
            @Override
            public void loadMore() {
//                int no=Integer.parseInt(request.pageNo);
//                no++;
                pageNo++;
                LogUtils.e("msg", "pageno=" + pageNo);
                getMoreList();
            }

            @Override
            public void onRefresh() {
                pageNo = 0;
                getMoreList();
            }
        });
        lv_morelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position > 0) {
                    if (moreTuijianlistAdapter.getItem(position - 1) instanceof MoreListBean) {
                        Bundle bundle = new Bundle();
                        MoreListBean bean = (MoreListBean) moreTuijianlistAdapter.getItem(position - 1);
                        bundle.putString("resblockOneId", bean.prodelId);
                        bundle.putString("resblockOneName", bean.resblockOneName);
                        IntentUtils.openActivity(MoreTuijianActivity.this, SeeBuildMoreDetailActivity.class, bundle);
                    }
                }
            }
        });

    }

    @Override
    public void onClick(View view) {

    }

    List<MoreListBean> new_list = new ArrayList<>();

    private void getMoreList() {
        showProgressBar();
        HttpHelper.getMoreTuijianlist(this, pageNo, resblockOneName, new HttpRequestAsynctask.Callback() {
            @Override
            public void OnSuccess(String result) {
                lv_morelist.setOnComplete();
                dismissProgressBar();
                LogUtils.e("更多列表推荐" + result);
                MoreListResultBean resultBean = new Gson().fromJson(result, MoreListResultBean.class);

                if (pageNo == 0) {
                    if (resultBean != null) {
                        moreTuijianlistAdapter = new MoreTuijianlistAdapter(MoreTuijianActivity.this, resultBean.result);
                        lv_morelist.setAdapter(moreTuijianlistAdapter);
                    }

                }

                new_list.addAll(resultBean.result);
                moreTuijianlistAdapter.setMoreTuijian(new_list);
                moreTuijianlistAdapter.notifyDataSetChanged();

            }

            @Override
            public void Onfailed(String errMsg) {
                lv_morelist.setOnComplete();
                dismissProgressBar();
                ToastUtil.showToast(errMsg);
            }
        });
    }
}
