package landz.fdy.com.p1_landz.freamwork.base.BaseBean;

import java.util.List;

/**
 * Created by fudiyang on 2016/7/26.
 * Author fudiyang
 * Description :
 */
public class HouseDetailBean {

    /* 展示图集合 */
    public List<ImgUrlArrBean> imgUrlArr;

    /* 一手房源的描述 */
    public String roomDescripe;
    /*  楼盘名称 */
    public String resblockOneName;
    /* 楼盘ID */
    public String prodelId;
    /* 房源ID */
    public String houseOneId;
    /* 室数(户型)*/
    public int bedroomAmount;
    /* 厅数(户型) */
    public int parlorAmount;
    /*  卫生间数(户型) */
    public int toiletAmount;
    /* 建筑面积(户型) */
    public double gfa;
    /* 室内面积(户型) */
    public double innenbereichSize;
    /* 楼盘类型(户型) */
    public String resblockType;
    /* 单价开始区间(户型) */
    public double unitprBegin;
    /* 单价结束区间(户型) */
    public double unitprEnd;
    /* 总价开始区间(户型) */
    public double totalprBegin;
    /* 总价结束区间(户型) */
    public double totalprEnd;
    /* 行政区 */
    public String districtName;
    /* 商圈名称(一手楼盘) */
    public String circleTypeName;
    /*  楼盘地址(一手楼盘) */
    public String resblockAddr;
    /* 楼盘描述(一手楼盘) */
    public String formType;
    /* 装修标准(一手楼盘) */
    public String decorationName;
    /* 单平米装修标准(一手楼盘) */
    public double metersPrice;
    /* 占地面积(一手楼盘) */
    public double covers;
    /* 交房时间(一手楼盘) */
    public long launchTime;
    /* 容积率(一手楼盘) */
    public double volumeRate;
    /* 绿化率(一手楼盘) */
    public double greeningRate;
    /*  层高(一手楼盘) */
    public double storey;
    /*  车位数(一手楼盘) */
    public int parkingNum;
    /*  建筑面积(一手楼盘) */
    public double buildSize;
    /* 物业费(一手楼盘) */
    public double propertyCosts;
    /* 采暖方式(一手楼盘) */
    public String heating1;
    /* 供暖方式(一手楼盘) */
    public String heating;
    /* 楼间距(一手楼盘) */
    public double floorSpace;
    /* 建筑风格(一手楼盘) */
    public String buildingType;
    /* 车位数量(一手楼盘) */
    public int parkingNums;
    /* 外立面材质(一手楼盘) */
    public String facadeMaterial;
    /* 开发商名称(一手楼盘) */
    public String developers;
    /* 物业名称(一手楼盘) */
    public String immobilien;
    /* 楼盘位置(一手楼盘) */
    public String lage;
    /* 楼盘经度坐标点(一手楼盘) */
    public String longitude;
    /* 楼盘纬度坐标点(一手楼盘) */
    public String latitude;
    /* 带看量 */
    public int totalShowing;
    /* 经纬度 */
    public CoordinateBean coordinate;
    /* 最新动态 */
    public String proTrack;
    /* 其它户型推荐 */
    public List<ApartmentImgVoBean> apartmentImgVos;
    /* 缓存用 */
    public String titlepicImg;
    /* 房源编号 */
    public String roomCode;

    @Override
    public String toString() {
        return "HouseDetailBean{" +
                "imgUrlArr=" + imgUrlArr +
                ", roomDescripe='" + roomDescripe + '\'' +
                ", resblockOneName='" + resblockOneName + '\'' +
                ", prodelId='" + prodelId + '\'' +
                ", houseOneId='" + houseOneId + '\'' +
                ", bedroomAmount=" + bedroomAmount +
                ", parlorAmount=" + parlorAmount +
                ", toiletAmount=" + toiletAmount +
                ", gfa=" + gfa +
                ", innenbereichSize=" + innenbereichSize +
                ", resblockType='" + resblockType + '\'' +
                ", unitprBegin=" + unitprBegin +
                ", unitprEnd=" + unitprEnd +
                ", totalprBegin=" + totalprBegin +
                ", totalprEnd=" + totalprEnd +
                ", districtName='" + districtName + '\'' +
                ", circleTypeName='" + circleTypeName + '\'' +
                ", resblockAddr='" + resblockAddr + '\'' +
                ", formType='" + formType + '\'' +
                ", decorationName='" + decorationName + '\'' +
                ", metersPrice=" + metersPrice +
                ", covers=" + covers +
                ", launchTime=" + launchTime +
                ", volumeRate=" + volumeRate +
                ", greeningRate=" + greeningRate +
                ", storey=" + storey +
                ", parkingNum=" + parkingNum +
                ", buildSize=" + buildSize +
                ", propertyCosts=" + propertyCosts +
                ", heating1='" + heating1 + '\'' +
                ", heating='" + heating + '\'' +
                ", floorSpace=" + floorSpace +
                ", buildingType='" + buildingType + '\'' +
                ", parkingNums=" + parkingNums +
                ", facadeMaterial='" + facadeMaterial + '\'' +
                ", developers='" + developers + '\'' +
                ", immobilien='" + immobilien + '\'' +
                ", lage='" + lage + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", totalShowing=" + totalShowing +
                ", coordinate=" + coordinate +
                ", proTrack='" + proTrack + '\'' +
                ", apartmentImgVos=" + apartmentImgVos +
                ", titlepicImg='" + titlepicImg + '\'' +
                ", roomCode='" + roomCode + '\'' +
                '}';
    }
}
