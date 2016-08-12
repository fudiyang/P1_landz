package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import landz.fdy.com.p1_landz.R;

/**
 * Created by fudiyang on 2016/8/4.
 * Author fudiyang
 * Description :
 */
public class ShaixuanAdapter extends BaseAdapter {

    private Context context;

    private List<Object>shaixuan;


    public ShaixuanAdapter(Context context, List<Object>shaixuan) {
        this.context = context;
        this.shaixuan = shaixuan;
    }

    @Override
    public int getCount() {
        return shaixuan==null?0:shaixuan.size();
    }

    @Override
    public Object getItem(int postion) {
        return shaixuan==null?null:shaixuan.get(postion);
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
            convertView=View.inflate(context, R.layout.textview_shaixuan,null);
            viewHolder.tv_shaixuan= (TextView) convertView.findViewById(R.id.tv_shaixuan);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        if(shaixuan!=null){
            viewHolder.tv_shaixuan.setText(shaixuan.get(position).toString());
        }
        return convertView;
    }

    private class ViewHolder{
        TextView tv_shaixuan;
    }
}
