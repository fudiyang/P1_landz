package landz.fdy.com.p1_landz.freamwork.http;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by fudiyang on 2016/7/13.
 * Author fudiyang
 * Description :
 */
public class Request {
    private String url;
    private int REQUEST_TIME_OUT = 10000;
    private Method method;
    private Map<String,String> params;

    public Request(String url, int REQUEST_TIME_OUT, Method method, Map<String, String> params) {
        this.url = url;
        this.REQUEST_TIME_OUT = REQUEST_TIME_OUT;
        this.method = method;
        this.params = params;
    }

    public int getREQUEST_TIME_OUT() {
        return REQUEST_TIME_OUT;
    }

    public String getUrl() {
        return url;
    }

    public Method getMethod() {
        return method;
    }

    public Map<String, String> getParams() {
        return params;
    }
    public enum Method{
    GET("GET"),POST("POST");
        private String methed;
        Method(String methed){
            this.methed=methed;
        }
        public String getMethed() {
            return methed;
        }
    }
}
