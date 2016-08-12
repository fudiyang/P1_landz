package landz.fdy.com.p1_landz.landz.UI.welcome.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.HouseDetailResultBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseFragment;
import landz.fdy.com.p1_landz.freamwork.image.ImageLoader;
import landz.fdy.com.p1_landz.freamwork.utils.IntentUtils;
import landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse.LookPhotoActivity;


public class DetailFragment_2 extends BaseFragment {
    private TextView tv_house_desc;

    private int lineCount;//行数

    private ImageView img_down,img_titlePic;
    private HouseDetailResultBean resultBean;
    private ImageLoader imageLoader;
    private RotateAnimation up_animation;
    private RotateAnimation down_animation;

    public void setResultBean(HouseDetailResultBean resultBean,ImageLoader imageLoader) {
        this.resultBean = resultBean;
        this.imageLoader=imageLoader;
        initData();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_detail_fragment_2;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        tv_house_desc = findViewByIdNoCast(R.id.tv_house_desc);
        img_down = findViewByIdNoCast(R.id.img_down);
        img_titlePic = findViewByIdNoCast(R.id.img_titlePic);
        down_animation=new RotateAnimation(0,-180, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        down_animation.setDuration(100);
        down_animation.setFillAfter(true);
        up_animation=new RotateAnimation(-180,0,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        up_animation.setDuration(100);
        up_animation.setFillAfter(true);
        setOnClick(R.id.img_down);
    }

    @Override
    protected void initData() {
        setOnClick(R.id.img_titlePic);
           if(resultBean!=null){
                imageLoader.displayImg(resultBean.result.titlepicImg,img_titlePic);
               tv_house_desc.setText(""+resultBean.result.roomDescripe);
               tv_house_desc.postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       lineCount=tv_house_desc.getLineCount();
                       tv_house_desc.setLines(2);
                   }
               },100);
           }

    }

    private  boolean isUp;
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_down:
                 if(isUp){//从展开点击折叠
                     isUp=false;
                     tv_house_desc.setLines(2);
                     img_down.startAnimation(up_animation);
                 }else {//从折叠到展开
                     isUp=true;
                     img_down.startAnimation(down_animation);
                     if(lineCount>=2){
                     tv_house_desc.setLines(lineCount);
                     }else {
                         tv_house_desc.setLines(2);
                     }
                 }
                break;
            case R.id.img_titlePic:
                IntentUtils.openActivity(getContext(), LookPhotoActivity.class);
                break;
        }
    }
}
