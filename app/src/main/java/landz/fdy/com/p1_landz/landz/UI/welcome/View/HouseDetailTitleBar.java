package landz.fdy.com.p1_landz.landz.UI.welcome.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import landz.fdy.com.p1_landz.R;

/**
 * Created by fudiyang on 2016/7/26.
 * Author fudiyang
 * Description :
 */
public class HouseDetailTitleBar extends LinearLayout {

    private TextView tv_title, tv_decription;

    public HouseDetailTitleBar(Context context) {
        this(context,null);
    }

    public HouseDetailTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public HouseDetailTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        LayoutParams layoutParams=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        View view=View.inflate(context, R.layout.title_house_detail,null);
        view.setLayoutParams(layoutParams);
        addView(view);
        tv_title= (TextView) findViewById(R.id.tv_title);
        tv_decription= (TextView) findViewById(R.id.tv_decription);
    }
    public  void setTitle(String title,String desc){
        tv_title.setText(title);
        tv_decription.setText(desc);
    }

}
