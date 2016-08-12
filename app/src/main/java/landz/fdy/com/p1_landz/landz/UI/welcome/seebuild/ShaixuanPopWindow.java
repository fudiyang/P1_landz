package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.util.List;
import java.util.Map;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.utils.ToastUtil;

/**
 * Created by fudiyang on 2016/8/4.
 * Author fudiyang
 * Description :
 */
public class ShaixuanPopWindow extends PopupWindow {

    private ShaiXuan shaiXuan;

public ShaixuanPopWindow(Context context, List<Object> shaixuan,ShaiXuan shaiXuan) {
        super(context);
        init(context,shaixuan);
    this.shaiXuan =shaiXuan;

    }
    private void init(Context context, final List<Object> shaixuan){

        View view=View.inflate(context, R.layout.item_listview_shaixuan,null);
        ListView lv_shaixuan= (ListView) view.findViewById(R.id.lv_shaixuan);
        ShaixuanAdapter shaixuanAdapter=new ShaixuanAdapter(context,shaixuan);
        lv_shaixuan.setAdapter(shaixuanAdapter);
        this.setContentView(view);
        this.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        this.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        lv_shaixuan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ToastUtil.showToast("position:"+position);
                          if(shaiXuan!=null){
                              shaiXuan.shaixuan(shaixuan.get(position).toString());
                              shaiXuan.weizi(position);
                          }
                   ShaixuanPopWindow.this.dismiss();
            }
        });

    }
    public  void showPopWindow(View view){
        if(!isShowing()){
            this.showAsDropDown(view);
            // this.showAtLocation(view, Gravity.TOP, 0, 0);//可以显示在指定view的指定位置
        }
    }

    public interface ShaiXuan{
        void shaixuan(String jushi);
        void weizi(int position);
    }
}
