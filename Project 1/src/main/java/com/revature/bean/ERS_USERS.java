package com.revature.bean;

public class ERS_USERS {
	private int U_ID;
	private String U_USERNAME;
	private String U_PASSWORD;
	private String U_FIRSTNAME;
	private String U_LASTNAME;
	private String U_EMAIL;
	private int UR_ID;

	public ERS_USERS() {

	}

	public ERS_USERS(int U_IDIn) {
		this.U_ID = U_IDIn;
	}

	public int getU_ID() {
		return this.U_ID;
	}

	public void setU_ID(int U_IDIn) {
		this.U_ID = U_IDIn;
	}

	public String getU_USERNAME() {
		return this.U_USERNAME;
	}

	public void setU_USERNAME(String U_USERNAMEIn) {
		this.U_USERNAME = U_USERNAMEIn;
	}

	public String getU_PASSWORD() {
		return this.U_PASSWORD;
	}

	public void setU_PASSWORD(String U_PASSWORDIn) {
		this.U_PASSWORD = U_PASSWORDIn;
	}

	public String getU_FIRSTNAME() {
		return this.U_FIRSTNAME;
	}

	public void setU_FIRSTNAME(String U_FIRSTNAMEIn) {
		this.U_FIRSTNAME = U_FIRSTNAMEIn;
	}

	public String getU_LASTNAME() {
		return this.U_LASTNAME;
	}

	public void setU_LASTNAME(String U_LASTNAMEIn) {
		this.U_LASTNAME = U_LASTNAMEIn;
	}

	public String getU_EMAIL() {
		return this.U_EMAIL;
	}

	public void setU_EMAIL(String U_EMAILIn) {
		this.U_EMAIL = U_EMAILIn;
	}

	public int getUR_ID() {
		return this.UR_ID;
	}

	public void setUR_ID(int UR_IDIn) {
		this.UR_ID = UR_IDIn;
	}

	public void setAll(int U_IDIn, String U_USERNAMEIn, String U_PASSWORDIn, String U_FIRSTNAMEIn, String U_LASTNAMEIn,
			String U_EMAILIn, int UR_IDIn) {
		this.U_ID = U_IDIn;
		this.U_USERNAME = U_USERNAMEIn;
		this.U_PASSWORD = U_PASSWORDIn;
		this.U_FIRSTNAME = U_FIRSTNAMEIn;
		this.U_LASTNAME = U_LASTNAMEIn;
		this.U_EMAIL = U_EMAILIn;
		this.UR_ID = UR_IDIn;
	}

	public boolean hasEqualMapping(ERS_USERS valueObject) {

		if (valueObject.getU_ID() != this.U_ID) {
			return (false);
		}
		if (this.U_USERNAME == null) {
			if (valueObject.getU_USERNAME() != null)
				return (false);
		} else if (!this.U_USERNAME.equals(valueObject.getU_USERNAME())) {
			return (false);
		}
		if (this.U_PASSWORD == null) {
			if (valueObject.getU_PASSWORD() != null)
				return (false);
		} else if (!this.U_PASSWORD.equals(valueObject.getU_PASSWORD())) {
			return (false);
		}
		if (this.U_FIRSTNAME == null) {
			if (valueObject.getU_FIRSTNAME() != null)
				return (false);
		} else if (!this.U_FIRSTNAME.equals(valueObject.getU_FIRSTNAME())) {
			return (false);
		}
		if (this.U_LASTNAME == null) {
			if (valueObject.getU_LASTNAME() != null)
				return (false);
		} else if (!this.U_LASTNAME.equals(valueObject.getU_LASTNAME())) {
			return (false);
		}
		if (this.U_EMAIL == null) {
			if (valueObject.getU_EMAIL() != null)
				return (false);
		} else if (!this.U_EMAIL.equals(valueObject.getU_EMAIL())) {
			return (false);
		}
		if (valueObject.getUR_ID() != this.UR_ID) {
			return (false);
		}

		return true;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("\nclass ERS_USERS, mapping to table ERS_USERS\n");
		out.append("Persistent attributes: \n");
		out.append("U_ID = " + this.U_ID + "\n");
		out.append("U_USERNAME = " + this.U_USERNAME + "\n");
		out.append("U_PASSWORD = " + this.U_PASSWORD + "\n");
		out.append("U_FIRSTNAME = " + this.U_FIRSTNAME + "\n");
		out.append("U_LASTNAME = " + this.U_LASTNAME + "\n");
		out.append("U_EMAIL = " + this.U_EMAIL + "\n");
		out.append("UR_ID = " + this.UR_ID + "\n");
		return out.toString();
	}

}