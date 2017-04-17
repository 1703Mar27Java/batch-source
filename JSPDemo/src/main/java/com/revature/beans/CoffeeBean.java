package com.revature.beans;
public class CoffeeBean {
private int id;
private int caffeineLevel;
private String whereGrown;
private String name;
@Override
public String toString() {
	return "CoffeeBean [id=" + id + ", caffeineLevel=" + caffeineLevel + ", whereGrown=" + whereGrown + ", name=" + name
			+ "]";
}
public CoffeeBean() {
	super();
	// TODO Auto-generated constructor stub
}
public CoffeeBean(int id,  String name, int caffeineLevel, String whereGrown) {
	super();
	this.id = id;
	this.caffeineLevel = caffeineLevel;
	this.whereGrown = whereGrown;
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getCaffeineLevel() {
	return caffeineLevel;
}
public void setCaffeineLevel(int caffeineLevel) {
	this.caffeineLevel = caffeineLevel;
}
public String getWhereGrown() {
	return whereGrown;
}
public void setWhereGrown(String whereGrown) {
	this.whereGrown = whereGrown;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}
