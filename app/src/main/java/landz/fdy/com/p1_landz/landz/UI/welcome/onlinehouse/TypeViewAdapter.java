package landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ImgUrlArrBean;

/**
 * Created by fudiyang on 2016/7/29.
 * Author fudiyang
 * Description :
 */
public class TypeViewAdapter extends PagerAdapter {

     private Context context;

    private List<ImgUrlArrBean> imgUrlArrBeen;

    private List<TextView> textViews;

    public TypeViewAdapter(Context context, List<ImgUrlArrBean> imgUrlArr) {
        this.context = context;
        this.imgUrlArrBeen = imgUrlArrBeen;
        textViews=new ArrayList<>();
        if(imgUrlArrBeen!=null&&!imgUrlArrBeen.isEmpty()){
            for(ImgUrlArrBean imgUrlArrBean : imgUrlArr){
               TextView textView= new TextView(context);
                textView.setTextSize(14);
                textView.setTextColor(Color.WHITE);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.gravity = Gravity.CENTER;
                textView.setLayoutParams(layoutParams);
                textViews.add(textView);
            }
            textViews.get(0).setTextSize(20);
        }
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
