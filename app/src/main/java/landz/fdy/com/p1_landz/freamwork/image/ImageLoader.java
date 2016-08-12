package landz.fdy.com.p1_landz.freamwork.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by fudiyang on 2016/7/20.
 * Author fudiyang
 * Description :
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
public class ImageLoader {
    /**线程池**/
    private ExecutorService mExecutorService;
    /**用于缓存图片**/
    //可以设置图片占内存最大的值   同时 里面有优化内存的操作   有回收图片机制
    //跟map集合使用是一样
    private LruCache<String, Bitmap> mLrcCache;
    public ImageLoader() {
        mExecutorService = Executors.newFixedThreadPool(3);//同时只允许三个线程运行
        //		mLrcCache = new LruCache<String, Bitmap>(maxSize);
        initLrcCache();
    }

    //设置开关  比如滑动过快  则关闭从网络和本地获取图片
    private boolean mIsBusy = false;
    public void setmIsBusy(boolean mIsBusy) {
        this.mIsBusy = mIsBusy;
    }

    private void initLrcCache() {
        //获取系统分配给每个应用程序的最大内存，每个应用系统分配64M
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        Log.i("msg","maxMemory="+maxMemory);
        //		int mCacheSize = maxMemory / 8;
        int mCacheSize = 5000 * 1024;
        mLrcCache = new LruCache<String, Bitmap>(mCacheSize){
            //设置里面每个对象的最大的值可以为多少
            @Override
            protected int sizeOf(String key, Bitmap value) {
                int size = 0;
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1){
                    size = value.getByteCount();
                    //3.1版本之后，使用的是这个方法获取bitmap的内存大小
                    Log.i("msg","size ="+size);
                    return size;
                }
                //3.1版本之前，使用的是这个方法获取bitmap的内存大小
                size = value.getRowBytes() * value.getHeight();
                Log.i("msg","size ="+size);
                return size;
            }
        };
    }

    //下载图片的方法
    public void displayImg(String imgUrl,ImageView imageView){
        //设置防错乱标记
        imageView.setTag(imgUrl);
        //从缓存中获取图片   url 当成key值
        Bitmap bitmap = mLrcCache.get(imgUrl);
        if(bitmap != null){
            //加载图片到IamgeView
            showBitmap(imageView, imgUrl, bitmap);
            return;//如果获得了图片，方法就结束  不然图片没拿到，则继续从本地或者网络
        }
        if(!mIsBusy){//滑动太快 我们就禁止加载获取图片
            //从网络和本地拿使用线程池
            //使用线程池执行线程接口对象
            LoadBitmapRunnable loadBitmapRunnable = new LoadBitmapRunnable(imageView, imgUrl);
            mExecutorService.execute(loadBitmapRunnable);
        }
    }

    /**
     * 加载显示bitmap的线程  网络和本地放在子线程中
     * @author Administrator
     *
     */
    private class LoadBitmapRunnable implements Runnable{
        private ImageView imageView;
        private String imgUrl;
        public LoadBitmapRunnable(ImageView imageView, String imgUrl) {
            super();
            this.imageView = imageView;
            this.imgUrl = imgUrl;
        }
        @Override
        public void run() {
            //从本地拿  如果从本地拿到图片  则会放到缓存中

            try {
                Bitmap bitmap = getBitmapFromLocal(imgUrl);
                if (bitmap != null) {
                    showBitmap(imageView, imgUrl, bitmap);
                    return;
                }
                //从网络获取  获取到了之后  存到本地和内存中
                Bitmap bitmap1 = getBitmapFromNetwork(imgUrl, imageView);
                if (bitmap1 != null) {
                    showBitmap(imageView, imgUrl, bitmap1);

                }
            }
                catch(OutOfMemoryError o){
                    o.printStackTrace();
                }
            }



    }

    //因为是在子线程中，所以不能直接更新UI
    public void  showBitmap(ImageView imageView, String imgUrl,Bitmap bitmap){
        //防错乱判断
        if(!imageView.getTag().equals(imgUrl)){
            return ;
        }
        //使用runOnUiThread 方法  或者使用Hnalder
        //runOnUiThread 利用UI线程的资源执行这个Runnable对象
        showBitmapRunnable action = new showBitmapRunnable(imageView, bitmap);
        imageView.post(action);
    }

    class showBitmapRunnable implements Runnable{
        private Bitmap bitmap;
        private ImageView imageView;
        public showBitmapRunnable(ImageView imageView,Bitmap bitmap) {
            this.bitmap = bitmap;
            this.imageView = imageView;
        }
        @Override
        public void run() {
            imageView.setImageBitmap(bitmap);
        }

    }

    /**
     * 将bitmap放入lrc缓存
     * @param bitmap
     * @param urlStr
     */
    private void addBitmapToCache(Bitmap bitmap,String urlStr){
        mLrcCache.put(urlStr, bitmap);
    }

    /**
     * 从lrc缓存中获取bitmap
     * @param imgUrl
     * @return
     */
    private Bitmap getBitmapFromCache(String imgUrl){
        return mLrcCache.get(imgUrl);
    }

    /**
     * 从本地获取Bitmap
     * @param imgUrl
     * @return
     */
    public Bitmap getBitmapFromLocal(String imgUrl) {
        //TODO
        Bitmap bitmap = BitmapUtils.getBitmapFromSDCard(imgUrl);
        if(bitmap != null){
            addBitmapToCache(bitmap, imgUrl);
        }
        return bitmap;
    }
    /**
     * 从网络获取Bitmap
     * @param imgUrl
     * @return
     */
    public Bitmap getBitmapFromNetwork(String imgUrl,ImageView imageView){
        Bitmap bitmap = null;
        try {
            URL url  = new URL(imgUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(8 * 1000);
            conn.setReadTimeout(8 * 1000);
            InputStream is = conn.getInputStream();
            //将 流转化为 优化了的bitmap
            bitmap = BitmapUtils.getBitmap(is);
            if(bitmap == null){
                Log.i("msg", "bitmap == null");
            }
            //将图片保存在本地
            BitmapUtils.saveBitmap(bitmap, imgUrl);
            //加入lrc缓存
            addBitmapToCache(bitmap, imgUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        return bitmap;
    }


}
