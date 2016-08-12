package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.BrokerSeeVosBean;
import landz.fdy.com.p1_landz.freamwork.image.ImageLoader;

/**
 * Created by fudiyang on 2016/8/4.
 * Author fudiyang
 * Description :
 */
public class SeeBuildBottomView extends LinearLayout implements View.OnClickListener{

    private Activity activity;

    private BrokerSeeVosBean brokerSeeVosBean;

    private ImageLoader imageLoader;

    private ImageView im_seedetail_photo, im_seedetail_phone;

    private TextView tv_seehuxing_name, tv_seehuxing_phone;

    public SeeBuildBottomView(Context context) {
        this(context,null);
    }

    public SeeBuildBottomView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SeeBuildBottomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        LayoutParams layoutParams=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        View view=View.inflate(context, R.layout.item_seebuild_bottomview,null);
        view.setLayoutParams(layoutParams);
        addView(view);
        im_seedetail_photo = (ImageView) findViewById(R.id.im_seedetail_photo);
        tv_seehuxing_phone = (TextView) findViewById(R.id.tv_seehuxing_phone);
        tv_seehuxing_name = (TextView) findViewById(R.id.tv_seehuxing_name);
        im_seedetail_phone = (ImageView) findViewById(R.id.im_seedetail_phone);
        im_seedetail_phone.setOnClickListener(this);
    }

    public void setBrokerSeeVosBean(Activity activity,BrokerSeeVosBean brokerSeeVosBean,ImageLoader imageLoader) {
        this.activity=activity;
        this.brokerSeeVosBean = brokerSeeVosBean;
        this.imageLoader=imageLoader;
        initData();
    }

    private void initData(){
        if(brokerSeeVosBean!=null){
            imageLoader.displayImg(brokerSeeVosBean.photo,im_seedetail_photo);
            tv_seehuxing_name.setText(brokerSeeVosBean.brokerName);
            tv_seehuxing_phone.setText(brokerSeeVosBean.phone);
        }

    }

    @Override
    public void onClick(View view) {
        if(view==im_seedetail_phone){
            if(brokerSeeVosBean!=null){
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+brokerSeeVosBean.phone));
                activity.startActivity(intent);
            }
        }

    }
}
