package com.revature.beans;

public class Coffee {
	public Coffee(int id, String flavor, String origin) {
		super();
		this.id = id;
		this.flavor = flavor;
		this.origin = origin;
	}
	private int id;
	private String flavor;
	private String origin;
	@Override
	public String toString() {
		return "Coffee [id=" + id + ", flavor=" + flavor + ", origin=" + origin + "]";
	}
}
