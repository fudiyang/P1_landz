package landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseActivity;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ImgUrlArrBean;

/**
 * Created by fudiyang on 2016/7/30.
 * Author fudiyang
 * Description :
 */
public class TextGalleryAdapter extends BaseAdapter {

    private Context context;

    private List<ImgUrlArrBean> imgUrlArrBeen;


    public TextGalleryAdapter(Context context, List<ImgUrlArrBean> imgUrlArrBeen) {
        this.context = context;
        this.imgUrlArrBeen = imgUrlArrBeen;
    }

    @Override
    public int getCount() {
        return imgUrlArrBeen == null ? 0 : imgUrlArrBeen.size();
    }

    public void setImgUrlArrBeen(List<ImgUrlArrBean> imgUrlArrBeen) {
        this.imgUrlArrBeen = imgUrlArrBeen;
    }

    @Override
    public Object getItem(int position) {
        return imgUrlArrBeen == null ? null : imgUrlArrBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        convertView = LayoutInflater.from(context).inflate(R.layout.item_textview_gallery, null);
        TextView textView = (TextView) convertView.findViewById(R.id.tv_gallery);
        textView.setText(getTypeName(imgUrlArrBeen.get(position).picType));

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
