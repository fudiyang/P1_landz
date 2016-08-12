package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.MoreTuijianBean;
import landz.fdy.com.p1_landz.freamwork.image.ImageLoader;
import landz.fdy.com.p1_landz.freamwork.utils.Constants;

/**
 * Created by fudiyang on 2016/8/5.
 * Author fudiyang
 * Description :
 */
public class MoretuijianAdapter extends BaseAdapter {

    private Context context;

    private List<MoreTuijianBean> moreTuijianBeen;

    private ImageLoader imageLoader;

    public MoretuijianAdapter(Context context, List<MoreTuijianBean> moreTuijianBeen) {
        this.context = context;
        this.moreTuijianBeen = moreTuijianBeen;
        imageLoader=new ImageLoader();
    }

    @Override
    public int getCount() {
        return moreTuijianBeen==null?0:moreTuijianBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return moreTuijianBeen==null?null:moreTuijianBeen.get(position);
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
            convertView=View.inflate(context, R.layout.item_seebuild_moretuijian,null);
            viewHolder.img_moretuijain= (ImageView) convertView.findViewById(R.id.img_moretuijain);
            viewHolder.tv_more_name= (TextView) convertView.findViewById(R.id.tv_more_name);
            viewHolder.tv_more_type= (TextView) convertView.findViewById(R.id.tv_more_type);
            viewHolder.tv_more_desc= (TextView) convertView.findViewById(R.id.tv_more_desc);
            viewHolder.tv_more_money= (TextView) convertView.findViewById(R.id.tv_more_money);
           convertView.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_more_money.setText(
                moreTuijianBeen.get(position).totalprBegin
                        + "-"
                        + moreTuijianBeen.get(position).totalprEnd + "万");
        viewHolder.tv_more_type.setText(moreTuijianBeen.get(position).resblockType);
        viewHolder.tv_more_name.setText(moreTuijianBeen.get(position).resblockOneName);
        viewHolder.tv_more_desc.setText(moreTuijianBeen.get(position).apartmentBegin + "-"
                + moreTuijianBeen.get(position).apartmentEnd + "居" + "  "
                 + moreTuijianBeen.get(position).unitprBegin + "-"
                + moreTuijianBeen.get(position).unitprEnd + "万/㎡"+" "
                +moreTuijianBeen.get(position).areaBegin+"-"+moreTuijianBeen.get(position).areaEnd+"㎡");
        viewHolder.img_moretuijain.setImageResource(R.mipmap.defult_onepic);
        imageLoader.displayImg(moreTuijianBeen.get(position).imgUrl ,viewHolder.img_moretuijain);
        return convertView;
    }

    private class ViewHolder {
        ImageView img_moretuijain;//大图
        TextView tv_more_name;// 昆泰家润中心
        TextView tv_more_type;//  公寓
        TextView tv_more_desc;//  两室两厅
        TextView tv_more_money;//  价格
    }
}
