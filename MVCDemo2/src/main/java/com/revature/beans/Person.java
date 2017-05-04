package com.revature.beans;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

import javax.validation.constraints.*;

@Component(value="person")
public class Person {
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message="please enter your date of birth")
	@Past(message="that's impossible")
	private Date dateOfBirth;
	@NotNull(message="please enter your first name")
	private String firstName;
	@NotNull(message="please enter your last name")
	private String lastName;
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}
