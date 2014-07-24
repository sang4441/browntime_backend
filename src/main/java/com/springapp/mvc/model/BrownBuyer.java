package com.springapp.mvc.model;

/**
 * Created by kimsanghwan on 7/24/2014.
 */
public class BrownBuyer {
    private int buyerId;
    private String buyerName;
    private int buyerCellNumber;

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

    public int getBuyerCellNumber() {
        return buyerCellNumber;
    }

    public void setBuyerCellNumber(int buyerCellNumber) {
        this.buyerCellNumber = buyerCellNumber;
    }
}
