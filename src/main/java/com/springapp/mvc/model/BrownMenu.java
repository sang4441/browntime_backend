package com.springapp.mvc.model;

import java.util.UUID;

public class BrownMenu {

	private UUID id;
    private int name;
	private int price;
	private int type;
	private String description;

	public BrownMenu() {
		id = UUID.randomUUID();
	}
	
	public BrownMenu(int name, int price, int type) {
		id = UUID.randomUUID();
		name = name;
		price = price;
		type = type;
	}
	
	public BrownMenu(int name, int price, int type, String description) {
		id = UUID.randomUUID();
		name = name;
		price = price;
		type = type;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
