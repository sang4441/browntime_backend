package com.springapp.mvc.model;


public class BrownCart extends BrownMenu {

    private int priceTotal;
    private int quantity;
    private String instruction;

    public BrownCart() {
		super();
        quantity = 1;
    }
	
	public BrownCart(int name, int price, int type) {
//		super(name, price, type);
	}
	
//	public int getTotalPrice() {
//		return quantity * this.getPrice();
//	}


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }


    public int getPriceTotal() {
        return quantity * this.getPrice();
    }

//    public void setPriceTotal(int priceTotal) {
//        this.priceTotal = priceTotal;
//    }

}
