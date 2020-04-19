package com.WareTech.CmsTech.entity;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AlertUser
    extends AbstractPersistentObject
{
	protected Time date;
	@ManyToOne
	@JoinColumn(name="alertId")
	protected Alert alert;
	@ManyToOne
	@JoinColumn(name="userId")
	protected User user;
	public Alert getAlert() {
		return alert;
	}
	public void setAlert(Alert alert) {
		this.alert = alert;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Time getDate() {
		return date;
	}
	public void setDate(Time date) {
		this.date = date;
	}
}
