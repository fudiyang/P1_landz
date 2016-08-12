package landz.fdy.com.p1_landz.landz.UI.welcome.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseFragment;
import landz.fdy.com.p1_landz.freamwork.share.ShareprenceHelper;
import landz.fdy.com.p1_landz.freamwork.utils.DisplayUtil;
import landz.fdy.com.p1_landz.freamwork.utils.IntentUtils;
import landz.fdy.com.p1_landz.landz.MainActivity;

public class GuideFragment extends BaseFragment {
    private int postion;

    private LinearLayout ll_description;

    private TextView tv_title, tv_content;

    private Button btn_tiyan;

    public GuideFragment() {

    }
    public static GuideFragment newInstance(int postion){
        GuideFragment fragment=new GuideFragment();
        fragment.postion=postion;
        return fragment;
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_guide;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        ll_description = findViewByIdNoCast(R.id.ll_description);
        tv_title = findViewByIdNoCast(R.id.tv_title);
        tv_content = findViewByIdNoCast(R.id.tv_content);
        btn_tiyan = findViewByIdNoCast(R.id.btn_tiyan);
    }

    @Override
    protected void initData() {
    setOnClick(R.id.btn_tiyan);
        RelativeLayout.LayoutParams params= (RelativeLayout.LayoutParams) ll_description.getLayoutParams();
        params.width= DisplayUtil.getDensity_Width(getContext());
        ll_description.setLayoutParams(params);
        switch (postion){
            case 0:
                tv_title.setText(getString(R.string.splash_tip1));
                tv_content.setText(getString(R.string.splash_tip01));
                break;
            case 1:
                tv_title.setText(getString(R.string.splash_tip2));
                tv_content.setText(getString(R.string.splash_tip02));
                break;
            case 2:
                tv_title.setText(getString(R.string.splash_tip3));
                tv_content.setText(getString(R.string.splash_tip03));
                btn_tiyan.setVisibility(View.VISIBLE);
                btn_tiyan.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                      RelativeLayout.LayoutParams params2= (RelativeLayout.LayoutParams) btn_tiyan.getLayoutParams();
                        params2.leftMargin=(DisplayUtil.getDensity_Width(getContext())-btn_tiyan.getWidth())/2;
                        btn_tiyan.setLayoutParams(params2);
                    }
                },500);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_tiyan:
                IntentUtils.openActivity(getActivity(),MainActivity.class);
                ShareprenceHelper.getInstance(getActivity()).setIsFirst(false);
                IntentUtils.openActivity(getContext(), MainActivity.class);
                getActivity().finish();
                break;
        }

    }
}
