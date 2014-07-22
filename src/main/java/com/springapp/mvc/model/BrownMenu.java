package com.springapp.mvc.model;

import java.util.UUID;

public class BrownMenu {

	private int id;
    private String name;
	private int price;
	private int category;
	private String description;
    private String imageURL;

//	public BrownMenu() {
//		id = UUID.randomUUID();
//	}
//
//	public BrownMenu(int name, int price, int category) {
//		id = UUID.randomUUID();
//		name = name;
//		price = price;
//        category = category;
//	}
//
//	public BrownMenu(int name, int price, int category, String description) {
//		id = UUID.randomUUID();
//		name = name;
//		price = price;
//        category = category;
//		description = description;
//	}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
