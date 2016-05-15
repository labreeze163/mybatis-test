package com.mybatis.type;


import java.sql.Timestamp;

/**
 * Created by hzzhaolong on 2016/2/23.
 * 大转盘中奖记录
 */
public class TurnPlateUserAward {

    private String id;             // 记录ID
    private String accountID;     // 用户名
    private String ip;             // 用户IP地址
    private String province;      // 用户省份
    private int lotteryType;     // 抽奖类型 0 呱呱乐  1 大转盘
    private int costPoint;        // 抽奖消耗的积分
    private int awardID;          // 奖品ID
    private String awardName;     // 奖品名称
    private int awardType;       // 奖品类型 1 考拉豆  2 优惠券  3 单品优惠券
    private String awardInfo;     // JSON格式 单品优惠券存商品信息， 实物存实物信息
    private Timestamp createTime;     // 创建时间


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(int lotteryType) {
        this.lotteryType = lotteryType;
    }

    public int getCostPoint() {
        return costPoint;
    }

    public void setCostPoint(int costPoint) {
        this.costPoint = costPoint;
    }

    public int getAwardID() {
        return awardID;
    }

    public void setAwardID(int awardID) {
        this.awardID = awardID;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public int getAwardType() {
        return awardType;
    }

    public void setAwardType(int awardType) {
        this.awardType = awardType;
    }

    public String getAwardInfo() {
        return awardInfo;
    }

    public void setAwardInfo(String awardInfo) {
        this.awardInfo = awardInfo;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("id :" ).append(id).append("\n");
        builder.append("accountID :" ).append(accountID).append("\n");
        builder.append("ip :" ).append(ip).append("\n");
        builder.append("province :" ).append(province).append("\n");
        builder.append("lotteryType :" ).append(lotteryType).append("\n");
        builder.append("costPoint :" ).append(costPoint).append("\n");
        builder.append("awardID :" ).append(awardID).append("\n");
        builder.append("awardName :" ).append(awardName).append("\n");
        builder.append("awardType :" ).append(awardType).append("\n");
        builder.append("awardInfo :" ).append(awardInfo).append("\n");
        builder.append("createTime :" ).append(createTime).append("\n");
        return builder.toString();
    }
}
