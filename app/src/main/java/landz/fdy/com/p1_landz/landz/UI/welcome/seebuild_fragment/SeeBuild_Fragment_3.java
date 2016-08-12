package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild_fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.SeeDetailResultBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseFragment;


public class SeeBuild_Fragment_3 extends BaseFragment {

    private TextView tv_seebuild_desc;

    private SeeDetailResultBean result;

    public void setResult(SeeDetailResultBean result) {
        this.result = result;
        initData();

    }

    @Override
    protected int getResource() {
        return R.layout.fragment_see_build__fragment_3;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        tv_seebuild_desc=findViewByIdNoCast(R.id.tv_seebuild_desc);
    }

    @Override
    protected void initData() {
        if(result!=null){
            tv_seebuild_desc.setText(result.formType+"");
        }


    }

    @Override
    public void onClick(View view) {

    }
}
