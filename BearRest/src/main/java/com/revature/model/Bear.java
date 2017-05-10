package com.revature.model;

import org.springframework.stereotype.Component;

@Component
public class Bear extends Animal {

	/**
	 * 
	 */

	public Bear(String name, int weight, Cave cave) {
		super();
		this.weight = weight;
		this.name = name;
		this.cave = cave;
	}

	public Bear() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int weight;

	public int getWeight() {
		return weight;
	}

	public void setWeight(int w) {
		this.weight = w;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bear other = (Bear) obj;
		if (cave == null) {
			if (other.cave != null)
				return false;
		} else if (!cave.equals(other.cave))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bear [id=" + id + ", name=" + name + ", weight= " + weight + ", cave=" + cave + "]";
	}

}