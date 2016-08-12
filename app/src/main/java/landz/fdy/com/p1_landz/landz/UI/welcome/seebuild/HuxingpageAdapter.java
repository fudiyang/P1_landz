package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ApartmentImgVosBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ImgUrlArrSeebuildBean;
import landz.fdy.com.p1_landz.freamwork.image.ImageLoader;

/**
 * Created by fudiyang on 2016/8/4.
 * Author fudiyang
 * Description :
 */
public class HuxingpageAdapter extends BaseAdapter {

    private Context context;

    private List<ApartmentImgVosBean> apartmentImgVosBeen;

    private ImageLoader imageLoader;

    public HuxingpageAdapter(Context context, List<ApartmentImgVosBean> apartmentImgVosBeen) {
        this.context = context;
        this.apartmentImgVosBeen=apartmentImgVosBeen;
        imageLoader=new ImageLoader();
    }

    public void setApartmentImgVosBeen(List<ApartmentImgVosBean> apartmentImgVosBeen) {
        this.apartmentImgVosBeen = apartmentImgVosBeen;
    }

    public List<ApartmentImgVosBean> getApartmentImgVosBeen() {
        return apartmentImgVosBeen;
    }

    @Override
    public int getCount() {
        return apartmentImgVosBeen==null?0:apartmentImgVosBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return apartmentImgVosBeen==null?null:apartmentImgVosBeen.get(position);
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
            convertView=View.inflate(context, R.layout.item_huxing_gallery,null);
            viewHolder.huxing_photo= (ImageView) convertView.findViewById(R.id.huxing_photo);
            viewHolder.huxing_desc= (TextView) convertView.findViewById(R.id.huxing_desc);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
          if(apartmentImgVosBeen!=null){
              viewHolder.huxing_desc.setText(apartmentImgVosBeen.get(position).bedroomAmount+"室"+
              apartmentImgVosBeen.get(position).parlorAmount+"厅"+apartmentImgVosBeen.get(position).toiletAmount+"卫"
              +" "+apartmentImgVosBeen.get(position).totalprBegin+"-"+apartmentImgVosBeen.get(position).totalprEnd+"万"+
              " "+apartmentImgVosBeen.get(position).innenbereichSize+"平米");
              imageLoader.displayImg(apartmentImgVosBeen.get(position).imgUrl,viewHolder.huxing_photo);
          }

        return convertView;
    }

    private class ViewHolder{
        ImageView huxing_photo;
        TextView huxing_desc;
    }
}
