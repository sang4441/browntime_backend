package com.springapp.mvc.model;


public class BrownCart extends BrownMenu {

	private int mPriceTotal;
    private int quantity;

    private String instruction;

    public BrownCart() {
		super();
        quantity = 1;

    }
	
	public BrownCart(int name, int price, int type) {
		super(name, price, type);
	}
	
	public int getTotalPrice() {
		return this.getQuantity() * this.getPrice();
	}


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

}
