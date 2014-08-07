package com.springapp.mvc.model;

/**
 * Created by kimsanghwan on 7/24/2014.
 */
public class BrownBuyer {
    private int buyerId;
    private String buyerName;
    private String buyerCellNumber;
    private int isCertified;
    private int smsNumber;
    private int smsFlag;

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }


    public String getBuyerCellNumber() {
        return buyerCellNumber;
    }

    public void setBuyerCellNumber(String buyerCellNumber) {
        this.buyerCellNumber = buyerCellNumber;
    }


    public int getIsCertified() {
        return isCertified;
    }

    public void setIsCertified(int isCertified) {
        this.isCertified = isCertified;
    }

    public int getSmsNumber() {
        return smsNumber;
    }

    public void setSmsNumber(int smsNumber) {
        this.smsNumber = smsNumber;
    }

    public int getSmsFlag() {
        return smsFlag;
    }

    public void setSmsFlag(int smsFlag) {
        this.smsFlag = smsFlag;
    }
}
