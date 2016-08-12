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


public class SeeBuild_Fragment_2 extends BaseFragment {

    private TextView tv_loupanmingzi;
    private TextView tv_huxing;
    private TextView tv_jianzhumianji;
    private TextView tv_dizi;
    private TextView tv_jiage;
    private TextView tv_junjia;
    private TextView tv_kehu;
    private TextView tv_teshe;

    private SeeDetailResultBean result;

    public void setResult(SeeDetailResultBean result) {
        this.result = result;
        initData();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_see_build__fragment_2;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        tv_loupanmingzi=findViewByIdNoCast(R.id.tv_loupanmingzi);
        tv_huxing=findViewByIdNoCast(R.id.tv_huxing);
        tv_jianzhumianji=findViewByIdNoCast(R.id.tv_jianzhumianji);
        tv_dizi=findViewByIdNoCast(R.id.tv_dizi);
        tv_jiage=findViewByIdNoCast(R.id.tv_jiage);
        tv_junjia=findViewByIdNoCast(R.id.tv_junjia);
        tv_kehu=findViewByIdNoCast(R.id.tv_kehu);
        tv_teshe=findViewByIdNoCast(R.id.tv_teshe);
    }

    @Override
    protected void initData() {
        if(result!=null){
            tv_loupanmingzi.setText(result.resblockOneName);
            tv_huxing.setText("户型:"+" "+result.apartmentBegin+"-"+result.apartmentEnd+"居");
            tv_jianzhumianji.setText("建筑面积:"+" "+result.gfa+"平米");
            tv_dizi.setText("地址:"+" "+"["+result.districtName+" "+result.circleTypeName+"]"+result.lage);
            tv_jiage.setText(result.totalprBegin+"-"+result.totalprEnd+"万");
            tv_junjia.setText(result.unitprBegin+"-"+result.unitprEnd+"万/平米");
            tv_kehu.setText("关注客户:"+" "+result.totalShowing);
            tv_teshe.setText("保值增值");
        }

    }

    @Override
    public void onClick(View view) {

    }
}
