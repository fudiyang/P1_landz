package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild_fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.MoreTuijianBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ResblockOneArrBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseFragment;
import landz.fdy.com.p1_landz.freamwork.utils.IntentUtils;
import landz.fdy.com.p1_landz.freamwork.utils.ListViewUtils;
import landz.fdy.com.p1_landz.freamwork.utils.ToastUtil;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild.MoreTuijianActivity;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild.MoretuijianAdapter;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild.SeeBuildMoreDetailActivity;


public class SeeBuild_Fragment_7 extends BaseFragment {

    private String resblockOneName;

    private String prodelId;

    private TextView tv_house_seemore;

    private ListView lv_house_seemore;

    private MoretuijianAdapter moretuijianAdapter;

    private List<MoreTuijianBean> moreTuijianBeen;

    public void setMoreTuijianBeen(List<MoreTuijianBean> moreTuijianBeen) {
        this.moreTuijianBeen = moreTuijianBeen;
        initData();
    }

    public void setResblockOneName(String resblockOneName) {
        this.resblockOneName = resblockOneName;
    }

    public void setProdelId(String prodelId) {
        this.prodelId = prodelId;
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_see_build__fragment_7;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        tv_house_seemore = findViewByIdNoCast(R.id.tv_house_seemore);
        lv_house_seemore = findViewByIdNoCast(R.id.lv_house_seemore);
    }

    @Override
    protected void initData() {
        setOnClick(R.id.tv_house_seemore);
              if(moreTuijianBeen!=null){
               tv_house_seemore.setText(String.format(getString(R.string.more_tuijian),moreTuijianBeen.get(0).totalNumber));
                  moretuijianAdapter=new MoretuijianAdapter(getContext(),moreTuijianBeen);
                  lv_house_seemore.setAdapter(moretuijianAdapter);
                  ListViewUtils.measureListViewHeight(lv_house_seemore);
              }
        lv_house_seemore.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Bundle bundle=new Bundle();
                MoreTuijianBean bean= (MoreTuijianBean) moretuijianAdapter.getItem(position);
                bundle.putString("resblockOneId",bean.prodelId);
                bundle.putString("resblockOneName",bean.resblockOneName);
                IntentUtils.openActivity(getActivity(),SeeBuildMoreDetailActivity.class,bundle);
            }
        });
    }

    @Override
    public void onClick(View view) {
             switch (view.getId()){
                 case R.id.tv_house_seemore:
                     Bundle bundle=new Bundle();
                     bundle.putString("resblockOneId",prodelId);
                     bundle.putString("resblockOneName",resblockOneName);
                     IntentUtils.openActivity(getActivity(), MoreTuijianActivity.class,bundle);
                     break;
             }
    }
}
