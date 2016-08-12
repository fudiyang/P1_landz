package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild;

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
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.BrokerSeeVosBean;
import landz.fdy.com.p1_landz.freamwork.image.ImageLoader;

/**
 * Created by fudiyang on 2016/8/3.
 * Author fudiyang
 * Description :
 */
public class SeeBuildGuwenAdapter extends BaseAdapter {

    private Context context;

    private List<BrokerSeeVosBean> brokerSeeVos;

    private ImageLoader imageLoader;

    public SeeBuildGuwenAdapter(Context context, List<BrokerSeeVosBean> brokerSeeVos) {
        this.context = context;
        this.brokerSeeVos = new ArrayList<>();
        if(brokerSeeVos!=null&&!brokerSeeVos.isEmpty()){
            for(int i=1;i<brokerSeeVos.size();i++){
                this.brokerSeeVos.add(brokerSeeVos.get(i));
            }
        }
        imageLoader=new ImageLoader();
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
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView=View.inflate(context, R.layout.item_seebuild_guwen,null);
            viewHolder.img_seebuild_photo= (ImageView) convertView.findViewById(R.id.img_seebuild_photo);
            viewHolder.im_seegreen_phone= (ImageView) convertView.findViewById(R.id.im_seegreen_phone);
            viewHolder.im_seegreen_sms= (ImageView) convertView.findViewById(R.id.im_seegreen_sms);
            viewHolder.tv_seeguwen_name= (TextView) convertView.findViewById(R.id.tv_seeguwen_name);
            viewHolder.tv_seeguwen_congye= (TextView) convertView.findViewById(R.id.tv_seeguwen_congye);
            viewHolder.tv_seeguwen_kanfangcishu= (TextView) convertView.findViewById(R.id.tv_seeguwen_kanfangcishu);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        if(brokerSeeVos!=null){
            viewHolder.tv_seeguwen_name.setText(brokerSeeVos.get(position).brokerName);
            viewHolder.tv_seeguwen_congye.setText("从业"+brokerSeeVos.get(position).inductionDate);
            String kanfangnum="60天内带看本房<font color='#FF0000'>"+brokerSeeVos.get(position).houseSeetotal+"</font>次";
            viewHolder.tv_seeguwen_kanfangcishu.setText(Html.fromHtml(kanfangnum));

            imageLoader.displayImg(brokerSeeVos.get(position).photo,viewHolder.img_seebuild_photo);
        }
        return convertView;
    }

    private class ViewHolder{
        TextView tv_seeguwen_name,tv_seeguwen_congye,tv_seeguwen_kanfangcishu;
        ImageView img_seebuild_photo, im_seegreen_sms, im_seegreen_phone;

    }
}
