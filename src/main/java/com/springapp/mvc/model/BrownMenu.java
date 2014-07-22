package com.springapp.mvc.model;

import java.util.UUID;

public class BrownMenu {

	private UUID id;
    private int name;
	private int price;
	private int category;
	private String description;

	public BrownMenu() {
		id = UUID.randomUUID();
	}
	
	public BrownMenu(int name, int price, int category) {
		id = UUID.randomUUID();
		name = name;
		price = price;
        category = category;
	}
	
	public BrownMenu(int name, int price, int category, String description) {
		id = UUID.randomUUID();
		name = name;
		price = price;
        category = category;
		description = description;
	}


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
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
