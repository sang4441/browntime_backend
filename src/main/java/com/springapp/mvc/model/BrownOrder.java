package com.springapp.mvc.model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class BrownOrder extends BrownBuyer {

    private int id;
    private int sellerId;
    private int typeId;
    private String typeName;
    private int price;
//    private int buyerId;
    private Date timeRequested;
    private String address;
    private int duration;
    private int statusId;
    private String statusName;
    private List<BrownCart> carts;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

//    public int getBuyerId() {
//        return buyerId;
//    }
//
//    public void setBuyerId(int buyerId) {
//        this.buyerId = buyerId;
//    }

    public Date getTimeRequested() {
        return timeRequested;
    }

    public void setTimeRequested(Date timeRequested) {
        this.timeRequested = timeRequested;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<BrownCart> getCarts() {
        return carts;
    }

    public void setCarts(List<BrownCart> carts) {
        this.carts = carts;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
