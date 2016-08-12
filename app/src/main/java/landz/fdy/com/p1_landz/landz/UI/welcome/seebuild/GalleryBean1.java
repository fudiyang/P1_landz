package landz.fdy.com.p1_landz.landz.UI.welcome.seebuild;

/**
 * Created by fudiyang on 2016/8/3.
 * Author fudiyang
 * Description :
 */
public class GalleryBean1 {
    public int pos;

    public String picType;

    public String typeName;

    public GalleryBean1(int pos, String picType, String typeName) {
        this.pos = pos;
        this.picType = picType;
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "GalleryBean1{" +
                "pos=" + pos +
                ", picType='" + picType + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
