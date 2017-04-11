package com.revature.beans;

import java.io.Serializable;

public class Dog implements Serializable {

	public Dog(int id, String name, String breed) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
	}

	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int id;
	private String name;
	private String breed;

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

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", breed=" + breed + "]";
	}

}
