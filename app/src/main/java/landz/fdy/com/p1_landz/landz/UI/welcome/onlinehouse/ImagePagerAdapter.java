package landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ImgUrlArrBean;
import landz.fdy.com.p1_landz.freamwork.image.ImageLoader;

/**
 * Created by fudiyang on 2016/7/26.
 * Author fudiyang
 * Description :
 */
public class ImagePagerAdapter extends PagerAdapter {

    private Context context;

    private List<ImgUrlArrBean> imgUrlArr;

    private List<ImageView> imageViews;

    private ImageLoader imageLoader;

    private boolean clickDismiss;

    public ImagePagerAdapter(Context context, List<ImgUrlArrBean> imgUrlArr) {

        this.imgUrlArr = imgUrlArr;
        imageLoader=new ImageLoader();
        imageViews=new ArrayList<>();
        if(imgUrlArr!=null&&!imgUrlArr.isEmpty()){
            for(ImgUrlArrBean imgUrlArrBean:imgUrlArr){
                  ImageView imageView=new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageViews.add(imageView);
            }
        }
    }

    public void setClickDismiss(boolean clickDismiss) {
        this.clickDismiss = clickDismiss;
    }

    @Override
    public int getCount() {
        return imageViews==null?0:imgUrlArr.size()*20;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imageViews.get(position%imageViews.size()));

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView=imageViews.get(position%imageViews.size());
        imageView.setImageResource(R.mipmap.defult_onepic);
        imageLoader.displayImg(imgUrlArr.get(position%imageViews.size()).picName,imageView);
        if (imageView.getParent() == null)//没有被其他view addVIew过,如果被其他addView过再被container addView会报错
            container.addView(imageView);
        return imageView;
    }
}
