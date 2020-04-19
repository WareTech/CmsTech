package com.WareTech.CmsTech.entity;

import javax.persistence.Entity;

@Entity
public class Label
    extends AbstractPersistentObject
{
    protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
