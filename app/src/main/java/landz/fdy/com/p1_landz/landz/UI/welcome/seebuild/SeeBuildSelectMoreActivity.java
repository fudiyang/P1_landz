package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseActivity;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ResultBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.onlineHouseBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.paramListBean;
import landz.fdy.com.p1_landz.freamwork.utils.ToastUtil;
import landz.fdy.com.p1_landz.landz.MyApplication;
import landz.fdy.com.p1_landz.landz.UI.welcome.CallBack.TosatCallBack;
import landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse.onlineAdapter;

public class SeeBuildSelectMoreActivity extends BaseActivity implements TosatCallBack{

    private onlineAdapter adapter1,adapter2;

    private ListView lv_location1,lv_location2;

    private TosatCallBack tosatCallBack;

    private onlineHouseBean onlinehouseBean;

    private ResultBean resultBean;

    private Map<Integer,String> selectMap;

    @Override
    public int getContentViewId() {
        return R.layout.activity_see_build_select_more;
    }

    @Override
    public void beforeInitView() {
        selectMap=new HashMap<>();
        selectMap.put(0,"0");
        selectMap.put(1,"0");
        selectMap.put(2,"0");
        onlinehouseBean= MyApplication.getApplication().getonlineHouseBean();

        resultBean=new ResultBean();
        List<paramListBean> paramList=new ArrayList<>();
        paramList.add(new paramListBean("排序",true,getPaiXu()));
        paramList.add(new paramListBean("优惠",false,getYouHui()));
        paramList.add(new paramListBean("一手/二手",false,getYiShou()));
        resultBean.paramList=paramList;
    }
     private List<paramListBean> getPaiXu(){
         List<paramListBean> paramListBeen=new ArrayList<>();
         paramListBeen.add(new paramListBean("不限","-1",true));
         paramListBeen.add(new paramListBean("降序","1"));
         paramListBeen.add(new paramListBean("升序","2"));
         return paramListBeen;
     }
    private List<paramListBean> getYouHui(){
        List<paramListBean> paramListBeen=new ArrayList<>();
        paramListBeen.add(new paramListBean("不限","-1",true));
        paramListBeen.add(new paramListBean("优惠","1"));
        paramListBeen.add(new paramListBean("不优惠","2"));
        return paramListBeen;
    }
    private List<paramListBean> getYiShou(){
        List<paramListBean> paramListBeen=new ArrayList<>();
        paramListBeen.add(new paramListBean("不限","-1",true));
        paramListBeen.add(new paramListBean("只看一手房","1"));
        paramListBeen.add(new paramListBean("只看二手房","2"));
        return paramListBeen;
    }

    @Override
    public void InitView() {
        lv_location1=findViewByIdNoCast(R.id.lv_location1);
        lv_location2=findViewByIdNoCast(R.id.lv_location2);

    }

    @Override
    public void InitData() {
       setOnClick(R.id.tv_seebuild_clean,R.id.tv_seebuild_ok);
        adapter1=new onlineAdapter(this,resultBean.paramList);
        lv_location1.setAdapter(adapter1);
        adapter2=new onlineAdapter(this,resultBean.paramList.get(0).childList);
        adapter2.setMore(true);
        lv_location2.setAdapter(adapter2);
        setParamListBean(resultBean.paramList);

    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_seebuild_clean:
                for(int i=0;i<resultBean.paramList.size();i++){
                    for(int j=0;j<resultBean.paramList.get(i).childList.size();j++){
                        if(j==0){
                            resultBean.paramList.get(i).childList.get(j).isSelect=true;
                            ToastUtil.showToast("清空成功");
                        }else {
                            resultBean.paramList.get(i).childList.get(j).isSelect=false;
                        }
                    }
                }
                setParamListBean(resultBean.paramList);
                break;
            case R.id.tv_seebuild_ok:
                String avgPriceSort = "";//升降序
                String isFavorable  = "";//优步优惠
                String onlyLook  = "";//一二手
                avgPriceSort=resultBean.paramList.get(0).childList.get(Integer.parseInt(selectMap.get(0))).value;
                isFavorable=resultBean.paramList.get(0).childList.get(Integer.parseInt(selectMap.get(1))).value;
                onlyLook=resultBean.paramList.get(0).childList.get(Integer.parseInt(selectMap.get(2))).value;
                Intent intent=new Intent();
                intent.putExtra("avgPriceSort",avgPriceSort);
                intent.putExtra("isFavorable",isFavorable);
                intent.putExtra("onlyLook",onlyLook);
                setResult(200,intent);
                finish();
                break;
        }

    }
    private int onePos;
    private void setParamListBean(final List<paramListBean> beanList){
        if(beanList==null||beanList.isEmpty()){
            return;
        }
        adapter1.setItems(beanList);
        adapter1.notifyDataSetChanged();
        setSelectDatas(beanList,0);

        lv_location1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                onePos= position;
                for (int i=0;i<beanList.size();i++){
                    if(i==position){
                        beanList.get(i).isSelect=true;
                    }else {
                        beanList.get(i).isSelect=false;
                    }
                }
                adapter1.notifyDataSetChanged();
                if(tosatCallBack!=null){
                    tosatCallBack.isToast(beanList.get(position));
                }

                paramListBean bean=beanList.get(position);
                final List<paramListBean> childList=bean.childList;
                if(childList!=null){
                    lv_location2.setVisibility(View.VISIBLE);
                    lv_location2.setBackgroundColor(Color.BLUE);
                }
                adapter2.setItems(childList);
                adapter2.notifyDataSetChanged();
                lv_location2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        for (int i=0;i<childList.size();i++){
                           if(i==position){
                               childList.get(i).isSelect=true;
                               selectMap.put(onePos,""+position);
                           }  else {
                               childList.get(i).isSelect=false;
                           }
                        }
                        adapter2.notifyDataSetChanged();
                        if(tosatCallBack!=null){
                            tosatCallBack.isToast(childList.get(position));
                        }
                    }
                });
            }
        });
    }
    public void setSelectDatas(List<paramListBean> beanList, int position) {


    }
    @Override
    public void isToast(paramListBean paramlistBean) {

    }
}
