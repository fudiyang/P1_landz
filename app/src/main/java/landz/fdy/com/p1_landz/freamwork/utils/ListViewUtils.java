package landz.fdy.com.p1_landz.freamwork.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by fudiyang on 2016/7/27.
 * Author fudiyang
 * Description :
 */
public class ListViewUtils {
    public static void measureView(View child) {
        ViewGroup.LayoutParams p = child.getLayoutParams();
        if (p == null) {
            p = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0, p.width);
        int lpHeight = p.height;
        int childHeightSpec;
        if (lpHeight > 0) {
            childHeightSpec = View.MeasureSpec.makeMeasureSpec(lpHeight, View.MeasureSpec.EXACTLY);
        } else {
            childHeightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

            /**
             * 计算ListView高度
             */
        public static void measureListViewHeight(ListView listView) {
                  ListAdapter adapter= listView.getAdapter();
                    int ListViweHeight=0;
                    if(adapter!=null){
                        for(int i=0;i<adapter.getCount();i++){
                            View view=adapter.getView(i,null,listView);
                            view.measure(0,0);
                            ListViweHeight+=view.getMeasuredHeight();
                        }
                    }
            ListViweHeight+=listView.getDividerHeight()*(listView.getCount()-1);
            ViewGroup.LayoutParams layoutParams=listView.getLayoutParams();
            layoutParams.height=ListViweHeight;
            listView.setLayoutParams(layoutParams);

            }
}
