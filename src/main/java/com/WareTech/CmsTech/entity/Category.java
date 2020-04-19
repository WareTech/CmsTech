package com.WareTech.CmsTech.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Category
    extends AbstractPersistentObject
{
    protected String name;
    @ManyToOne
    @JoinColumn(name="parentId")
    protected Category parent;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}
    
}
