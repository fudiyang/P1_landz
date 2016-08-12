package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.SeeGuwenListBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.SeeGuwenlistResultBean;
import landz.fdy.com.p1_landz.freamwork.image.ImageLoader;

/**
 * Created by fudiyang on 2016/8/4.
 * Author fudiyang
 * Description :
 */
public class GuwenlistAdapter extends BaseAdapter {

    private Context context;

    private List<SeeGuwenListBean> brokerSeeVos;

    private ImageLoader imageLoader;

    public GuwenlistAdapter(Context context,List<SeeGuwenListBean> brokerSeeVos) {
        this.context = context;
        this.brokerSeeVos=brokerSeeVos;
        imageLoader=new ImageLoader();
    }

    public void setBrokerSeeVos(List<SeeGuwenListBean> brokerSeeVos) {
        this.brokerSeeVos = brokerSeeVos;
    }

    @Override
    public int getCount() {
        return brokerSeeVos==null?0:brokerSeeVos.size();
    }

    @Override
    public Object getItem(int position) {
        return brokerSeeVos==null?null:brokerSeeVos.get(position);
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
            convertView=View.inflate(context, R.layout.item_guwenlist,null);
            viewHolder.img_guwenlist_photo= (ImageView) convertView.findViewById(R.id.img_guwenlist_photo);
            viewHolder.im_guwenlist_phone= (ImageView) convertView.findViewById(R.id.im_guwenlist_phone);
            viewHolder.im_guwenlist_sms= (ImageView) convertView.findViewById(R.id.im_guwenlist_sms);
            viewHolder.tv_guwenlist_name= (TextView) convertView.findViewById(R.id.tv_guwenlist_name);
            viewHolder.tv_guwenlist_congye= (TextView) convertView.findViewById(R.id.tv_guwenlist_congye);
            viewHolder.tv_guwenlist_kanfangcishu= (TextView) convertView.findViewById(R.id.tv_guwenlist_kanfangcishu);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        if(brokerSeeVos!=null){
            viewHolder.tv_guwenlist_name.setText(brokerSeeVos.get(position).brokerName);
            viewHolder.tv_guwenlist_congye.setText("从业"+brokerSeeVos.get(position).inductionDate);
            String kanfangnum="60天内带看本房<font color='#FF0000'>"+brokerSeeVos.get(position).houseSeetotal+"</font>次";
            viewHolder.tv_guwenlist_kanfangcishu.setText(Html.fromHtml(kanfangnum));
            if(brokerSeeVos.get(position).photo!=null){

                imageLoader.displayImg(brokerSeeVos.get(position).photo,viewHolder.img_guwenlist_photo);
            }
        }
        return convertView;
    }

    private class ViewHolder{
        TextView tv_guwenlist_name,tv_guwenlist_congye,tv_guwenlist_kanfangcishu;
        ImageView img_guwenlist_photo, im_guwenlist_sms, im_guwenlist_phone;

    }
}
