package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild_fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ImgUrlArrBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ImgUrlArrSeebuildBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseFragment;
import landz.fdy.com.p1_landz.freamwork.utils.IntentUtils;
import landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse.ImagePagerAdapter;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild.ImagePageAdapter2;


public class SeeBuild_Fragment_1 extends BaseFragment implements Handler.Callback{
    private static final int MSG_DELAY = 3000;//延迟发送

    private ViewPager seebuild_viewPager;

    private Handler handler;

    public List<ImgUrlArrSeebuildBean> imgUrlArrSeebuild;//展示图集合

    private ImagePageAdapter2 imagePageAdapter2;

    private int currentItem;

    private boolean canAutoScroll;//是否可以自动滚动

    private boolean canAuto;

    public ViewPager getSeebuild_viewPager() {
        return seebuild_viewPager;
    }

    public void setSeebuild_viewPager(ViewPager seebuild_viewPager) {
        this.seebuild_viewPager = seebuild_viewPager;
    }

    public void setImgUrlArrSeebuild(List<ImgUrlArrSeebuildBean> imgUrlArrSeebuild) {
        this.imgUrlArrSeebuild = imgUrlArrSeebuild;
        canAuto=true;
        imagePageAdapter2=new ImagePageAdapter2(getContext(),imgUrlArrSeebuild,true);
        seebuild_viewPager.setAdapter(imagePageAdapter2);
        handler.sendEmptyMessageDelayed(1,MSG_DELAY);
    }
    public void setImgUrlArrSeebuild(List<ImgUrlArrSeebuildBean> imgUrlArrSeebuild, boolean canAuto ,boolean Candismiss) {
           this.imgUrlArrSeebuild=imgUrlArrSeebuild;
           this.canAuto=canAuto;
        imagePageAdapter2=new ImagePageAdapter2(getContext(),imgUrlArrSeebuild,false);
        imagePageAdapter2.setClickDismiss(Candismiss);
        seebuild_viewPager.setAdapter(imagePageAdapter2);
        if(canAuto){
            handler.sendEmptyMessageDelayed(1,MSG_DELAY);
        }
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_see_build__fragment_1;
    }

    @Override
    protected void beforeInitView() {
              handler=new Handler(this);
    }

    @Override
    protected void initView(View rootView) {
        seebuild_viewPager=findViewByIdNoCast(R.id.seebuild_viewPager);
    }

    @Override
    protected void initData() {

        seebuild_viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                    if(!canAuto){
                        return;
                    }
                if(state==seebuild_viewPager.SCROLL_STATE_IDLE){
                    if(canAutoScroll){
                        canAutoScroll=false;
                        handler.sendEmptyMessageDelayed(1,MSG_DELAY);
                    }

                }
                if(state==seebuild_viewPager.SCROLL_STATE_DRAGGING){
                    canAutoScroll=true;
                    handler.sendEmptyMessage(2);
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.seebuild_viewPager:
               IntentUtils.openActivity(getContext(),SeeBuildLookPhotoActivity.class);
                break;
        }

    }

    @Override
    public void onPause() {
        if(handler!=null){
            handler.removeCallbacksAndMessages(null);
        }
        super.onPause();
    }
    private boolean FirstResume=true;

    @Override
    public void onResume() {
        if(FirstResume){
            FirstResume=!FirstResume;
        }else {
            if(canAuto){
                if(handler!=null){
                    handler.sendEmptyMessageDelayed(1,MSG_DELAY);
                }
            }
        }
        super.onResume();
    }

    @Override
    public boolean handleMessage(Message message) {
        switch (message.what){
            case 1:
                currentItem++;
                seebuild_viewPager.setCurrentItem(currentItem);
                handler.sendEmptyMessageDelayed(1,MSG_DELAY);
                break;
            case  2:
                handler.removeMessages(1);
                break;
        }
        return false;
    }
}
