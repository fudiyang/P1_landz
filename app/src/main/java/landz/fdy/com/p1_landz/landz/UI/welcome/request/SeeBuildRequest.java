package landz.fdy.com.p1_landz.landz.UI.welcome.request;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fudiyang on 2016/8/2.
 * Author fudiyang
 * Description :
 */
public class SeeBuildRequest {

    /* 楼盘id */
    public String resblockId;
    /* 区域编码 */
    public String areaCode;
    /* 商圈id */
    public String circleTypeCode;
    /* 均价开始(一手单价、二手均价) */
    public String avgPriceBegin;
    /* 均价结束(一手单价、二手均价) */
    public String avgPriceEnd;
    /* 1均价从高到低 （降序） 2均价从低到高 （升序） */
    public String avgPriceSort;
    /* 是否优 : 1优  2不优  （二手） */
    public String isFavorable;
    /* 只看楼盘:1 一手 2 二手  */
    public String onlyLook;
    /* 经度 */
    public String longitude;
    /* 纬度 */
    public String latitude;
    /* 房型 */
    public String resblockType;
    /* 房间数 */
    public String roomNumber;

    public String pageNo="0";

    public String pageSize="10";

    public  Map<String,String> getSeebuildQuest(){
        Map<String,String> map =new HashMap<>();
        map.put("pageNo", "" + pageNo);
        map.put("pageSize", "" + pageSize);
        if (!TextUtils.isEmpty(resblockId))
            map.put("resblockId", "" + resblockId);
        if (!TextUtils.isEmpty(areaCode))
            map.put("areaCode", "" + areaCode);
        if (!TextUtils.isEmpty(circleTypeCode))
            map.put("circleTypeCode", "" + circleTypeCode);
        if (!TextUtils.isEmpty(avgPriceBegin))
            map.put("avgPriceBegin", "" + avgPriceBegin);
        if (!TextUtils.isEmpty(avgPriceEnd))
            map.put("avgPriceEnd", "" + avgPriceEnd);
        if (!TextUtils.isEmpty(avgPriceSort))
            map.put("avgPriceSort", "" + avgPriceSort);
        if (!TextUtils.isEmpty(longitude))
            map.put("longitude", "" + longitude);
        if (!TextUtils.isEmpty(latitude))
            map.put("latitude", "" + latitude);
        if (!TextUtils.isEmpty(resblockType))
            map.put("resblockType", "" + resblockType);
        if (!TextUtils.isEmpty(roomNumber))
            map.put("roomNumber", "" + roomNumber);
        if (!TextUtils.isEmpty(isFavorable))
            map.put("isFavorable", "" + isFavorable);
        if (!TextUtils.isEmpty(onlyLook))
            map.put("onlyLook", "" + onlyLook);


        return map;
    }
}
