package landz.fdy.com.p1_landz.freamwork.share;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by fudiyang on 2016/7/13.
 * Author fudiyang
 * Description :
 */
public class PrefrenceWrapper {
    private SharedPreferences sharedPreferences;
    private static final String SP_NAME="share_landz";

    protected PrefrenceWrapper(Context context) {
       sharedPreferences=context.getSharedPreferences(SP_NAME,context.MODE_PRIVATE);
    }
    protected void putString(String key,String value){
        sharedPreferences.edit().putString(key,value).commit();
    }
    protected String getString(String key){
        return sharedPreferences.getString(key,"");
    }
    protected  String getString(String key,String defalutValue){
        return  sharedPreferences.getString(key,defalutValue);
    }
    protected void setBoolean(String key,Boolean value){
        sharedPreferences.edit().putBoolean(key,value).commit();
    }
    protected Boolean getBoolean(String key,Boolean defalutValue){
        return sharedPreferences.getBoolean(key, defalutValue);
    }

    /**
     * 清空sharePreference的文件
     */
    public void clear(){
        sharedPreferences.edit().clear();
    }
}
