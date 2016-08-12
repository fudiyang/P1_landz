package landz.fdy.com.p1_landz.landz.UI.welcome.Serch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.SearchBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.SearchResultBean;
import landz.fdy.com.p1_landz.freamwork.utils.LogUtils;

/**
 * Created by fudiyang on 2016/7/25.
 * Author fudiyang
 * Description :
 */
public class SearchAdapter extends BaseAdapter {

    private Context context;

    private List<SearchBean> resultBeanList;

    public SearchAdapter(Context context) {
        this.context = context;
    }

    public void setResultBeanList(List<SearchBean> resultBeanList) {
        LogUtils.e("msg",resultBeanList.toString());
        this.resultBeanList = resultBeanList;
    }

    @Override
    public int getCount() {
        return resultBeanList==null?0:resultBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return resultBeanList==null?null:resultBeanList.get(position);
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
            convertView=View.inflate(context, R.layout.search_textview,null);
            viewHolder.tv_search= (TextView) convertView.findViewById(R.id.tv_search);
            convertView.setTag(viewHolder);
        }else {
          viewHolder= (ViewHolder) convertView.getTag();
        }

          SearchBean searchBean=resultBeanList.get(position);
        if (searchBean!=null){
            LogUtils.e("msg","name:"+searchBean.name );
            viewHolder.tv_search.setText(searchBean.name);
        }

        LogUtils.e("msg","name:"+searchBean.name);

        return convertView;
    }

    private class ViewHolder{
        private TextView tv_search;
    }
}
