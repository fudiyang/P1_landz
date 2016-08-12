package landz.fdy.com.p1_landz.freamwork.http;

import android.app.Activity;
import android.app.DownloadManager;
import android.os.AsyncTask;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import landz.fdy.com.p1_landz.freamwork.utils.LogUtils;
import landz.fdy.com.p1_landz.freamwork.utils.NetWorkUtils;

/**
 * Created by fudiyang on 2016/7/13.
 * Author fudiyang
 * Description :
 */
public class HttpRequestAsynctask extends AsyncTask<Request,Integer,String>{

    //设置编码格式
    private  static final String CHARSET="UTF-8";
    private  Callback callback;
    private Activity activity;

    public HttpRequestAsynctask(Activity activity,Callback callback) {
        this.callback = callback;
        this.activity = activity;
    }
    private HttpURLConnection buildHttpClient(String urlStr,int timeout){
        URL url=null;
        HttpURLConnection conn=null;
        try{
            url=new URL(urlStr);
            conn=(HttpURLConnection) url.openConnection();
            conn.setReadTimeout(timeout);
            conn.setConnectTimeout(timeout);
            conn.setUseCaches(false);
            conn.setDoOutput(true);
        }catch (IOException e){
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    protected String doInBackground(Request... requests) {
        String resultString="";
        Request request=requests[0];
        if(!NetWorkUtils.isNetDeviceAvailable(activity)){
            return "网络不可用";
        }
        try {
           HttpURLConnection connection=buildHttpClient(request.getUrl(),request.getREQUEST_TIME_OUT());
            connection.setRequestMethod(request.getMethod().getMethed());
            StringBuffer params=new StringBuffer();
            if(request.getParams()!=null){
                for(Map.Entry<String,String> entry :request.getParams().entrySet()){
                    params.append("&").append(entry.getKey()).append("=").append(entry.getValue());
                    LogUtils.e("请求参数："+entry.getKey()+":"+entry.getValue());
                }
                byte[] bytes=params.toString().substring(1,params.length()).getBytes();
                connection.getOutputStream().write(bytes);
            }
            int responseCode=connection.getResponseCode();
            if(responseCode!=200){
                LogUtils.e("请求接口失败: responsecode="+responseCode);
                return null;
            }
            InputStream in=connection.getInputStream();
            InputStreamReader isReader = new InputStreamReader(in,CHARSET);
            BufferedReader bufReader=new BufferedReader(isReader);
            resultString=bufReader.readLine();
            LogUtils.e("接口返回结果："+resultString);
            connection.disconnect();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return resultString;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
       if(activity!=null&&!activity.isFinishing()){
           if(!TextUtils.isEmpty(s)){
               if("网络不可用".equals(s)){
                   if(callback!=null){
                       callback.Onfailed("网络不可用");
                   }
               }
               if (callback!=null){
                   callback.OnSuccess(s);
               }
           }else {
               if(callback!=null){
                   callback.Onfailed("网络不可用");
               }
           }
       }
        super.onPostExecute(s);
    }

    public interface Callback{
        void OnSuccess(String result);
        void Onfailed(String errMsg);
    }
}
