package com.ers.domain;

public class Employee {

	private int uid;
	private String un;
	private String pw;
	private String fn;
	private String ln;
	private String email;
	private int urid;
	

	public Employee(int uid, String un, 
	String pw, String fn, String ln, String email, int urid) {
		// TODO Auto-generated constructor stub
		this.uid = uid;
		this.un = un;
		this.pw = pw;
		this.fn = fn;
		this.ln = ln;
		this.email = email;
		this.urid = urid;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getUn() {
		return un;
	}


	public void setUn(String un) {
		this.un = un;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getFn() {
		return fn;
	}


	public void setFn(String fn) {
		this.fn = fn;
	}


	public String getLn() {
		return ln;
	}


	public void setLn(String ln) {
		this.ln = ln;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getUrid() {
		return urid;
	}


	public void setUrid(int urid) {
		this.urid = urid;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fn == null) ? 0 : fn.hashCode());
		result = prime * result + ((ln == null) ? 0 : ln.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		result = prime * result + uid;
		result = prime * result + ((un == null) ? 0 : un.hashCode());
		result = prime * result + urid;
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
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fn == null) {
			if (other.fn != null)
				return false;
		} else if (!fn.equals(other.fn))
			return false;
		if (ln == null) {
			if (other.ln != null)
				return false;
		} else if (!ln.equals(other.ln))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		if (uid != other.uid)
			return false;
		if (un == null) {
			if (other.un != null)
				return false;
		} else if (!un.equals(other.un))
			return false;
		if (urid != other.urid)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Employee [uid=" + uid + ", un=" + un + ", pw=" + pw + ", fn=" + fn + ", ln=" + ln + ", email=" + email
				+ ", urid=" + urid + ", getUid()=" + getUid() + ", getUn()=" + getUn() + ", getPw()=" + getPw()
				+ ", getFn()=" + getFn() + ", getLn()=" + getLn() + ", getEmail()=" + getEmail() + ", getUrid()="
				+ getUrid() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
