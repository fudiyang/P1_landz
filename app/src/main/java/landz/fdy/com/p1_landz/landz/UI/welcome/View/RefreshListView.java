package landz.fdy.com.p1_landz.landz.UI.welcome.View;


import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import landz.fdy.com.p1_landz.R;
import landz.fdy.com.p1_landz.freamwork.utils.Constants;



/**
 * Created by fudiyang on 2016/7/21.
 * Author fudiyang
 * Description :
 */
public class RefreshListView extends ListView implements AbsListView.OnScrollListener,Handler.Callback{
    public int state;
    public static final int LOADING_MORE = 1;//正在加载更多
    public static final int DONE = 2;//加载完成
    public static final int PULL_TO_REFRESH = 3;//下拉状态
    public static final int RELASE_TO_REFRE = 4;//释放状态
    public static final int LOAD_REFRESH = 5;//下拉加载刷新

    private View headerView;//添加头部加载更多布局
    private View footerView;
    private int headViewHeight;//headerView的高度

    private ImageView img_arrow;//箭头
    private ImageView progressBar;//进度条
    private TextView tv_refresh;//下拉刷新字
    private Handler handler;

    private RotateAnimation animation;//下拉动画
    private RotateAnimation relase_animation;//释放动画

    private OnLoadMoreListener onLoadMoreListener;

    public RefreshListView(Context context) {
        this(context,null);
    }

    public RefreshListView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RefreshListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    public void init(Context context){
       footerView=View.inflate(context, R.layout.footerview_listview,null);
         addFooterView(footerView);
        footerView.setVisibility(INVISIBLE);
        ImageView img_progressbar = (ImageView) footerView.findViewById(R.id.img_progressbar);
        AnimationDrawable animationDrawable= (AnimationDrawable) img_progressbar.getDrawable();
        animationDrawable.start();

        headerView=View.inflate(context,R.layout.headview_listview,null);
        addHeaderView(headerView,null,false);
        img_arrow= (ImageView) headerView.findViewById(R.id.img_arrow);
        progressBar=(ImageView) headerView.findViewById(R.id.progressbar);
        tv_refresh = (TextView) headerView.findViewById(R.id.tv_refresh);
        animation=new RotateAnimation(0,-180, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setDuration(300);
        animation.setFillAfter(true);
        relase_animation=new RotateAnimation(-180,0,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        relase_animation.setDuration(300);
        relase_animation.setFillAfter(true);
        //计算出headerView的高度
        measureView(headerView);
        headViewHeight=headerView.getMeasuredHeight();
        //一开始隐藏headerView
        headerView.setPadding(0,-headViewHeight,0,0);
        setOnScrollListener(this);
        state=DONE;
        handler = new Handler(this);
    }
    public void measureView(View child) {
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

    @Override
    public void onScrollStateChanged(AbsListView absListView, int scrollState) {
        if(scrollState!=SCROLL_STATE_IDLE){
            return;
        }
        if(state==LOADING_MORE ||state==LOAD_REFRESH){
            return;
        }
        if(getLastVisiblePosition()==getCount()-1){
            if((getCount()-2)% Constants.PAGE_SIZE ==0){
              if(onLoadMoreListener!=null){
                  footerView.setVisibility(VISIBLE);
                 onLoadMoreListener.loadMore();
                  state=LOADING_MORE;
              }
            }
        }
    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {

    }
    private int startY, endY;

    /**
     * 触摸事件  1,按下事件  2，滑动事件  3，抬起事件
     *
     * @param ev
     * @return
     */

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //判断ListView当前是否滑动在顶部
        if (getFirstVisiblePosition() != 0 || state == LOADING_MORE)
            return super.onTouchEvent(ev);
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(state==DONE){
                    state=PULL_TO_REFRESH;
                }

                startY= (int) ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                endY= (int) ev.getY();
                setSelection(0);
               int  moveY=endY-startY-headViewHeight;
               headerView.setPadding(0,moveY,0,0);
                if(Math.abs(moveY)>=headViewHeight&&state!=RELASE_TO_REFRE){
                    state=RELASE_TO_REFRE;
                    img_arrow.clearAnimation();
                    img_arrow.startAnimation(animation);
                    tv_refresh.setText("松开刷新数据");
                }
                if(moveY<headViewHeight&&state!=PULL_TO_REFRESH){
                    state=PULL_TO_REFRESH;
                    img_arrow.clearAnimation();
                    img_arrow.startAnimation(relase_animation);
                    tv_refresh.setText("下拉刷新");
                }
                break;
            case MotionEvent.ACTION_UP:
                if(state==PULL_TO_REFRESH){
                     headerView.setPadding(0,-headViewHeight,0,0);
                }
                if(state==RELASE_TO_REFRE) {
                    headerView.setPadding(0, 0, 0, 0);

                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onRefresh();
                        img_arrow.setVisibility(GONE);
                        progressBar.setVisibility(VISIBLE);
                        footerView.setVisibility(GONE);
                        AnimationDrawable animationDrawable = (AnimationDrawable) progressBar.getDrawable();
                        animationDrawable.start();
                        handler.sendEmptyMessage(1);
                    }
                    state = LOAD_REFRESH;
                }
                        if(state==LOAD_REFRESH){
                            headerView.setPadding(0,0,0,0);
                        }
                    break;
             }



        return super.onTouchEvent(ev);
    }

    public void setOnComplete() {
        progressBar.setVisibility(GONE);
        img_arrow.setVisibility(VISIBLE);
        tv_refresh.setText("下拉刷新");
        state = DONE;
        setSelection(0);
        headerView.setPadding(0,-headViewHeight,0,0);
    }
    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    @Override
    public boolean handleMessage(Message message) {
        if(state!=LOAD_REFRESH){
            return false;
        }
        switch (message.what){
            case 1:
                tv_refresh.setText("正在加载.");
                handler.sendEmptyMessageDelayed(2,500);
                break;
            case 2:
                tv_refresh.setText("正在加载..");
                handler.sendEmptyMessageDelayed(3,500);
                break;
            case 3:
                tv_refresh.setText("正在加载...");
                handler.sendEmptyMessageDelayed(1,500);
                break;
        }
        return false;
    }

    public interface OnLoadMoreListener{
        void loadMore();
        void onRefresh();
    }
}
