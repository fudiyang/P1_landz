package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild_fragment;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.base.BaseActivity;
import landz.fdy.com.p1_landz.freamwork.base.BaseBean.ImgUrlArrSeebuildBean;
import landz.fdy.com.p1_landz.freamwork.utils.ToastUtil;
import landz.fdy.com.p1_landz.landz.MyApplication;
import landz.fdy.com.p1_landz.landz.UI.welcome.fragment.DetailFragment_1;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild.GalleryBean1;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild.SeeLookPhotoAdapter;
import landz.fdy.com.p1_landz.landz.UI.welcome.seebuild.SeebuildGalleryAdapter;

public class SeeBuildLookPhotoActivity extends BaseActivity {

    private SeeBuild_Fragment_1 seeBuild_fragment_1;

    private List<ImgUrlArrSeebuildBean> imgUrlArrSeebuildBeen,textview;

    private LinearLayout ll_seebuild_list, ll_seebuild_typeSrcoll;

    private ImageView img_seebuild_list, img_seebuild_close;

    private ScrollView scrollView_photo;

    private Gallery seebuild_gallery;

    private SeebuildGalleryAdapter seebuildGalleryAdapter;

    private List<GalleryBean1> galleryBean1s;

    private int num ;

    public boolean isPageSelected, isItemSelect;

    @Override
    public int getContentViewId() {
        return R.layout.activity_see_build_look_photo;
    }

    @Override
    public void beforeInitView() {
          imgUrlArrSeebuildBeen= MyApplication.getApplication().getImgUrlArrSeebuild();
        galleryBean1s=new ArrayList<>();
    }

    @Override
    public void InitView() {
        ll_seebuild_list= findViewByIdNoCast(R.id.ll_seebuild_list);
        ll_seebuild_typeSrcoll = findViewByIdNoCast(R.id.ll_seebuild_typeSrcoll);
        scrollView_photo=findViewByIdNoCast(R.id.scrollView_photo);
        seebuild_gallery = findViewByIdNoCast(R.id.seebuild_gallery);
        img_seebuild_close = findViewByIdNoCast(R.id.seebuild_img_close);
        img_seebuild_list = findViewByIdNoCast(R.id.seebuild_img_list);

        seeBuild_fragment_1 = (SeeBuild_Fragment_1) getSupportFragmentManager().findFragmentById(R.id.detail_seebuild_fragment1);

    }

    @Override
    public void InitData() {
        setOnClick(R.id.seebuild_img_close);
        setOnClick(R.id.seebuild_img_list);
        seeBuild_fragment_1.setImgUrlArrSeebuild(imgUrlArrSeebuildBeen,false,true);
        addView(0);
       textview=new ArrayList<>();
        String last_type=imgUrlArrSeebuildBeen.get(0).picType;
        textview.add(imgUrlArrSeebuildBeen.get(0));
        for(int i=0;i<imgUrlArrSeebuildBeen.size();i++){
            if(!imgUrlArrSeebuildBeen.get(i).picType.equals(last_type)){
                last_type=imgUrlArrSeebuildBeen.get(i).picType;
                textview.add(imgUrlArrSeebuildBeen.get(i));
                addView(i);
            }
        }
        seebuildGalleryAdapter=new SeebuildGalleryAdapter(this,textview);
        seebuild_gallery.setAdapter(seebuildGalleryAdapter);
        seebuild_gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                isItemSelect=true;
                seebuild_gallery.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isItemSelect=false;
                    }
                },100);
                if(!isPageSelected){
                    position=galleryBean1s.get(position).pos+num*imgUrlArrSeebuildBeen.size();
                    seeBuild_fragment_1.getSeebuild_viewPager().setCurrentItem(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
       });
        seeBuild_fragment_1.getSeebuild_viewPager().setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                   isPageSelected=true;
                   num=position/imgUrlArrSeebuildBeen.size();
                if(!isItemSelect){
                    ImgUrlArrSeebuildBean imgUrlArrSeebuildBean=imgUrlArrSeebuildBeen.get(position%imgUrlArrSeebuildBeen.size());
                    String type=imgUrlArrSeebuildBean.picType;
                    for(int i=0;i<galleryBean1s.size();i++){
                        if(type.equals(galleryBean1s.get(i).picType)){
                            seebuild_gallery.setSelection(i);
                            break;
                        }
                    }
                }
                seebuild_gallery.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isPageSelected=false;
                    }
                }, 100);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.seebuild_img_list:
                scrollView_photo.setVisibility(View.VISIBLE);
                img_seebuild_list.setVisibility(View.GONE);
                img_seebuild_close.setVisibility(View.VISIBLE);
                findViewById(R.id.ll_seebuild_fragment).setVisibility(View.GONE);
                ll_seebuild_list.setVisibility(View.VISIBLE);
                seebuild_gallery.setVisibility(View.GONE);
                break;
            case R.id.seebuild_img_close:
                scrollView_photo.setVisibility(View.GONE);
                img_seebuild_list.setVisibility(View.VISIBLE);
                img_seebuild_close.setVisibility(View.GONE);
                findViewById(R.id.ll_seebuild_fragment).setVisibility(View.VISIBLE);
                ll_seebuild_list.setVisibility(View.GONE);
                seebuild_gallery.setVisibility(View.VISIBLE);
                break;
        }


    }
    private void addView(int position) {
        TextView textView = new TextView(this);
        textView.setPadding(10, 10, 10, 10);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(22);
        textView.setText(getTypeName(imgUrlArrSeebuildBeen.get(position).picType));
        ll_seebuild_list.addView(textView);
        GalleryBean1 galleryBean1=new GalleryBean1(position,imgUrlArrSeebuildBeen.get(position).picType,getTypeName(imgUrlArrSeebuildBeen.get(position).picType));
        galleryBean1s.add(galleryBean1);

        List<ImgUrlArrSeebuildBean> new_imgs=new ArrayList<>();
        for(ImgUrlArrSeebuildBean imgUrlArrSeebuildBean:imgUrlArrSeebuildBeen){
            if(imgUrlArrSeebuildBean.picType.equals(imgUrlArrSeebuildBeen.get(position).picType)){
                new_imgs.add(imgUrlArrSeebuildBean);
            }
        }
        RecyclerView recyclerView=new RecyclerView(this);
        GridLayoutManager layoutManager=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new SeeLookPhotoAdapter(this,new_imgs));
        ll_seebuild_list.addView(recyclerView);
        ScrollView scrollView=new ScrollView(this);


    }
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
}
