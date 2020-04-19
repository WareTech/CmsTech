package com.WareTech.CmsTech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Section
    extends AbstractPersistentObject
{
	final static public String STATE_DRAFT = "DRAFT";
	final static public String STATE_AVAILABLE = "AVAILABLE";
	final static public String STATE_DELETED = "DELETED";
	
	protected String name;
	protected Boolean visible;
	@Column(name = "order_")
	protected Integer order;
	protected String state;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
