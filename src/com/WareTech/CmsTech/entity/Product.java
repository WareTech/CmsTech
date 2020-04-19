package com.WareTech.CmsTech.entity;

import javax.persistence.Entity;

@Entity
public class Product
    extends AbstractPersistentObject
{
	final static public String AVAILABILITY_48HS = "48hs";
	final static public String AVAILABILITY_72HS = "72hs";
	
	protected String name;
	protected String description;
	protected Float price;
	protected Integer discount;
	protected String availability;
	protected Integer stock;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
}
