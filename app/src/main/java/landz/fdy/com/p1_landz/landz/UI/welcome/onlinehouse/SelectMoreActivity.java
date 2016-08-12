package landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseActivity;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ResultBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.onlineHouseBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.paramListBean;
import landz.fdy.com.p1_landz.freamwork.utils.LogUtils;
import landz.fdy.com.p1_landz.freamwork.utils.ToastUtil;
import landz.fdy.com.p1_landz.landz.MyApplication;
import landz.fdy.com.p1_landz.landz.UI.welcome.CallBack.TosatCallBack;

public class SelectMoreActivity extends BaseActivity implements TosatCallBack{
    private onlineAdapter adapter, adapter2;

    private ListView lv_location1, lv_location2;
     private TosatCallBack tosatCallBack;
    private onlineHouseBean onlinehouseBean;

    private ResultBean resultBean;
    private Map<Integer,String> selectMap;

    private List<paramListBean> mianji_paramList;

    @Override
    public int getContentViewId() {
        return R.layout.activity_select_more;
    }

    @Override
    public void beforeInitView() {
      selectMap=new HashMap<>();
        selectMap.put(0,"0");
        selectMap.put(1,"0");
        selectMap.put(2,"0");
        selectMap.put(3,"0");

     onlinehouseBean= MyApplication.getApplication().getonlineHouseBean();
        if(onlinehouseBean!=null){
                for(ResultBean bean :onlinehouseBean.result){
                        if("1004".equals(bean.paramType)){
                            mianji_paramList=bean.paramList;
                            mianji_paramList.get(0).isSelect = true;
                        }
                }
        }
        resultBean=new ResultBean();
        List<paramListBean> paramList=new ArrayList<>();
        paramList.add(new paramListBean("排序",true,getPaiXu()));
        paramList.add(new paramListBean("面积",false,mianji_paramList));
        paramList.add(new paramListBean("特色",false,getTeSe()));
        paramList.add(new paramListBean("一手/二手",false,getYiShou()));
        resultBean.paramList=paramList;

    }

    public List<paramListBean> getPaiXu(){
        List<paramListBean> paramListbean=new ArrayList<>();
        paramListbean.add(new paramListBean("默认排序","-1",true));
        paramListbean.add(new paramListBean("面积从大到小","1"));
        paramListbean.add(new paramListBean("面积从小到大","2"));
        paramListbean.add(new paramListBean("总价从低到高","3"));
        paramListbean.add(new paramListBean("总价从高到低","4"));
        paramListbean.add(new paramListBean("关注度从高到低","5"));

        return paramListbean;
    }
    public List<paramListBean> getTeSe(){
        List<paramListBean> paramListbean=new ArrayList<>();
        paramListbean.add(new paramListBean("不限","0",true));
        paramListbean.add(new paramListBean("今日可看房","1"));
        paramListbean.add(new paramListBean("钥匙房","2"));
        return paramListbean;
    }
    public List<paramListBean> getYiShou(){
        List<paramListBean> paramListbean=new ArrayList<>();
        paramListbean.add(new paramListBean("不限","0",true));
        paramListbean.add(new paramListBean("只看一手房","1"));
        paramListbean.add(new paramListBean("只看二手房","2"));
        return paramListbean;
    }
    @Override
    public void InitView() {
        lv_location1 = findViewByIdNoCast(R.id.lv_location1);
        lv_location2 = findViewByIdNoCast(R.id.lv_location2);

    }

    @Override
    public void InitData() {
       setOnClick(R.id.tv_clean,R.id.tv_ok);
      adapter=new onlineAdapter(this, resultBean.paramList);
        lv_location1.setAdapter(adapter);

     adapter2=new onlineAdapter(this,resultBean.paramList.get(0).childList);
        adapter2.setMore(true);
        lv_location2.setAdapter(adapter2);
        setParamListBean(resultBean.paramList);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
          case R.id.tv_clean:
              for(int i=0;i<resultBean.paramList.size();i++){
                  for (int j=0;j<resultBean.paramList.get(i).childList.size();j++){
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
            case R.id.tv_ok:
                String sort = "";//排序参数
                String buildSizeBegin = "";//建筑面积开始
                String buildSizeEnd = "";//建筑面积结束
                String feature = "";//特色
                String onlyLook = "";//一手二手
                sort=resultBean.paramList.get(0).childList.get(Integer.parseInt(selectMap.get(0))).value;
                buildSizeBegin=resultBean.paramList.get(1).childList.get(Integer.parseInt(selectMap.get(1))).minValue;
                buildSizeEnd=resultBean.paramList.get(1).childList.get(Integer.parseInt(selectMap.get(1))).maxValue;
                for(int i=0;i<resultBean.paramList.get(2).childList.size();i++){
                    if(resultBean.paramList.get(2).childList.get(i).isSelect){
                        feature=resultBean.paramList.get(2).childList.get(i).value+","+feature;
                    }

                }
                if(!TextUtils.isEmpty(feature)&&feature.length()>1){
                    feature=feature.substring(0,feature.length()-1);
                }
                onlyLook=resultBean.paramList.get(3).childList.get(Integer.parseInt(selectMap.get(3))).value;

                Intent intent=new Intent();
                intent.putExtra("sort",sort);
                intent.putExtra("buildSizeBegin",buildSizeBegin);
                intent.putExtra("buildSizeEnd",buildSizeEnd);
                intent.putExtra("feature",feature);
                intent.putExtra("onlyLook",onlyLook);
                setResult(200,intent);
                finish();
                break;



      }

    }

    private int onePos;//一级列表item位置

    public  void setParamListBean(final List<paramListBean> beanList) {
        if(beanList==null||beanList.isEmpty()){
            return;
        }
            adapter.setItems(beanList);
            adapter.notifyDataSetChanged();
            setSelectDatas(beanList,0);
        lv_location1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                onePos = position;
                //更新一级列表选中状态
                for (int i = 0; i < beanList.size(); i++) {
                    if (i == position){
                        beanList.get(i).isSelect = true;
                    }
                    else
                        beanList.get(i).isSelect = false;
                }
                adapter.notifyDataSetChanged();
                if ( tosatCallBack!= null){
                    tosatCallBack.isToast(beanList.get(position));
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

                        if ("特色".equals(adapter.getParamList().get(onePos).name)){

                            if(position==0){
                                adapter2.getParamList().get(position).isSelect=true;
                                selectMap.put(onePos,""+position);
                                for(int i=1;i<adapter2.getParamList().size();i++){
                                    adapter2.getParamList().get(i).isSelect=false;
                                }
                            }
                            else {
                                adapter2.getParamList().get(0).isSelect=false;
                                if ( childList.get(position).isSelect){
                                    childList.get(position).isSelect = false;
                                }else
                                    childList.get(position).isSelect = true;
                                    //selectMap.put(onePos,""+position);

                            }

                        }else {
                            //更新二级列表选中状态
                            for (int i = 0; i < childList.size(); i++) {
                                if (i == position) {
                                    childList.get(i).isSelect = true;
                                    selectMap.put(onePos,""+position);
                                }
                                else
                                    childList.get(i).isSelect = false;
                            }
                        }

                        adapter2.notifyDataSetChanged();

                        if (tosatCallBack != null){
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
