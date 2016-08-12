package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ResblockArrBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ResblockOneArrBean;
import landz.fdy.com.p1_landz.freamwork.image.ImageLoader;

/**
 * Created by fudiyang on 2016/8/2.
 * Author fudiyang
 * Description :
 */
public class SeeBuildAdapter extends BaseAdapter {

    private Context context;

    private List<Object> totalList;
    private int type_01 = 0;//resblockArr;

    private int type_02 = 1;//resblockOneArr;

    private ImageLoader imageLoader;

    public SeeBuildAdapter(Context context) {
        this.context = context;
        imageLoader=new ImageLoader();
    }

    public void setTotalList(List<Object> totalList) {
        this.totalList = totalList;
    }

    @Override
    public int getCount() {
        return totalList==null?0:totalList.size();
    }

    @Override
    public Object getItem(int position) {
        return totalList==null?null:totalList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if(totalList.get(position)instanceof ResblockArrBean){
            return type_01;
        }else
            return type_02;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder1 viewHolder1=null;
        ViewHolder2 viewHolder2=null;
        int type=getItemViewType(position);
        if(convertView==null){
            if(type==type_01){
                viewHolder1=new ViewHolder1();
                convertView=View.inflate(context, R.layout.item_seebulid_list,null);
                viewHolder1.img_main_show1= (ImageView) convertView.findViewById(R.id.img_main_show1);
                viewHolder1.main_show1_name= (TextView) convertView.findViewById(R.id.main_show1_name);
                viewHolder1.tv_aviprice= (TextView) convertView.findViewById(R.id.tv_aviprice);
                viewHolder1.tv_shangquanId= (TextView) convertView.findViewById(R.id.tv_shangquanId);
                convertView.setTag(viewHolder1);
            }else if(type==type_02){
                viewHolder2=new ViewHolder2();
                convertView=View.inflate(context,R.layout.item_seebuild_list2,null);
                viewHolder2.img_main_show2= (ImageView) convertView.findViewById(R.id.img_main_show2);
                viewHolder2.tv_show2_name= (TextView) convertView.findViewById(R.id.tv_show2_name);
                viewHolder2.tv_show2_type= (TextView) convertView.findViewById(R.id.tv_show2_type);
                viewHolder2.tv_show2_money= (TextView) convertView.findViewById(R.id.tv_show2_money);
                viewHolder2.tv_show2_detail= (TextView) convertView.findViewById(R.id.tv_show2_detail);
                convertView.setTag(viewHolder2);
            }
        }else {
            if(type==type_01){
                viewHolder1= (ViewHolder1) convertView.getTag();
            }else if (type==type_02){
                viewHolder2= (ViewHolder2) convertView.getTag();
            }
        }
        if(type==type_01){
            ResblockArrBean oneModel= (ResblockArrBean) totalList.get(position);
            viewHolder1.main_show1_name.setText(oneModel.resblockName);
            viewHolder1.tv_aviprice.setText(oneModel.avergPrice+"万/㎡");
            viewHolder1.tv_shangquanId.setText(oneModel.circleTypeName);
            viewHolder1.img_main_show1.setImageResource(R.mipmap.defult_twopic);
            imageLoader.displayImg(oneModel.imgUrl, viewHolder1.img_main_show1);
        }else if(type==type_02){
            ResblockOneArrBean twoModel= (ResblockOneArrBean) totalList.get(position);
            if (twoModel != null){
                viewHolder2.tv_show2_name.setText(twoModel.resblockOneName);
                viewHolder2.tv_show2_type.setText(twoModel.resblockType);
                viewHolder2.tv_show2_money.setText(twoModel.totalprBegin+"-"+twoModel.totalprEnd+"万");
                viewHolder2.tv_show2_detail.setText(twoModel.apartmentBegin+"-"+twoModel.apartmentEnd+"居"
                        +" "+twoModel.unitprBegin+"-"+twoModel.unitprEnd+"万/㎡"+" "+twoModel.areaBegin+"-"+
                        twoModel.areaEnd+"㎡");
                viewHolder2.img_main_show2.setImageResource(R.mipmap.defult_onepic);
                imageLoader.displayImg(twoModel.imgUrl,viewHolder2.img_main_show2);
            }

        }
        return convertView;
    }

    private class ViewHolder1{
         ImageView img_main_show1;
         TextView main_show1_name;
         TextView tv_aviprice;
         TextView tv_shangquanId;
    }
    private class ViewHolder2{
        ImageView img_main_show2;
        TextView tv_show2_name;
        TextView tv_show2_type;
        TextView tv_show2_money;
        TextView tv_show2_detail;
    }
}
