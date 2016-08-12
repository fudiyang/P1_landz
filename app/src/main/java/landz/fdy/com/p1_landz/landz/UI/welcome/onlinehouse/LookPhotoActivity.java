package landz.fdy.com.p1_landz.landz.UI.welcome.onlinehouse;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseActivity;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.GalleyBean;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ImgUrlArrBean;
import landz.fdy.com.p1_landz.freamwork.utils.LogUtils;
import landz.fdy.com.p1_landz.landz.MyApplication;
import landz.fdy.com.p1_landz.landz.UI.welcome.fragment.DetailFragment_1;

public class LookPhotoActivity extends BaseActivity {
    private DetailFragment_1 detail_fragment1;

    private List<ImgUrlArrBean> imgUrlArrBeen, textview;

    private LinearLayout ll_list, ll_typeSrcoll;//表格显示

    private ImageView img_list, img_close;

    private Gallery gallery;

    private TextGalleryAdapter galleryAdapter;

    private List<GalleyBean> galleryBeen;


    private int num ;

    public boolean isPageSelected, isItemSelect;


    @Override
    public int getContentViewId() {
        return R.layout.activity_look_photo;
    }

    @Override
    public void beforeInitView() {

        imgUrlArrBeen = MyApplication.getApplication().getImgUrlArr();
        galleryBeen=new ArrayList<>();
    }

    @Override
    public void InitView() {
        ll_list = findViewByIdNoCast(R.id.ll_list);
        ll_typeSrcoll = findViewByIdNoCast(R.id.ll_typeSrcoll);

        gallery = findViewByIdNoCast(R.id.gallery);
        img_close = findViewByIdNoCast(R.id.img_close);
        img_list = findViewByIdNoCast(R.id.img_list);

        detail_fragment1 = (DetailFragment_1) getSupportFragmentManager().findFragmentById(R.id.detail_fragment1);
    }

    @Override
    public void InitData() {
        setOnClick(R.id.img_list);
        setOnClick(R.id.img_close);

        detail_fragment1.setImgUrlArr(imgUrlArrBeen, false, true);

        addView(0);
//        addScrollView(0);
        textview = new ArrayList<>();
        String last_type = imgUrlArrBeen.get(0).picType;
        textview.add(imgUrlArrBeen.get(0));
        for (int i = 0; i < imgUrlArrBeen.size(); i++) {
            if (!imgUrlArrBeen.get(i).picType.equals(last_type)) {
                last_type = imgUrlArrBeen.get(i).picType;
                textview.add(imgUrlArrBeen.get(i));
                addView(i);
                //               addScrollView(i);
            }

        }
        //        hor_scrollView.addView(ll_typeSrcoll);
        galleryAdapter = new TextGalleryAdapter(this, textview);
        gallery.setAdapter(galleryAdapter);

        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                isItemSelect = true;

                gallery.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isItemSelect = false;
                    }
                }, 100);

                if (!isPageSelected) {
                     position=galleryBeen.get(position).pos+num*imgUrlArrBeen.size();
                    detail_fragment1.getViewPager().setCurrentItem(position);
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        detail_fragment1.getViewPager().setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                isPageSelected = true;
                num=position/imgUrlArrBeen.size();
                if (!isItemSelect) {
                    ImgUrlArrBean imgUrlArrBean=imgUrlArrBeen.get(position%imgUrlArrBeen.size());
                    String type =imgUrlArrBean.picType;
                    for (int i = 0; i < galleryBeen.size(); i++) {
                        if (type.equals(galleryBeen.get(i).picType)) {
                            gallery.setSelection(i);
                            break;
                        }

                    }

                }
                gallery.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isPageSelected = false;
                    }
                }, 100);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    /**
     * 通过指定位置添加view
     *
     * @param position
     */

    private void addView(int position) {
        TextView textView = new TextView(this);
        textView.setPadding(10, 10, 10, 10);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(22);
        textView.setText(getTypeName(imgUrlArrBeen.get(position).picType));
        ll_list.addView(textView);
        GalleyBean galleyBean = new GalleyBean(position, imgUrlArrBeen.get(position).picType, getTypeName(imgUrlArrBeen.get(position).picType));
        galleryBeen.add(galleyBean);

        List<ImgUrlArrBean> new_imgs = new ArrayList<>();
        for (ImgUrlArrBean imgUrlArrBean : imgUrlArrBeen) {
            if (imgUrlArrBean.picType.equals(imgUrlArrBeen.get(position).picType)) {
                new_imgs.add(imgUrlArrBean);
            }
        }
        RecyclerView recyclerView = new RecyclerView(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new LookPhotoAdapter(this, new_imgs));
        ll_list.addView(recyclerView);


    }

//    private void addScrollView(int position){
//        TextView tv=new TextView(this);
//        tv.setPadding(15,10,15,10);
//        tv.setTextColor(Color.WHITE);
//        if(position==0){
//            tv.setTextSize(20);
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
// //           layoutParams.gravity = Gravity.CENTER;
////           tv.setGravity();
//            tv.setLayoutParams(layoutParams);;
//        }else {
//            tv.setTextSize(14);
//        }
//         tv.setText(getTypeName(imgUrlArrBeen.get(position).picType));
//         ll_typeSrcoll.addView(tv);
//    }

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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_list:
                img_list.setVisibility(View.GONE);
                img_close.setVisibility(View.VISIBLE);
                findViewById(R.id.ll_fragment).setVisibility(View.GONE);
                ll_list.setVisibility(View.VISIBLE);
                break;
            case R.id.img_close:
                img_list.setVisibility(View.VISIBLE);
                img_close.setVisibility(View.GONE);
                findViewById(R.id.ll_fragment).setVisibility(View.VISIBLE);
                ll_list.setVisibility(View.GONE);
                break;
        }
    }
}
