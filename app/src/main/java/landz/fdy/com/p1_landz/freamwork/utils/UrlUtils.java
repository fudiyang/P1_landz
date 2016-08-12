package landz.fdy.com.p1_landz.freamwork.utils;

/**
 * Created by fudiyang on 2016/7/19.
 * Author fudiyang
 * Description :
 */
public class UrlUtils {
      public static  final String BASE_URL="http://119.254.70.199:8080/landz-app";
      public static final String  ONLINE_HOUSE = BASE_URL + "/house/houseBuySellList";
      /* 搜索 */
      public static final String SEARCH_URL = BASE_URL + "/homePage/getResblockListByKeyWords";//"keyWords", keyWords type

      /* 一手房子详情 */
      public static final String HOUSE_DETAIL = BASE_URL + "/houseOne/houseOneDetail";
      /* 一手房子详情-看房记录 */
      public static final String HOUSE_DETAIL_LOOK = BASE_URL + "/see/houseOneDetailSeeHistoryList";

      /* 一手房源详情更多一手房源推荐 (一手房源推荐列表) */
      public static final String HOUSE_ONE_DETAIL_RECOMMEND_LIST_URL = BASE_URL + "/houseOne/houseOneRecommendList";

      /* 在售豪宅seebuild*/
      public static final String SEEBUILD_HOUSE_LIST_URL = BASE_URL + "/resblock/resblockList";

      /* 在售豪宅详情seebuild*/
      public static final String SEEBUILD_DETAIL_HOUSE_LIST_URL = BASE_URL + "/resblockOne/resblockOneDetail";

      /* 楼盘鉴赏顾问*/

      public static final String SEEBUILD_DETAIL_GUWEN_LIST_URL = BASE_URL + "/broker/resblockOneDetailBrokerRecommendList";

         /* 更多推荐*/

      public static final String SEEBUILD_MORE_TUIJIAN_URL = BASE_URL + "/resblockOne/resblockOneRecommendList";

}

