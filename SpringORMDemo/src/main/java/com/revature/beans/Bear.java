package com.revature.beans;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@NamedQueries({ @NamedQuery(name = "findBearByName", query = "from Bear where name = :namevar") })

@Component
@Entity
@Table(name = "BEAR")
@AttributeOverrides({
	@AttributeOverride(name="id",column=@Column(name="BEAR_ID")),
	@AttributeOverride(name="name",column=@Column(name="BEAR_NAME")),
	@AttributeOverride(name="cave",column=@Column(name="BEAR_CAVE"))
})
public class Bear extends Animal implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1671056424943086535L;

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

	@Column(name = "BEAR_WEIGHT")
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
