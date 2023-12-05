package entity;

import project_enum.CouponType;

import java.time.LocalDateTime;
import java.util.UUID;

public interface Coupon {

    public String csvFormat();

    public String toString();

    public String getCouponID();

    public void setCouponID(String couponID);

    public CouponType getType();

    public void setType(CouponType type);

    public int getPromote();

    public void setPromote(int promote);

    public int getMinConditionMoney();

    public void setMinConditionMoney(int minConditionMoney);

    public int getMaxPromoteMoney();

    public void setMaxPromoteMoney(int maxPromoteMoney);

    public UUID getSellerID();

    public void setSellerID(UUID sellerID);

    public LocalDateTime getEndTime();
}
