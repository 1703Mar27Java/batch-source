package com.revature.beans;

public class CoffeeBean {
	public CoffeeBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CoffeeBean(int id, String name, int caffeineLevel, String whereGrown) {
		super();
		this.id = id;
		this.name = name;
		this.caffeineLevel = caffeineLevel;
		this.whereGrown = whereGrown;
	}

	private int id;
	private String name;
	private int caffeineLevel;
	private String whereGrown;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "CoffeeBean [id=" + id + ", name=" + name + ", caffeineLevel=" + caffeineLevel + ", whereGrown="
				+ whereGrown + "]";
	}
}
