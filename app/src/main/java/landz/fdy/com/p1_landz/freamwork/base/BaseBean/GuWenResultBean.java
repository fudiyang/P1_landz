package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import java.util.List;

/**
 * Created by fudiyang on 2016/7/27.
 * Author fudiyang
 * Description :
 */
public class GuWenResultBean {

    public String resultStatus;

    public String resultMsg;

    public GuWenBean result;

    @Override
    public String toString() {
        return "GuWenResultBean{" +
                "resultStatus='" + resultStatus + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", result=" + result +
                '}';
    }

    public class GuWenBean{
    public String totalAmount;
    public List<ShowArr> showArr;

    @Override
    public String toString() {
        return "GuWenBean{" +
                "totalAmount='" + totalAmount + '\'' +
                ", showArr=" + showArr +
                '}';
    }
}
    public class ShowArr{
        public String resourceId;//id
        public String showStartTime;
        public String createdTime;
        public String createdBy;
        public String createName;//顾问姓名
        public String phone;//电话
        public String photo;//头像
        public String inductionDate;//从业时间
        public String totalShowing;//本房看了多少次

        @Override
        public String toString() {
            return "ShowArr{" +
                    "resourceId='" + resourceId + '\'' +
                    ", showStartTime='" + showStartTime + '\'' +
                    ", createdTime='" + createdTime + '\'' +
                    ", createdBy='" + createdBy + '\'' +
                    ", createName='" + createName + '\'' +
                    ", phone='" + phone + '\'' +
                    ", photo='" + photo + '\'' +
                    ", inductionDate='" + inductionDate + '\'' +
                    ", totalShowing='" + totalShowing + '\'' +
                    '}';
        }
    }
}
