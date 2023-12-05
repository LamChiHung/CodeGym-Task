package entity.coupon_imp;

import entity.Coupon;
import project_enum.CouponType;

import java.time.LocalDateTime;
import java.util.UUID;

public class CouponMoney implements Coupon {

    String couponID;
    UUID sellerID;
    CouponType type;
    int promote;
    int minConditionMoney;
    int maxPromoteMoney;
    LocalDateTime startTime;
    long dayDuration;
    LocalDateTime endTime;

    public CouponMoney(String couponID, UUID sellerID, int promote, int minConditionMoney, int maxPromoteMoney, long dayDuration) {
        this.couponID = couponID;
        this.sellerID = sellerID;
        this.type = CouponType.MONEY;
        this.promote = promote;
        this.minConditionMoney = minConditionMoney;
        this.maxPromoteMoney = maxPromoteMoney;
        this.dayDuration = dayDuration;
        this.startTime = LocalDateTime.now();
        this.endTime = startTime.plusDays(dayDuration);
    }

    public CouponMoney(String couponID, UUID sellerID, CouponType type, int promote, int minConditionMoney, int maxPromoteMoney, LocalDateTime startTime, long dayDuration, LocalDateTime endTime) {
        this.couponID = couponID;
        this.sellerID = sellerID;
        this.type = type;
        this.promote = promote;
        this.minConditionMoney = minConditionMoney;
        this.maxPromoteMoney = maxPromoteMoney;
        this.startTime = startTime;
        this.dayDuration = dayDuration;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "CouponMoney{" +
                "couponID='" + couponID + '\'' +
                ", sellerID=" + sellerID +
                ", type=" + type +
                ", promote=" + promote +
                ", minConditionMoney=" + minConditionMoney +
                ", maxPromoteMoney=" + maxPromoteMoney +
                ", startTime=" + startTime +
                ", dayDuration=" + dayDuration +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public String csvFormat() {
        String csvFormat = "%s,%s,%s,%d,%d,%d,%s,%d,%s";
        return String.format(csvFormat, couponID, sellerID.toString(), type, promote, minConditionMoney, maxPromoteMoney, startTime.toString(), dayDuration, endTime.toString());
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public long getDayDuration() {
        return dayDuration;
    }

    public void setDayDuration(long dayDuration) {
        this.dayDuration = dayDuration;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public UUID getSellerID() {
        return sellerID;
    }

    public void setSellerID(UUID sellerID) {
        this.sellerID = sellerID;
    }

    public String getCouponID() {
        return couponID;
    }

    public void setCouponID(String couponID) {
        this.couponID = couponID;
    }

    public CouponType getType() {
        return type;
    }

    public void setType(CouponType type) {
        this.type = type;
    }

    public int getPromote() {
        return promote;
    }

    public void setPromote(int promote) {
        this.promote = promote;
    }

    public int getMinConditionMoney() {
        return minConditionMoney;
    }

    public void setMinConditionMoney(int minConditionMoney) {
        this.minConditionMoney = minConditionMoney;
    }

    public int getMaxPromoteMoney() {
        return maxPromoteMoney;
    }

    public void setMaxPromoteMoney(int maxPromoteMoney) {
        this.maxPromoteMoney = maxPromoteMoney;
    }

}
