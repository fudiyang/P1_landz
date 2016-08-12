package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild_fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.SeeGuWenResultBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseFragment;
import landz.fdy.com.p1_landz.freamwork.http.HttpHelper;
import landz.fdy.com.p1_landz.freamwork.utils.IntentUtils;
import landz.fdy.com.p1_landz.freamwork.utils.ListViewUtils;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild.SeeBuildGuwenActivity;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild.SeeBuildGuwenAdapter;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild.SeebuildGalleryAdapter;


public class SeeBuild_Fragment_4 extends BaseFragment {
    private String prodelId;
    private TextView tv_seebuild_guwen;
    private ListView lv_seebuild_guwen;
    private SeeGuWenResultBean result;

    public void setResult(SeeGuWenResultBean result) {
        this.result = result;
        initData();

    }

    public void setProdelId(String prodelId) {
        this.prodelId = prodelId;
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_see_build__fragment_4;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        tv_seebuild_guwen= findViewByIdNoCast(R.id.tv_seebuild_guwen);
        lv_seebuild_guwen=findViewByIdNoCast(R.id.lv_seebuild_guwen);
    }

    @Override
    protected void initData() {
        setOnClick(R.id.tv_seebuild_guwen);
        if(result!=null){
            String guwen=String.format(getString(R.string.guwen),""+result.totalBroker);
            tv_seebuild_guwen.setText(guwen);
            SeeBuildGuwenAdapter seeBuildGuwenAdapter=new SeeBuildGuwenAdapter(getContext(),result.brokerSeeVos);
            lv_seebuild_guwen.setAdapter(seeBuildGuwenAdapter);
            ListViewUtils.measureListViewHeight(lv_seebuild_guwen);
        }

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_seebuild_guwen:
                Bundle bundle=new Bundle();
                bundle.putString("resblockOneId",prodelId);
                IntentUtils.openActivity(getActivity(), SeeBuildGuwenActivity.class,bundle);
                break;
        }

    }
}
