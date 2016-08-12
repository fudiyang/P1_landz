package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ImgUrlArrBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ImgUrlArrSeebuildBean;
import landz.fdy.com.p1_landz.freamwork.image.ImageLoader;
import landz.fdy.com.p1_landz.freamwork.utils.IntentUtils;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild_fragment.SeeBuildLookPhotoActivity;

/**
 * Created by fudiyang on 2016/8/3.
 * Author fudiyang
 * Description :
 */
public class ImagePageAdapter2 extends PagerAdapter {

    private Context context;

    private List<ImgUrlArrSeebuildBean> imgUrlArrSeebuildBeen;

    private List<ImageView> imageViews;

    private ImageLoader imageLoader;

    private boolean clickDismiss;

    private boolean isFirst;

    public ImagePageAdapter2(Context context, List<ImgUrlArrSeebuildBean> imgUrlArrSeebuild,boolean isFirst) {
        this.context = context;
        this.isFirst =isFirst;
        this.imgUrlArrSeebuildBeen = imgUrlArrSeebuild;
        imageLoader=new ImageLoader();
        imageViews=new ArrayList<>();
        if(imgUrlArrSeebuild!=null&&!imgUrlArrSeebuild.isEmpty()){
            for(ImgUrlArrSeebuildBean imgUrlArrSeebuildBean :imgUrlArrSeebuild){
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
        return imageViews==null?0:imageViews.size()*50;
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
        imageLoader.displayImg(imgUrlArrSeebuildBeen.get(position%imageViews.size()).picName,imageView);
        if(imageView.getParent()==null){
            container.addView(imageView);
        }

        if(isFirst){
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    IntentUtils.openActivity(context,SeeBuildLookPhotoActivity.class);

                }
            });
        }
            return imageView;
    }
}
