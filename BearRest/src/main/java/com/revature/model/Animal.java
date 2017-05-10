package com.revature.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.model.Cave;

public class Animal {
	
	protected int id;

	protected String name;
	
	@Autowired
	Cave cave;


	public Cave getCave() {
		return cave;
	}

	public void setCave(Cave cave) {
		this.cave = cave;
	}

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

}
