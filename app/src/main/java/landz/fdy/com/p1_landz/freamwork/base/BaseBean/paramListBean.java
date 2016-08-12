package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import java.util.List;

/**
 * Created by fudiyang on 2016/7/15.
 * Author fudiyang
 * Description :
 */
public class paramListBean {
    public String key;
    public String name;
    public String value;
    public String minValue;
    public String maxValue;
    public List<paramListBean> childList;

    public boolean isSelect;

    public paramListBean(String name) {
        this.name = name;
    }

    public paramListBean( String name,String value) {
        this.value = value;
        this.name = name;
    }

    public paramListBean(String name, String value, boolean isSelect) {
        this.name = name;
        this.value = value;
        this.isSelect = isSelect;
    }

    public paramListBean(boolean isSelect, String name) {
        this.isSelect = isSelect;
        this.name = name;
    }

    public paramListBean(String name, boolean isSelect, List<paramListBean> childList) {
        this.name = name;
        this.isSelect = isSelect;
        this.childList = childList;
    }

    @Override
    public String toString() {
        return "paramListBean{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", minValue='" + minValue + '\'' +
                ", maxValue='" + maxValue + '\'' +
                ", childList=" + childList +
                '}';
    }
}
