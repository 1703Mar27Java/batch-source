package com.revature.bean;

import java.io.*;
import java.sql.*;

public class ERS_REIMBURSEMENTS {
	private int R_ID;
	private int R_AMOUNT;
	private String R_DESCRIPTION;
	private InputStream R_RECEIPT;
	private Timestamp R_SUBMITTED;
	private Timestamp R_RESOLVED;
	private int U_ID_AUTHOR;
	private int U_ID_RESOLVER;
	private int RT_TYPE;
	private int RS_STATUS;

	public ERS_REIMBURSEMENTS() {

	}

	public ERS_REIMBURSEMENTS(int R_IDIn) {
		this.R_ID = R_IDIn;
	}

	public int getR_ID() {
		return this.R_ID;
	}

	public void setR_ID(int R_IDIn) {
		this.R_ID = R_IDIn;
	}

	public int getR_AMOUNT() {
		return this.R_AMOUNT;
	}

	public void setR_AMOUNT(int R_AMOUNTIn) {
		this.R_AMOUNT = R_AMOUNTIn;
	}

	public String getR_DESCRIPTION() {
		return this.R_DESCRIPTION;
	}

	public void setR_DESCRIPTION(String R_DESCRIPTIONIn) {
		this.R_DESCRIPTION = R_DESCRIPTIONIn;
	}

	public InputStream getR_RECEIPT() {
		return this.R_RECEIPT;
	}

	public void setR_RECEIPT(InputStream R_RECEIPTIn) {
		this.R_RECEIPT = R_RECEIPTIn;
	}

	public Timestamp getR_SUBMITTED() {
		return this.R_SUBMITTED;
	}

	public void setR_SUBMITTED(Timestamp R_SUBMITTEDIn) {
		this.R_SUBMITTED = R_SUBMITTEDIn;
	}

	public Timestamp getR_RESOLVED() {
		return this.R_RESOLVED;
	}

	public void setR_RESOLVED(Timestamp R_RESOLVEDIn) {
		this.R_RESOLVED = R_RESOLVEDIn;
	}

	public int getU_ID_AUTHOR() {
		return this.U_ID_AUTHOR;
	}

	public void setU_ID_AUTHOR(int U_ID_AUTHORIn) {
		this.U_ID_AUTHOR = U_ID_AUTHORIn;
	}

	public int getU_ID_RESOLVER() {
		return this.U_ID_RESOLVER;
	}

	public void setU_ID_RESOLVER(int U_ID_RESOLVERIn) {
		this.U_ID_RESOLVER = U_ID_RESOLVERIn;
	}

	public int getRT_TYPE() {
		return this.RT_TYPE;
	}

	public void setRT_TYPE(int RT_TYPEIn) {
		this.RT_TYPE = RT_TYPEIn;
	}

	public int getRS_STATUS() {
		return this.RS_STATUS;
	}

	public void setRS_STATUS(int RS_STATUSIn) {
		this.RS_STATUS = RS_STATUSIn;
	}

	public void setAll(int R_IDIn, int R_AMOUNTIn, String R_DESCRIPTIONIn, InputStream R_RECEIPTIn, Timestamp R_SUBMITTEDIn,
			Timestamp R_RESOLVEDIn, int U_ID_AUTHORIn, int U_ID_RESOLVERIn, int RT_TYPEIn, int RS_STATUSIn) {
		this.R_ID = R_IDIn;
		this.R_AMOUNT = R_AMOUNTIn;
		this.R_DESCRIPTION = R_DESCRIPTIONIn;
		this.R_RECEIPT = R_RECEIPTIn;
		this.R_SUBMITTED = R_SUBMITTEDIn;
		this.R_RESOLVED = R_RESOLVEDIn;
		this.U_ID_AUTHOR = U_ID_AUTHORIn;
		this.U_ID_RESOLVER = U_ID_RESOLVERIn;
		this.RT_TYPE = RT_TYPEIn;
		this.RS_STATUS = RS_STATUSIn;
	}

	public boolean hasEqualMapping(ERS_REIMBURSEMENTS valueObject) {

		if (valueObject.getR_ID() != this.R_ID) {
			return (false);
		}
		if (valueObject.getR_AMOUNT() != this.R_AMOUNT) {
			return (false);
		}
		if (this.R_DESCRIPTION == null) {
			if (valueObject.getR_DESCRIPTION() != null)
				return (false);
		} else if (!this.R_DESCRIPTION.equals(valueObject.getR_DESCRIPTION())) {
			return (false);
		}
		if (this.R_RECEIPT == null) {
			if (valueObject.getR_RECEIPT() != null)
				return (false);
		} else if (!this.R_RECEIPT.equals(valueObject.getR_RECEIPT())) {
			return (false);
		}
		if (this.R_SUBMITTED == null) {
			if (valueObject.getR_SUBMITTED() != null)
				return (false);
		} else if (!this.R_SUBMITTED.equals(valueObject.getR_SUBMITTED())) {
			return (false);
		}
		if (this.R_RESOLVED == null) {
			if (valueObject.getR_RESOLVED() != null)
				return (false);
		} else if (!this.R_RESOLVED.equals(valueObject.getR_RESOLVED())) {
			return (false);
		}
		if (valueObject.getU_ID_AUTHOR() != this.U_ID_AUTHOR) {
			return (false);
		}
		if (valueObject.getU_ID_RESOLVER() != this.U_ID_RESOLVER) {
			return (false);
		}
		if (valueObject.getRT_TYPE() != this.RT_TYPE) {
			return (false);
		}
		if (valueObject.getRS_STATUS() != this.RS_STATUS) {
			return (false);
		}

		return true;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("\nclass ERS_REIMBURSEMENTS, mapping to table ERS_REIMBURSEMENTS\n");
		out.append("Persistent attributes: \n");
		out.append("R_ID = " + this.R_ID + "\n");
		out.append("R_AMOUNT = " + this.R_AMOUNT + "\n");
		out.append("R_DESCRIPTION = " + this.R_DESCRIPTION + "\n");
		out.append("R_RECEIPT = " + this.R_RECEIPT + "\n");
		out.append("R_SUBMITTED = " + this.R_SUBMITTED + "\n");
		out.append("R_RESOLVED = " + this.R_RESOLVED + "\n");
		out.append("U_ID_AUTHOR = " + this.U_ID_AUTHOR + "\n");
		out.append("U_ID_RESOLVER = " + this.U_ID_RESOLVER + "\n");
		out.append("RT_TYPE = " + this.RT_TYPE + "\n");
		out.append("RS_STATUS = " + this.RS_STATUS + "\n");
		return out.toString();
	}
}