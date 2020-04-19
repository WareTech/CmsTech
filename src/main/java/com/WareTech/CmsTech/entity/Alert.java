package com.WareTech.CmsTech.entity;

import javax.persistence.Entity;

@Entity
public class Alert
    extends AbstractPersistentObject
{
    protected String description;

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}
}
