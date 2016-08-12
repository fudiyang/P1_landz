package landz.fdy.com.p1_landz.landz.UI.welcome.fragment;

import android.content.Context;
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
import landz.fdy.com.p1_landz.freamwork.base.BaseFragment;
import landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse.ImagePagerAdapter;


public class DetailFragment_1 extends BaseFragment implements Handler.Callback{
    private static final int MSG_DELAY = 3000;//延迟发送

    private ViewPager viewPager;

    private Handler handler;

    public List<ImgUrlArrBean> imgUrlArr;//展示图集合

    private ImagePagerAdapter imagePagerAdapter;

    private int currentItem;

    private boolean canAutoScroll;//是否可以自动滚动

    private boolean canAuto;

    public ViewPager getViewPager() {
        return viewPager;
    }

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    public void setImgUrlArr(List<ImgUrlArrBean> imgUrlArr) {
        this.imgUrlArr = imgUrlArr;
        canAuto=true;
      imagePagerAdapter=new ImagePagerAdapter(getContext(),imgUrlArr);
        viewPager.setAdapter(imagePagerAdapter);
        handler.sendEmptyMessageDelayed(1,MSG_DELAY);
    }
    public void setImgUrlArr(List<ImgUrlArrBean> imgUrlArr, boolean canAuto ,boolean Candismiss) {
        this.imgUrlArr = imgUrlArr;
        this.canAuto=canAuto;
      imagePagerAdapter=new ImagePagerAdapter(getContext(),imgUrlArr);
        imagePagerAdapter.setClickDismiss(Candismiss);
        viewPager.setAdapter(imagePagerAdapter);
        if(canAuto)
        handler.sendEmptyMessageDelayed(1,MSG_DELAY);
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_detail_fragment_1;
    }

    @Override
    protected void beforeInitView() {
       handler=new Handler(this);
    }

    @Override
    protected void initView(View rootView) {
      viewPager=findViewByIdNoCast(R.id.viewPager);
    }

    @Override
    protected void initData() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

                if(state==viewPager.SCROLL_STATE_IDLE){
                    if(canAutoScroll){
                        canAutoScroll=false;
                        handler.sendEmptyMessageDelayed(1,MSG_DELAY);
                    }

                }
                if(state==viewPager.SCROLL_STATE_DRAGGING){

                    canAutoScroll=true;
                    handler.sendEmptyMessage(2);

                }
            }
        });

    }

    @Override
    public void onClick(View view) {

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
                viewPager.setCurrentItem(currentItem);
                handler.sendEmptyMessageDelayed(1,MSG_DELAY);
                break;
            case 2:
                handler.removeMessages(1);
                break;
        }
        return false;
    }
}
