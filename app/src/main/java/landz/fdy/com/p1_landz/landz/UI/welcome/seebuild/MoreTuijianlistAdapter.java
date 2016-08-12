package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.MoreListBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.MoreTuijianBean;
import landz.fdy.com.p1_landz.freamwork.image.ImageLoader;

/**
 * Created by fudiyang on 2016/8/5.
 * Author fudiyang
 * Description :
 */
public class MoreTuijianlistAdapter extends BaseAdapter {

    private Context context;

    private List<MoreListBean> moreTuijian;

    private ImageLoader imageLoader;

    public MoreTuijianlistAdapter(Context context,List<MoreListBean> moreTuijian) {
        this.context = context;
        this.moreTuijian=moreTuijian;
        imageLoader=new ImageLoader();
    }

    public void setMoreTuijian(List<MoreListBean> moreTuijian) {
        this.moreTuijian = moreTuijian;
    }

    @Override
    public int getCount() {
        return moreTuijian==null?0:moreTuijian.size();
    }

    @Override
    public Object getItem(int position) {
        return moreTuijian==null?null:moreTuijian.get(position);
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
            convertView=View.inflate(context, R.layout.item_moretuijianlist,null);
            viewHolder.img_morelist_photo= (ImageView) convertView.findViewById(R.id.img_morelist_photo);
            viewHolder.tv_morelist_name= (TextView) convertView.findViewById(R.id.tv_morelist_name);
            viewHolder.tv_morelist_type= (TextView) convertView.findViewById(R.id.tv_morelist_type);
            viewHolder.tv_morelist_desc= (TextView) convertView.findViewById(R.id.tv_morelist_desc);
            viewHolder.tv_morelist_money= (TextView) convertView.findViewById(R.id.tv_morelist_money);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_morelist_money.setText(
                moreTuijian.get(position).totalprBegin
                        + "-"
                        + moreTuijian.get(position).totalprEnd + "万");
        viewHolder.tv_morelist_type.setText(moreTuijian.get(position).resblockType);
        viewHolder.tv_morelist_name.setText(moreTuijian.get(position).resblockOneName);
        viewHolder.tv_morelist_desc.setText(moreTuijian.get(position).apartmentBegin + "-"
                + moreTuijian.get(position).apartmentEnd + "居" + "  "
                + moreTuijian.get(position).unitprBegin + "-"
                + moreTuijian.get(position).unitprEnd + "万/㎡"+" "
                +moreTuijian.get(position).areaBegin+"-"+moreTuijian.get(position).areaEnd+"㎡");
        viewHolder.img_morelist_photo.setImageResource(R.mipmap.defult_onepic);
        imageLoader.displayImg(moreTuijian.get(position).imgUrl ,viewHolder.img_morelist_photo);
        return convertView;
    }
    private class ViewHolder {
        ImageView img_morelist_photo;//大图
        TextView tv_morelist_name;// 昆泰家润中心
        TextView tv_morelist_type;//  公寓
        TextView tv_morelist_desc;//  两室两厅
        TextView tv_morelist_money;//  价格
    }
}
