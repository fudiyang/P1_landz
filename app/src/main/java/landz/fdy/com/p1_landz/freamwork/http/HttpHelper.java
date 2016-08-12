package landz.fdy.com.p1_landz.freamwork.http;

import android.app.Activity;

import java.util.HashMap;
import java.util.Map;

import landz.fdy.com.p1_landz.freamwork.utils.UrlUtils;
import landz.fdy.com.p1_landz.landz.UI.welcome.request.OnLineHouseRequest;
import landz.fdy.com.p1_landz.landz.UI.welcome.request.SeeBuildRequest;

/**
 * Created by fudiyang on 2016/7/13.
 * Author fudiyang
 * Description :
 */
public class HttpHelper {
    public static void login(Activity activity,HttpRequestAsynctask.Callback callback){
        Map<String,String> map=new HashMap<String, String>();
        map.put("userName","landz");
        map.put("password","123456");
        Request request=new Request("http://www.baidu.com",10000,Request.Method.POST,map);
        HttpRequestAsynctask httpRequestAsynctask=new HttpRequestAsynctask(activity,callback);
        httpRequestAsynctask.execute(request);
    }

    public static void getOnLineHouseList(Activity activity, OnLineHouseRequest requestBean, HttpRequestAsynctask.Callback callback){

        Request request=new Request(UrlUtils.ONLINE_HOUSE,10000,Request.Method.POST,requestBean==null?null:requestBean.getRequestMap());
        HttpRequestAsynctask httpRequestAsynctask=new  HttpRequestAsynctask(activity,callback);
        httpRequestAsynctask.execute(request);

    }
            /**
             *  搜索
             * @param content 搜索的内容
             * @param type 搜索类型
             */

    public static void getSearchData(Activity activity,String content,String type,HttpRequestAsynctask.Callback callback){
        Map<String,String> map=new HashMap<>();
        map.put("keyWords",content);
        map.put("type",""+type);
        Request request=new Request(UrlUtils.SEARCH_URL,10000, Request.Method.GET,map);
        HttpRequestAsynctask httpRequestAsynctask=new  HttpRequestAsynctask(activity,callback);
        httpRequestAsynctask.execute(request);

    }

    /**
     * 房子详情
     * @param activity
     * @param houseOneId
     * @param callback
     */
    public static void getDetail(Activity activity, String houseOneId, HttpRequestAsynctask.Callback callback) {
        Map<String,String>map=new HashMap<>();
        map.put("houseOneId",houseOneId);
      Request request=new Request(UrlUtils.HOUSE_DETAIL,10000,Request.Method.GET,map);
        HttpRequestAsynctask httpRequestAsynctask=new  HttpRequestAsynctask(activity,callback);
        httpRequestAsynctask.execute(request);
    }

    /**
     * 一手房看房记录_本房顾问列表
     *
     * @param houseOneId
     */

    public static void getDetailLook(Activity activity, String houseOneId, HttpRequestAsynctask.Callback callback) {
        Map<String,String>map=new HashMap<>();
        map.put("houseOneId",houseOneId);
        Request request=new Request(UrlUtils.HOUSE_DETAIL_LOOK,10000,Request.Method.GET,map);
        HttpRequestAsynctask httpRequestAsynctask=new  HttpRequestAsynctask(activity,callback);
        httpRequestAsynctask.execute(request);
    }

    /**
     * 更多一手房源推荐
     * @param houseId 房源id
     * @param resblockId 楼盘ID
     */
    public static void getOneHouseDetailMore(Activity activity, String houseId,String resblockId, HttpRequestAsynctask.Callback callback) {
      Map<String,String>map=new HashMap<>();
        map.put("houseId",houseId);
        map.put("resblockId",resblockId);
        map.put("flag","1");
        map.put("pageNo","0");
        map.put("pageSize","3");
        Request request=new Request(UrlUtils.HOUSE_ONE_DETAIL_RECOMMEND_LIST_URL,10000,Request.Method.GET,map);
        HttpRequestAsynctask httpRequestAsynctask=new  HttpRequestAsynctask(activity,callback);
        httpRequestAsynctask.execute(request);
    }
    public static void getSeeBuild(Activity activity, SeeBuildRequest seeBuildRequestBean, HttpRequestAsynctask.Callback callback){

        Request request=new Request(UrlUtils.SEEBUILD_HOUSE_LIST_URL,10000,Request.Method.POST,seeBuildRequestBean==null?null:seeBuildRequestBean.getSeebuildQuest());
        HttpRequestAsynctask httpRequestAsynctask=new  HttpRequestAsynctask(activity,callback);
        httpRequestAsynctask.execute(request);

    }

    /**
     * 在售豪宅详情
     * @param activity
     * @param prodelId
     * @param callback
     */
    public static void getSeebuildDetail(Activity activity, String prodelId, HttpRequestAsynctask.Callback callback) {
        Map<String,String>map=new HashMap<>();
        map.put("resblockOneId",prodelId);
        Request request=new Request(UrlUtils.SEEBUILD_DETAIL_HOUSE_LIST_URL,10000,Request.Method.GET,map);
        HttpRequestAsynctask httpRequestAsynctask=new  HttpRequestAsynctask(activity,callback);
        httpRequestAsynctask.execute(request);
    }

    /**
     * 一手房看房记录_本房顾问列表
     *
     * @param prodelId
     */
    public static void getSeeGuWen(Activity activity, String prodelId, HttpRequestAsynctask.Callback callback) {
        Map<String,String>map=new HashMap<>();
        map.put("resblockOneId",prodelId);
        map.put("pageNo","0");
        map.put("pageSize","3");
        Request request=new Request(UrlUtils.SEEBUILD_DETAIL_GUWEN_LIST_URL,10000,Request.Method.GET,map);
        HttpRequestAsynctask httpRequestAsynctask=new  HttpRequestAsynctask(activity,callback);
        httpRequestAsynctask.execute(request);
    }

    /**
     * 一手房看房记录_本房顾问列表
     *
     * @param prodelId
     */
    public static void getSeeGuWenList(Activity activity, int pageNo,String prodelId, HttpRequestAsynctask.Callback callback) {
        Map<String,String>map=new HashMap<>();
        map.put("resblockOneId",prodelId);
        map.put("pageNo",pageNo+"");
        map.put("pageSize","10");
        map.put("type","0");
        Request request=new Request(UrlUtils.SEEBUILD_DETAIL_GUWEN_LIST_URL,10000,Request.Method.GET,map);
        HttpRequestAsynctask httpRequestAsynctask=new  HttpRequestAsynctask(activity,callback);
        httpRequestAsynctask.execute(request);
    }

    /**
     * 更多推荐
     *
     * @param resblockOneName
     */
    public static void getMoreTuijian(Activity activity, String resblockOneName, HttpRequestAsynctask.Callback callback) {
        Map<String,String>map=new HashMap<>();
        map.put("resblockOneName",resblockOneName);
        map.put("pageNo","0");
        map.put("pageSize","3");
        Request request=new Request(UrlUtils.SEEBUILD_MORE_TUIJIAN_URL,10000,Request.Method.GET,map);
        HttpRequestAsynctask httpRequestAsynctask=new  HttpRequestAsynctask(activity,callback);
        httpRequestAsynctask.execute(request);
    }

    /**
     * 更多推荐
     *
     * @param resblockOneName
     */
    public static void getMoreTuijianlist(Activity activity,int pageNo, String resblockOneName, HttpRequestAsynctask.Callback callback) {
        Map<String,String>map=new HashMap<>();
        map.put("resblockOneName",resblockOneName);
        map.put("pageNo",pageNo+"");
        map.put("pageSize","10");
        Request request=new Request(UrlUtils.SEEBUILD_MORE_TUIJIAN_URL,10000,Request.Method.GET,map);
        HttpRequestAsynctask httpRequestAsynctask=new  HttpRequestAsynctask(activity,callback);
        httpRequestAsynctask.execute(request);
    }
}
