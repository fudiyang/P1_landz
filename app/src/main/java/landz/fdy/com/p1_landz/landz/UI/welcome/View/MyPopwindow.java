package landz.fdy.com.p1_landz.landz.UI.welcome.View;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.paramListBean;
import landz.fdy.com.p1_landz.freamwork.utils.DisplayUtil;
import landz.fdy.com.p1_landz.freamwork.utils.LogUtils;
import landz.fdy.com.p1_landz.landz.UI.welcome.CallBack.TosatCallBack;
import landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse.onlineAdapter;

/**
 * Created by fudiyang on 2016/7/15.
 * Author fudiyang
 * Description :
 */
public class MyPopwindow extends PopupWindow implements TosatCallBack{
    private onlineAdapter adapter,adapter2;
    private ListView lv_location1,lv_location2;
    private TosatCallBack tosatCallBack;
    public MyPopwindow(Context context,TosatCallBack tosatCallBack){
      super(context);
        init(context);
        this.tosatCallBack=tosatCallBack;

    }
    public void init(Context context){
        View view=View.inflate(context, R.layout.items_onlinehouse,null);
        this.setContentView(view);
        this.setHeight(DisplayUtil.getDensity_Height(context)/2);
        this.setWidth(DisplayUtil.getDensity_Width(context));
        this.setBackgroundDrawable(new BitmapDrawable());
        this.setOutsideTouchable(true);
        this.setFocusable(true);
        lv_location1= (ListView) view.findViewById(R.id.lv_location1);
        lv_location2= (ListView) view.findViewById(R.id.lv_location2);
        adapter=new onlineAdapter(context);
        adapter2=new onlineAdapter(context);
        lv_location1.setAdapter(adapter);
        lv_location2.setAdapter(adapter2);
    }
    public void setParamListBean(final List<paramListBean> beanList,final boolean isOneDismiss){
        if(beanList==null||beanList.isEmpty()){
            return;
        }
        adapter.setItems(beanList);
        adapter.notifyDataSetChanged();
        lv_location1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //更新一级列表选中状态
                for (int i = 0; i < beanList.size(); i++) {
                    if (i == position){
                        beanList.get(i).isSelect = true;
                    }
                    else
                        beanList.get(i).isSelect = false;
                }
                adapter.notifyDataSetChanged();
                if(isOneDismiss){
                        dismiss();
                    LogUtils.e("msg",""+"dismiss-----");
                    if (tosatCallBack != null){
                        LogUtils.e("msg",""+"ffffffffffff"+adapter.getItem(position));
                        tosatCallBack.isToast((paramListBean) adapter.getItem(position));

                    }


                }


                //二级列表
                paramListBean bean = beanList.get(position);
               final List<paramListBean> childList = bean.childList;
                if(childList!=null){
                    lv_location2.setVisibility(View.VISIBLE);
                    lv_location2.setBackgroundColor(Color.BLUE);
                }
                adapter2.setItems(childList);
                adapter2.notifyDataSetChanged();


                lv_location2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //更新二级列表选中状态
                        for (int i = 0; i < childList.size(); i++) {
                            if (i == position)
                                childList.get(i).isSelect = true;
                            else
                                childList.get(i).isSelect = false;
                        }
                        adapter2.notifyDataSetChanged();
 //                      paramListBean paramList = (paramListBean) adapter2.getItem(position);

                        if (tosatCallBack != null){
                            tosatCallBack.isToast(childList.get(position));
                          dismiss();
                        }

                    }
                });
            }
        });

    }
    public  void showPopWindow(View view){
        if(!isShowing()){
            this.showAsDropDown(view);
            // this.showAtLocation(view, Gravity.TOP, 0, 0);//可以显示在指定view的指定位置
        }
    }

    @Override
    public void isToast(paramListBean paramlistBean) {

    }
}
