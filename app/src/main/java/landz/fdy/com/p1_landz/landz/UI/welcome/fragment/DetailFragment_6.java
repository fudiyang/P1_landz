package landz.fdy.com.p1_landz.landz.UI.welcome.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.OneHouseMoreResultBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseFragment;
import landz.fdy.com.p1_landz.freamwork.http.HttpHelper;
import landz.fdy.com.p1_landz.freamwork.http.HttpRequestAsynctask;
import landz.fdy.com.p1_landz.freamwork.utils.ListViewUtils;
import landz.fdy.com.p1_landz.freamwork.utils.LogUtils;
import landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse.OnHouseMoreAdapter;


public class DetailFragment_6 extends BaseFragment {

    private TextView tv_house_more;

    private ListView lv_house_more;

   private OnHouseMoreAdapter adapter;

    private String houseId, resblockId;//房源id，楼盘id


    public void setOneHouseDetailId(String houseId,String resblockId) {
        this.houseId = houseId;
        this.resblockId=resblockId;
        getData();
    }


    @Override
    protected int getResource() {
        return R.layout.fragment_detail_fragment_6;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        tv_house_more = findViewByIdNoCast(R.id.tv_house_more);
        lv_house_more = findViewByIdNoCast(R.id.lv_house_more);
    }

    @Override
    protected void initData() {

    }
    /**
     * 获取一手房更多推荐
     */
    private void getData(){
        HttpHelper.getOneHouseDetailMore(getActivity(), houseId, resblockId, new HttpRequestAsynctask.Callback() {
            @Override
            public void OnSuccess(String result) {
                LogUtils.e("msg","result_more"+result);
                OneHouseMoreResultBean resultBean=new Gson().fromJson(result,OneHouseMoreResultBean.class);
                    if(resultBean!=null){
                        if (resultBean.result!=null&&!resultBean.result.isEmpty()){
                              tv_house_more.setText(String.format(getString(R.string.houser_more),resultBean.result.get(0).totalNumber));
                        }
                        adapter=new OnHouseMoreAdapter(getContext());
                        adapter.setTotalList(resultBean.result);
                        lv_house_more.setAdapter(adapter);
                        ListViewUtils.measureListViewHeight(lv_house_more);
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
}
