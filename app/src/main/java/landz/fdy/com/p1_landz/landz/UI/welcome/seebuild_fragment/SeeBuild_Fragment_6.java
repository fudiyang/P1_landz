package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild_fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ApartmentImgVosBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseFragment;
import landz.fdy.com.p1_landz.freamwork.utils.LogUtils;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild.HuxingpageAdapter;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild.SeeBuildMoreDetailActivity;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild.ShaixuanAdapter;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild.ShaixuanPopWindow;


public class SeeBuild_Fragment_6 extends BaseFragment implements ShaixuanPopWindow.ShaiXuan{
    private TextView tv_see_zhulihuxing;
    private ImageView img_see_shaixuan;
    private Gallery zhulihuxing_gallery;
    private showImgPop showimgPop;
    private List<ApartmentImgVosBean> result;
    private List<Object> shaixuen;
    private ShaixuanPopWindow shaixuanPopWindow;
    private HuxingpageAdapter huxingpageAdapter;

    public void setResult(List<ApartmentImgVosBean> result) {
        this.result = result;
        initData();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_see_build__fragment_6;
    }

    @Override
    protected void beforeInitView() {
        shaixuen=new ArrayList<>();
        shaixuen.add("请选择");
        shaixuen.add("一居");
        shaixuen.add("二居");
        shaixuen.add("三居");
        shaixuen.add("四居");
        shaixuen.add("五居及以上");

    }

    @Override
    protected void initView(View rootView) {
        tv_see_zhulihuxing= findViewByIdNoCast(R.id.tv_see_zhulihuxing);
        img_see_shaixuan=findViewByIdNoCast(R.id.img_see_shaixuan);
        zhulihuxing_gallery=findViewByIdNoCast(R.id.zhulihuxing_gallery);
    }

    @Override
    protected void initData() {
        setOnClick(R.id.img_see_shaixuan);
        if(result!=null){
            String huxing=String.format(getString(R.string.huxing),""+result.size());
            tv_see_zhulihuxing.setText(huxing);
            huxingpageAdapter=new HuxingpageAdapter(getContext(),result);
            zhulihuxing_gallery.setAdapter(huxingpageAdapter);
            zhulihuxing_gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    if(showimgPop!=null){
                        showimgPop.showpop(result.get(position).imgUrl);
                    }
                }
            });
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_see_shaixuan:
                  shaixuanPopWindow=new ShaixuanPopWindow(getContext(),shaixuen,this);
                  shaixuanPopWindow.showAsDropDown(img_see_shaixuan);

                break;
        }

    }

    @Override
    public void onAttach(Context context) {
        if(context!=null){
            if(context instanceof SeeBuildMoreDetailActivity){
                showimgPop= (showImgPop) context;
            }
        }
        super.onAttach(context);
    }

    @Override
    public void shaixuan(String jushi) {
        LogUtils.e("jushi-----"+jushi);
        if("请选择".equals(jushi)){
            String huxing=String.format(getString(R.string.huxing),""+result.size());
            tv_see_zhulihuxing.setText(huxing);
        }else {
            String huxing=String.format(getString(R.string.huxing),""+result.size());
            tv_see_zhulihuxing.setText(huxing+jushi);
        }



    }

    @Override
    public void weizi(int position) {
        LogUtils.e("ppppppppppp"+position);
        String pos=position+"";
              if(position==0){
                  shaixuanPopWindow.dismiss();
              }
           List<ApartmentImgVosBean> result1=new ArrayList<>();
            for (ApartmentImgVosBean vosBean:result){
               if (vosBean.bedroomAmount.equals(pos))
                   result1.add(vosBean);
            }
        if(result1!=null){
            huxingpageAdapter.setApartmentImgVosBeen(result1);
            huxingpageAdapter.notifyDataSetChanged();
            LogUtils.e("ffffffffffffffffffffffffffffffffffffffffffffff");
        }

    }

    public interface showImgPop{
        void showpop(String url);
    }

}
