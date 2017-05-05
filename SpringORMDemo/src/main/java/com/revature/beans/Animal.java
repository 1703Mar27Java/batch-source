package com.revature.beans;

import javax.persistence.*;
import java.io.*;

@Entity
@Table(name="ANIMAL")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Animal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5004356865417698365L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animSeq")
	@SequenceGenerator(allocationSize = 1, name = "animSeq", sequenceName = "ANIM_SEQ")
	@Column(name = "ANIMAL_ID")
	protected int id;

	@Column(name = "ANIMAL_NAME")
	protected String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ANIMAL_CAVE")
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
