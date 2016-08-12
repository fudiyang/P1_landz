package landz.fdy.com.p1_landz.landz.UI.welcome.View;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.image.ImageLoader2;

/**
 * Created by fudiyang on 2016/8/1.
 * Author fudiyang
 * Description :
 */
public class OtherHousePopWindow extends PopupWindow{

    public OtherHousePopWindow(Context context,String url) {
        super(context);
        init(context,url);
    }
    public void init(Context context,String url){
        View view=View.inflate(context, R.layout.pop_other_house,null);
        View view_pop=view.findViewById(R.id.view_pop);
        ImageView img_pop_other_house= (ImageView) view.findViewById(R.id.img_pop_other_house);
        ImageLoader2.getInstance().displayImg(url,img_pop_other_house);
        this.setContentView(view);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setFocusable(true);
        this.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        this.setBackgroundDrawable(new BitmapDrawable());
        this.setAnimationStyle(R.style.PopupAnimation);
        view_pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  OtherHousePopWindow.this.dismiss();
            }
        });

    }

    public void showPopwindow(View view){
            if(!isShowing()){
                this.showAsDropDown(view);
            }
    }
}
