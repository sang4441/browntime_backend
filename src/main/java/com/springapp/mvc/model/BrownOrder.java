package com.springapp.mvc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class BrownOrder {

	private int id;
    private int seller_id;
    private int type_id;
    private int buyer_id;
    private Date time_requested;
    private int status_id;
    private int price;
    private ArrayList<BrownCart> carts;

    private int type;
	private Date time;
	
//	public BrownOrder() {
//		id = UUID.randomUUID();
//	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<BrownCart> getCarts() {
        return carts;
    }

    public void setCarts(ArrayList<BrownCart> carts) {
        this.carts = carts;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public Date getTime_requested() {
        return time_requested;
    }

    public void setTime_requested(Date time_requested) {
        this.time_requested = time_requested;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
