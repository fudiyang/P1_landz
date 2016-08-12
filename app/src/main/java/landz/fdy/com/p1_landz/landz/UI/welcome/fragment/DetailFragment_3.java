package landz.fdy.com.p1_landz.landz.UI.welcome.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.GuWenResultBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseFragment;
import landz.fdy.com.p1_landz.freamwork.utils.ListViewUtils;
import landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse.GuWenAdapter;


public class DetailFragment_3 extends BaseFragment {
    private TextView tv_guwen;

    private ImageView  im_green_sms, im_green_phone;

    private ListView lv_guwen;

    private GuWenResultBean.GuWenBean result;




    public void setResult(GuWenResultBean.GuWenBean result) {
        this.result = result;
        initData();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_detail_fragment_3;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {

        im_green_phone= findViewByIdNoCast(R.id.im_green_phone);
        im_green_sms= findViewByIdNoCast(R.id.im_green_sms);
        tv_guwen= findViewByIdNoCast(R.id.tv_guwen);
        lv_guwen=findViewByIdNoCast(R.id.lv_guwen);

    }

    @Override
    protected void initData() {
        if(result!=null){
          String guwen=String.format(getString(R.string.guwen),""+result.totalAmount);
                tv_guwen.setText(guwen);
            GuWenAdapter guWenAdapter=new GuWenAdapter(getContext(),result.showArr);
            lv_guwen.setAdapter(guWenAdapter);
            ListViewUtils.measureListViewHeight(lv_guwen);

        }

    }

    @Override
    public void onClick(View view) {

    }
}
