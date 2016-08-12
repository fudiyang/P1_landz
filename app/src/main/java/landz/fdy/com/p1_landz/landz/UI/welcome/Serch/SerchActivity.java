package landz.fdy.com.p1_landz.landz.UI.welcome.Serch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseActivity;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ResblockOneArrBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.SearchBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.SearchResultBean;
import landz.fdy.com.p1_landz.freamwork.http.HttpHelper;
import landz.fdy.com.p1_landz.freamwork.http.HttpRequestAsynctask;
import landz.fdy.com.p1_landz.freamwork.utils.IntentUtils;
import landz.fdy.com.p1_landz.freamwork.utils.LogUtils;
import landz.fdy.com.p1_landz.landz.UI.welcome.OnlineHouseActivity;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild.SeeBuildAdapter;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild.SeeBuildMoreDetailActivity;

public class SerchActivity extends BaseActivity {

    private EditText et_search;
    /**
     * type=1 地图过来的 type=2,二手楼盘过来的 type=3为买卖 type=4 租赁列表过来 type=5 首页过来
     */
    private int type;

    private SearchAdapter adapter;



    private SearchResultBean resultBean;

    private ListView lv_search;


    @Override
    public int getContentViewId() {
        return R.layout.activity_serch;
    }

    @Override
    public void beforeInitView() {
        type = getIntent().getIntExtra("type", 0);
        lv_search = findViewByIdNoCast(R.id.lv_serch);
    }

    @Override
    public void InitView() {
        et_search = findViewByIdNoCast(R.id.et_search);

    }

    @Override
    public void InitData() {
        adapter=new SearchAdapter(this);
        lv_search.setAdapter(adapter);
        switch (type) {
            case 5:
                et_search.setHint("请输入楼盘名称或房源特征…");

                break;
            case 2:
                et_search.setHint("请输入楼盘或商圈名称…");
        }
        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String content = et_search.getText().toString().trim();
                getData(content);
            }
        });
       ; lv_search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String resblockName = "";
                String circleTypeCode = "";

                SearchBean bean= (SearchBean) adapter.getItem(position);
                if("0".equals(bean.type)||"1".equals(bean.type)){
                    resblockName=bean.name;

                }else{
                    circleTypeCode=bean.id;

                }
                if(type==2){
                        Bundle bundle1=new Bundle();
                        String prodelId = bean.id;
                        String resblockOneName=bean.name;
                        bundle1.putString("resblockOneName",resblockOneName);
                        bundle1.putString("resblockOneId",prodelId);
                        IntentUtils.openActivity(SerchActivity.this,SeeBuildMoreDetailActivity.class,bundle1);
             }
                if(type==5){
                    Bundle bundle=new Bundle();
                    bundle.putString("resblockName",resblockName);
                    bundle.putString("circleTypeCode",circleTypeCode);
                    IntentUtils.openActivity(SerchActivity.this, OnlineHouseActivity.class,bundle);
                }
            }
        });

    }

    /**
     * 获取搜索数据
     *
     * @param content
     */
    public void getData(String content) {
        HttpHelper.getSearchData(this, content, "0", new HttpRequestAsynctask.Callback() {
            @Override
            public void OnSuccess(String result) {
                dismissSoftKeyboard(SerchActivity.this);
                resultBean = new Gson().fromJson(result, SearchResultBean.class);
                LogUtils.e("msg","resultBean:"+resultBean);
                adapter.setResultBeanList(resultBean.result);
                 adapter.notifyDataSetChanged();



            }

            @Override
            public void Onfailed(String errMsg) {
                dismissSoftKeyboard(SerchActivity.this);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
