package landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.paramListBean;
import landz.fdy.com.p1_landz.freamwork.utils.LogUtils;

/**
 * Created by fudiyang on 2016/7/15.
 * Author fudiyang
 * Description :
 */
public class onlineAdapter extends BaseAdapter {
    private Context context;
    private List<paramListBean> paramList;
    private boolean isMore;

    public onlineAdapter(Context context){
        this.context=context;
    }
    public void setItems(List<paramListBean> paramList){
        this.paramList=paramList;
    }
    public onlineAdapter(Context context, List<paramListBean> paramList) {
        this.context = context;
        this.paramList = paramList;
    }
   public void setMore(boolean more){
       isMore=more;
   }


    public List<paramListBean> getParamList() {
        return paramList;
    }


    @Override
    public int getCount() {
        return paramList==null?0:paramList.size();
    }

    @Override
    public Object getItem(int position) {
        return paramList==null?null:paramList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView=View.inflate(context,R.layout.textview_onlinehouse,null);
            viewHolder.tv_online_location=(TextView) convertView.findViewById(R.id.tv_online_location);
            viewHolder.ll_location=(LinearLayout) convertView.findViewById(R.id.ll_location);
            viewHolder.lv_location1=(ListView) convertView.findViewById(R.id.lv_location1);
            viewHolder.lv_location2=(ListView) convertView.findViewById(R.id.lv_location2);
            viewHolder.img_nike=(ImageView) convertView.findViewById(R.id.img_nike);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();

        }
        paramListBean bean =paramList.get(position);
        viewHolder.tv_online_location.setText(bean.name);
        LogUtils.e("msg","name"+bean.name);
        if(bean.isSelect){
             viewHolder.ll_location.setBackgroundColor(Color.GRAY);
             viewHolder.tv_online_location.setTextColor(Color.YELLOW);
            viewHolder.img_nike.setVisibility(View.VISIBLE);
            if(isMore){
                viewHolder.img_nike.setVisibility(View.VISIBLE);
                LogUtils.e("msg","进来了");
            }else {
                    viewHolder.img_nike.setVisibility(View.GONE);

            }
        }else {
            viewHolder.ll_location.setBackgroundColor(Color.MAGENTA);
            viewHolder.tv_online_location.setTextColor(Color.BLACK);
             viewHolder.img_nike.setVisibility(View.GONE);



        }
        return convertView;
    }
    private class ViewHolder{
        TextView tv_online_location;
        LinearLayout ll_location;
        ListView lv_location1;
        ListView lv_location2;
        ImageView img_nike;
    }
}
