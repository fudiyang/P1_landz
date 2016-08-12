package landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ImgUrlArrBean;
import landz.fdy.com.p1_landz.freamwork.image.ImageLoader2;


/**
 * Created by fudiyang on 2016/7/29.
 * Author fudiyang
 * Description :
 */
public class LookPhotoAdapter extends RecyclerView.Adapter<LookPhotoAdapter.ViewHolder> {


    private Context context;

    private List<ImgUrlArrBean> imgUrlArrBeen;

    public LookPhotoAdapter(Context context, List<ImgUrlArrBean> imgUrlArrBeen) {
        this.context = context;
        this.imgUrlArrBeen = imgUrlArrBeen;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

         View view=View.inflate(context, R.layout.item_look_photo,null);
        ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.img_photo= (ImageView) view.findViewById(R.id.img_photo);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.img_photo.setImageResource(R.mipmap.defult_twopic);
        if(imgUrlArrBeen.get(position)!=null){
            ImageLoader2.getInstance().displayImg(imgUrlArrBeen.get(position).picName,holder.img_photo);
        }

    }

    @Override
    public int getItemCount() {
        return imgUrlArrBeen==null?0:imgUrlArrBeen.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private  ImageView img_photo;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
