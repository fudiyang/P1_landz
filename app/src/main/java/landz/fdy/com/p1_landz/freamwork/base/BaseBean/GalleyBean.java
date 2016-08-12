package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

/**
 * Created by Lizhangfeng on 2016/7/31 0031.
 * Description:
 */
public class GalleyBean {

    public int pos;

    public String picType;

    public String typeName;

    public GalleyBean(int pos, String picType, String typeName) {
        this.pos = pos;
        this.picType = picType;
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "GalleyBean{" +
                "pos=" + pos +
                ", picType='" + picType + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
