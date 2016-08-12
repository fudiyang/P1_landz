package landz.fdy.com.p1_landz.landz.UI.welcome;

import android.animation.ObjectAnimator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseActivity;
import landz.fdy.com.p1_landz.freamwork.utils.DisplayUtil;
import landz.fdy.com.p1_landz.landz.UI.welcome.adpter.GuideAdapter;

public class GuideActivity extends BaseActivity {

    private ViewPager viewPager;
    private GuideAdapter adapter;
    private ImageView cicle_01, cicle_02, cicle_03,splash_img;
    private ImageView[] circles;
    private Integer[] imgs = new Integer[]{R.mipmap.splash_a, R.mipmap.splash_b, R.mipmap.splash_c};
    private LinearLayout ll_circle;
    @Override
    public int getContentViewId() {
        return R.layout.activity_guide;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void InitView() {
        viewPager=findViewByIdNoCast(R.id.viewPager);
        ll_circle=findViewByIdNoCast(R.id.ll_circle);
        splash_img = findViewByIdNoCast(R.id.splash_img);
        cicle_01 = findViewByIdNoCast(R.id.cicle_01);
        cicle_02 = findViewByIdNoCast(R.id.cicle_02);
        cicle_03 = findViewByIdNoCast(R.id.cicle_03);
    }

    @Override
    public void InitData() {
       circles=new ImageView[]{cicle_01, cicle_02, cicle_03};
        RelativeLayout.LayoutParams params= (RelativeLayout.LayoutParams) ll_circle.getLayoutParams();
        params.width=DisplayUtil.getDensity_Width(this);
        ll_circle.setLayoutParams(params);
        adapter=new GuideAdapter(getSupportFragmentManager());
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setCheck(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapter);
        setCheck(0);

    }
    public  void  setCheck(int position){
        splash_img.setImageResource(imgs[position]);
        for(int i=0;i<circles.length;i++){
                 if(position==i){
                     circles[i].setImageResource(R.mipmap.checked_page);
                 }else {
                     circles[i].setImageResource(R.mipmap.unchecked_page);
                 }
        }
        splash_bg_anim();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cicle_01:
                splash_img.setImageResource(imgs[0]);
                break;
            case R.id.cicle_02:
                splash_img.setImageResource(imgs[1]);
                break;
            case R.id.cicle_03:
                splash_img.setImageResource(imgs[2]);
                break;
        }

    }
    public void splash_bg_anim(){
        ObjectAnimator animator=ObjectAnimator.ofFloat(splash_img,"translationX",0, DisplayUtil.getDensity_Width(this)-getResources().getDimension(R.dimen.splash_a),0);
        animator.setDuration(10000);
        animator.setRepeatCount(Integer.MAX_VALUE);
        animator.setRepeatMode(ObjectAnimator.INFINITE);
        animator.start();

    }


}
