package com.revature.bean;

import java.sql.Timestamp;

public class Request {
	public Request(int r_id, String descr, Timestamp timeSubmitted, Timestamp timeResolved, String type, String status,
			String username, String firstName, String lastName, double amount) {
		super();
		this.r_id = r_id;
		this.descr = descr;
		this.timeSubmitted = timeSubmitted;
		this.timeResolved = timeResolved;
		this.type = type;
		this.status = status;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.amount = amount;
	}
	private int r_id;
	private String descr, type, status, username, firstName, lastName;
	private Timestamp timeSubmitted, timeResolved;
	private double amount;
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Timestamp getTimeSubmitted() {
		return timeSubmitted;
	}
	public void setTimeSubmitted(Timestamp timeSubmitted) {
		this.timeSubmitted = timeSubmitted;
	}
	public Timestamp getTimeResolved() {
		return timeResolved;
	}
	public void setTimeResolved(Timestamp timeResolved) {
		this.timeResolved = timeResolved;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Request [r_id=" + r_id + ", descr=" + descr + ", timeSubmitted=" + timeSubmitted + ", timeResolved="
				+ timeResolved + ", type=" + type + ", status=" + status + ", username=" + username + ", firstName="
				+ firstName + ", lastName=" + lastName + ", amount=" + amount + "]";
	}
}
