package com.Revature.domain;

public class User {
	public User() {
		super();
	}
	public User(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}
	private String name;
	private String pass;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", pass=" + pass + "]";
	}
}
