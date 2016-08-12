package landz.fdy.com.p1_landz.freamwork.share;

import android.content.Context;

/**
 * Created by fudiyang on 2016/7/13.
 * Author fudiyang
 * Description :
 */
public class ShareprenceHelper extends PrefrenceWrapper {
    private static ShareprenceHelper shareprenceHelper;
    protected ShareprenceHelper(Context context) {
        super(context);
    }
    public static ShareprenceHelper getInstance(Context context){
        if(shareprenceHelper==null){
            shareprenceHelper=new ShareprenceHelper(context);
        }
        return shareprenceHelper;
    }
    public void setUserName(String userName){
        putString("userName",userName);
    }
    public String getUserName(){
        return getString("userName");
    }
    public void setIsFirst(Boolean isFirst){
            setBoolean("isFirst",isFirst);
    }
    public boolean isFirst(){
        return getBoolean("isFirst",true);
    }

}
