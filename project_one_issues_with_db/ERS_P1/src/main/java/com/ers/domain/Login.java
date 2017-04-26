package com.ers.domain;

public class Login {

	private int lid;
	private String role;
	
	public Login(int lid, String role) {
		// TODO Auto-generated constructor stub
		this.lid = lid;
		this.role = role;
	}



public int getLid() {
	return lid;
}


public void seLUid(int lid) {
	this.lid = lid;
}

public String getRole(){
	return role;
}

public void setRole(String role){
	this.role = role;
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + lid;
	result = prime * result + ((role == null) ? 0 : role.hashCode());
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
	Login other = (Login) obj;
	if (lid != other.lid)
		return false;
	if (role == null) {
		if (other.role != null)
			return false;
	} else if (!role.equals(other.role))
		return false;
	return true;
}



@Override
public String toString() {
	return "Login [lid=" + lid + ", role=" + role + "]";
}




}