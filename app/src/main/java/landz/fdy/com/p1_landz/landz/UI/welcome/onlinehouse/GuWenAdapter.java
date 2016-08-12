package landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.GuWenResultBean;
import landz.fdy.com.p1_landz.freamwork.image.ImageLoader;

/**
 * Created by fudiyang on 2016/7/27.
 * Author fudiyang
 * Description :
 */
public class GuWenAdapter extends BaseAdapter {

    private Context context;

    private List<GuWenResultBean.ShowArr> showArrs;

    private ImageLoader imageLoader;

    public GuWenAdapter(Context context, List<GuWenResultBean.ShowArr> showArrs) {
        this.context = context;
        this.showArrs = new ArrayList<>();
        if(showArrs!=null&&!showArrs.isEmpty()){
        for (int i=1;i<showArrs.size();i++){
             this.showArrs.add(showArrs.get(i));
        }
        }
        imageLoader=new ImageLoader();
    }

    @Override
    public int getCount() {
        return showArrs==null?0:showArrs.size();
    }

    @Override
    public Object getItem(int position) {
        return showArrs==null?null:showArrs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
              viewHolder=new ViewHolder();
             convertView=View.inflate(context, R.layout.item_guwen,null);
             viewHolder.img_detail_photo= (ImageView) convertView.findViewById(R.id.img_detail_photo);
            viewHolder.im_green_phone= (ImageView) convertView.findViewById(R.id.im_green_phone);
            viewHolder.im_green_sms= (ImageView) convertView.findViewById(R.id.im_green_sms);
            viewHolder.tv_guwen_name= (TextView) convertView.findViewById(R.id.tv_guwen_name);
            viewHolder.tv_guwen_congye= (TextView) convertView.findViewById(R.id.tv_guwen_congye);
            viewHolder.tv_guwen_kanfangcishu= (TextView) convertView.findViewById(R.id.tv_guwen_kanfangcishu);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        if(showArrs!=null){
            viewHolder.tv_guwen_name.setText(showArrs.get(position).createName);
            viewHolder.tv_guwen_congye.setText("从业"+showArrs.get(position).inductionDate);
            String kanfangnum="60天内带看本房<font color='#FF0000'>"+showArrs.get(position).totalShowing+"</font>次";
            viewHolder.tv_guwen_kanfangcishu.setText(Html.fromHtml(kanfangnum));

          imageLoader.displayImg(showArrs.get(position).photo,viewHolder.img_detail_photo);
        }

        return convertView;
    }

    private class ViewHolder{
     TextView tv_guwen_name,tv_guwen_congye,tv_guwen_kanfangcishu;
     ImageView img_detail_photo, im_green_sms, im_green_phone;


    }
}
