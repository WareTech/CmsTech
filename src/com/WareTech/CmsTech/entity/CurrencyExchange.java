package com.WareTech.CmsTech.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CurrencyExchange
    extends AbstractPersistentObject
{
	@Temporal(TemporalType.DATE)
	protected Date date;
	protected Float amount;
	protected Boolean current;
	
	public Date getDate()
	{
		return date;
	}
	
	public void setDate(Date date) 
	{
		this.date = date;
	}
	
	public Float getAmount()
	{
		return amount;
	}
	
	public void setAmount(Float amount)
	{
		this.amount = amount;
	}
	
	public Boolean getCurrent()
	{
		return current;
	}
	
	public void setCurrent(Boolean current)
	{
		this.current = current;
	}
	
}
