package landz.fdy.com.p1_landz.landz.UI.welcome.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.HouseDetailResultBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseFragment;
import landz.fdy.com.p1_landz.freamwork.image.ImageLoader2;
import landz.fdy.com.p1_landz.freamwork.utils.LogUtils;
import landz.fdy.com.p1_landz.freamwork.utils.ToastUtil;
import landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse.HouseOneDetailActivity;


public class DetailFragment_7 extends BaseFragment {

    private ImageView img_other_house;

    private TextView tv_other_house;

    private String other_house;

    private showPopPic showpopPic;

    public void setOther_house(String other_house) {
        this.other_house = other_house;
        ImageLoader2.getInstance().displayImg(other_house,img_other_house);
    }
    public void setDesc(String desc){
        tv_other_house.setText(desc);
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_detail_fragment_7;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        img_other_house=findViewByIdNoCast(R.id.img_other_house);
        tv_other_house=findViewByIdNoCast(R.id.tv_other_house);


    }

    @Override
    protected void initData() {
     setOnClick(R.id.img_other_house);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.img_other_house:
               if(showpopPic!=null){
                   LogUtils.e("this.other_house:   " + this.other_house);
                 showpopPic.showPop(this.other_house);

                   break;
               }
        }

    }

    @Override
    public void onAttach(Context context) {
        if(context!=null){
             if(context instanceof HouseOneDetailActivity){
                   showpopPic= (showPopPic) context;
             }
        }
        super.onAttach(context);
    }

    public interface showPopPic{
        void showPop(String url);
    }
}
