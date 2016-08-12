package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ImgUrlArrSeebuildBean;

/**
 * Created by fudiyang on 2016/8/3.
 * Author fudiyang
 * Description :
 */
public class SeebuildGalleryAdapter extends BaseAdapter {

    private Context context;

    private List<ImgUrlArrSeebuildBean> imgUrlArrSeebuildBeen;

    public SeebuildGalleryAdapter(Context context, List<ImgUrlArrSeebuildBean> imgUrlArrSeebuildBeen) {
        this.context = context;
        this.imgUrlArrSeebuildBeen = imgUrlArrSeebuildBeen;
    }

    @Override
    public int getCount() {
        return imgUrlArrSeebuildBeen==null?0:imgUrlArrSeebuildBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return imgUrlArrSeebuildBeen==null?null:imgUrlArrSeebuildBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.item_seebuild_gallery,null);
        TextView textView= (TextView) convertView.findViewById(R.id.tv_seebuild_gallery);
        textView.setText(getTypeName(imgUrlArrSeebuildBeen.get(position).picType));
        return convertView;
    }

    private String getTypeName(String type) {
        if ("1".equals(type)) {
            return "外景图";
        }
        if ("2".equals(type)) {
            return "地理位置图";
        }
        if ("3".equals(type)) {
            return "座栋分布图";
        }
        if ("4".equals(type)) {
            return "户型图";
        }
        if ("5".equals(type)) {
            return "样板间";
        }
        if ("6".equals(type)) {
            return "实勘图";
        }
        return "未知";
    }
}
