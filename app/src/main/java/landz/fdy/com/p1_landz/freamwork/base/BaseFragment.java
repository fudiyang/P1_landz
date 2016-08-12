package landz.fdy.com.p1_landz.freamwork.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

/**
 * Created by fudiyang on 2016/7/13.
 * Author fudiyang
 * Description :
 */
    public abstract class BaseFragment extends Fragment implements OnClickListener{

    protected View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootView==null){
            rootView=inflater.inflate(getResource(),null);
            beforeInitView();
            initView(rootView);
            initData();
        }
        ViewGroup parent=(ViewGroup) rootView.getParent();
        if(parent!=null){
            parent.removeView(rootView);
        }
        return  rootView;
    }
    protected  <T extends View> T findViewByIdNoCast(int id){
        return rootView==null?null:(T)rootView.findViewById(id);
    }
    protected abstract int getResource();

    protected abstract void beforeInitView();

    protected abstract void initView(View rootView);

    protected abstract void initData();
    protected  void setOnClick(int...ids){
        for(int id :ids){
            if(id !=-1){
                findViewByIdNoCast(id).setOnClickListener(this);
            }
        }
    }
}
