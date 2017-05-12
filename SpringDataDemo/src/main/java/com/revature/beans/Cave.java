package com.revature.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="CAVE")
public class Cave implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8738231608587314500L;

	public Cave(String name) {
		super();
		this.name = name;
	}

	public Cave() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="caveSeq")
	@SequenceGenerator(allocationSize=1,name="caveSeq",sequenceName="CAVE_SEQ")
	@Column(name="CAVE_ID")
	private int id;
	
	@Column(name="CAVE_NAME")
	private String name;
	
	/*@OneToMany(mappedBy="cave",fetch=FetchType.EAGER)
	List<Animal> occupants;*/

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

	/*public List<Animal> getOccupants() {
		return occupants;
	}

	public void setOccupants(List<Animal> occupants) {
		this.occupants = occupants;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		//result = prime * result + ((occupants == null) ? 0 : occupants.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cave other = (Cave) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		/*if (occupants == null) {
			if (other.occupants != null)
				return false;
		} else if (!occupants.equals(other.occupants))
			return false;*/
		return true;
	}

	@Override
	public String toString() {
		return "Cave [id=" + id + ", name=" + name;
	}
 
}