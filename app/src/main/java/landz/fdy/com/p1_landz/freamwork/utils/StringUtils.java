package landz.fdy.com.p1_landz.freamwork.utils;

import android.icu.text.DecimalFormat;
import android.net.Uri;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类名称 ：StringUtils 类描述 ：String判断处理工具类 创建人 ：李章丰 创建时间：下午3:02:09
 */
public class StringUtils {

    /**
     * 判断字符串是否为null或者空字符串
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        boolean result = false;
        if (null == str || "".equals(str.trim())) {
            result = true;
        }
        return result;
    }

    /**
     * @param string
     * @return
     */
    public static boolean isNotEmpty(String string) {
        if (null != string && !"".equals(string.trim())) {
            return true;
        }
        return false;
    }

    /**
     * 去掉一个字符串中的所有的单个空格" "
     *
     * @param string
     */
    public static String replaceSpaceCharacter(String string) {
        if (null == string || "".equals(string)) {
            return "";
        }
        return string.replace(" ", "");
    }

    /**
     * 获取小数位为6位的经纬度
     *
     * @param string
     * @return
     */
    public static String getStringLongitudeOrLatitude(String string) {
        if (StringUtils.isEmpty(string)) {
            return "";
        }
        if (string.contains(".")) {
            String[] splitArray = string.split("\\.");
            if (splitArray[1].length() > 6) {
                String substring = splitArray[1].substring(0, 6);
                return splitArray[0] + "." + substring;
            } else {
                return string;
            }
        } else {
            return string;
        }
    }

    /**
     * 检查是否有中文
     *
     * @param str
     * @return
     */
    public static boolean checkString(String str) {
        boolean res = false;
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                // 只要字符串中有中文则为中文
                if (!checkChar(str.charAt(i))) {
                    res = true;
                    break;
                } else {
                    res = false;
                }
            }
        }
        return res;
    }

    // 英文占1byte，非英文（可认为是中文）占2byte，根据这个特性来判断字符
    public static boolean checkChar(char ch) {
        if ((ch + "").getBytes().length == 1) {
            return true;// 英文
        } else {
            return false;// 中文
        }
    }

    /**
     * 转化成int
     *
     * @param s
     * @return
     */
    public static int getInteger(String s) {
        return isEmpty(s) ? 0 : Integer.parseInt(s);
    }

    /**
     * 获取数量s
     *
     * @param s
     * @return
     */
    public static String getNumString(String s) {
        return isEmpty(s) || "null".equals(s) ? "0" : s;
    }


    /**
     * 距离处理
     *
     * @param distance
     */
    public static String getDistance(String distance) {
        if (StringUtils.isEmpty(distance) || "null".equals(distance))
            return "";
        try {
            float dis = Float.parseFloat(distance);
            if (dis > 1000) {

                String ds = "" + dis / 1000;

                int index = ds.indexOf(".");
                if (index != -1)
                    return ds.substring(0, index + 2) + "km";
                return ds + "km";

            } else {
                return "" + (int) dis + "m";
            }
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 获取简介
     * @param desc
     * @return
     */
    public static String getDesc(String desc) {
        return isEmpty(desc) ? "无" : desc;
    }

    /**
     * 判断是不是一个url
     *
     * @param url
     * @return
     */
    public static boolean isCorrectUrl(String url) {
        if (isEmpty(url))
            return false;

        if (url.startsWith("http"))
            return true;
        if (url.startsWith("fttp"))
            return true;

        return false;
    }

    /**
     * 显示消息的数量
     *
     * @param count
     * @return
     */
    public static String getMsgCount(int count) {
        if (count > 99)
            return "99+";
        return "" + count;
    }

    /**
     * 通过string获取uri
     *
     * @param url
     * @return
     */
    public static Uri getUri(String url) {
        return Uri.parse(isEmpty(url) ? "" : url);
    }

    /**
     * 保留两位小数
     *
     * @return
     */
    public static String doubleFormat(String value)
    {
        if (isEmpty(value))
            return "";

        DecimalFormat df = new DecimalFormat("######.#");
        return df.format(Double.parseDouble(value));
    }

    public static String longToStrng(Long time, String format) {
        Date date = new Date(time);
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateString = formatter.format(date);
        return dateString;
    }

}
