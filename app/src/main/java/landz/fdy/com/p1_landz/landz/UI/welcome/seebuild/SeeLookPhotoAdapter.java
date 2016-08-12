package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ImgUrlArrSeebuildBean;
import landz.fdy.com.p1_landz.freamwork.image.ImageLoader;
import landz.fdy.com.p1_landz.freamwork.image.ImageLoader2;

/**
 * Created by fudiyang on 2016/8/3.
 * Author fudiyang
 * Description :
 */
public class SeeLookPhotoAdapter extends RecyclerView.Adapter<SeeLookPhotoAdapter.ViewHolder> {

     private Context context;

    private List<ImgUrlArrSeebuildBean> imgUrlArrSeebuildBeen;

    public SeeLookPhotoAdapter(Context context, List<ImgUrlArrSeebuildBean> imgUrlArrSeebuildBeen) {
        this.context = context;
        this.imgUrlArrSeebuildBeen = imgUrlArrSeebuildBeen;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.item_seelookphoto,null);
        ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.img_see_photo= (ImageView) view.findViewById(R.id.img_see_photo);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         holder.img_see_photo.setImageResource(R.mipmap.defult_twopic);
        if(imgUrlArrSeebuildBeen!=null){
            ImageLoader2.getInstance().displayImg(imgUrlArrSeebuildBeen.get(position).picName,holder.img_see_photo);
        }
    }

 @Override
    public int getItemCount() {
        return imgUrlArrSeebuildBeen==null?0:imgUrlArrSeebuildBeen.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img_see_photo;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
