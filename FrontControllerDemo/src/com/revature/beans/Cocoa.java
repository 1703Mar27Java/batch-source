package com.revature.beans;

public class Cocoa {
private int id;
private String flavor;
private String origin;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFlavor() {
	return flavor;
}
public void setFlavor(String flavor) {
	this.flavor = flavor;
}
public String getOrigin() {
	return origin;
}
public void setOrigin(String origin) {
	this.origin = origin;
}
public Cocoa(int id, String flavor, String origin) {
	super();
	this.id = id;
	this.flavor = flavor;
	this.origin = origin;
}
public Cocoa() {
	super();
	// TODO Auto-generated constructor stub
}

}
