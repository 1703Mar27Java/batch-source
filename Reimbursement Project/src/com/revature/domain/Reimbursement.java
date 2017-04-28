package com.revature.domain;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Reimbursement {
	private int reimbursementId;
	private int reimbursementAmount;
	private String reimbursementDescription;
	private String reimbursementReceipt;
	private String reimbursementSubmitDate;
	private String reimbursementResolveDate;
	private int employeeAuthor;
	private int employeeResolver;
	private Status reimbursementStatus;
	private Type reimbursementType;
	private String fileName;
	private byte[] image;

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int reimbursementId, int reimbursementAmount, String reimbursementDescription,
			String reimbursementReceipt, String reimbursementSubmitDate, String reimbursementResolveDate,
			int employeeAuthor, int employeeResolver, Status reimbursementStatus, Type reimbursementType) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementDescription = reimbursementDescription;
		this.reimbursementReceipt = reimbursementReceipt;
		this.reimbursementSubmitDate = reimbursementSubmitDate;
		this.reimbursementResolveDate = reimbursementResolveDate;
		this.employeeAuthor = employeeAuthor;
		this.employeeResolver = employeeResolver;
		this.reimbursementStatus = reimbursementStatus;
		this.reimbursementType = reimbursementType;
	}

	public Reimbursement(int reimbursementAmount, String reimbursementDescription, String reimbursementReceipt,
			String reimbursementSubmitDate, String reimbursementResolveDate, int employeeAuthor, int employeeResolver,
			Status reimbursementStatus, Type reimbursementType) {
		super();
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementDescription = reimbursementDescription;
		this.reimbursementReceipt = reimbursementReceipt;
		this.reimbursementSubmitDate = reimbursementSubmitDate;
		this.reimbursementResolveDate = reimbursementResolveDate;
		this.employeeAuthor = employeeAuthor;
		this.employeeResolver = employeeResolver;
		this.reimbursementStatus = reimbursementStatus;
		this.reimbursementType = reimbursementType;
	}

	public Reimbursement(int reimbursementId, int reimbursementAmount, String reimbursementDescription,
			String reimbursementReceipt, String reimbursementSubmitDate, String reimbursementResolveDate,
			int employeeAuthor, int employeeResolver, Status reimbursementStatus, Type reimbursementType,
			String fileName, byte[] image) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementDescription = reimbursementDescription;
		this.reimbursementReceipt = reimbursementReceipt;
		this.reimbursementSubmitDate = reimbursementSubmitDate;
		this.reimbursementResolveDate = reimbursementResolveDate;
		this.employeeAuthor = employeeAuthor;
		this.employeeResolver = employeeResolver;
		this.reimbursementStatus = reimbursementStatus;
		this.reimbursementType = reimbursementType;
		this.fileName = fileName;
		this.image = image;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getReimbursementAmount() {
		return reimbursementAmount;
	}

	public void setReimbursementAmount(int reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}

	public String getReimbursementDescription() {
		return reimbursementDescription;
	}

	public void setReimbursementDescription(String reimbursementDescription) {
		this.reimbursementDescription = reimbursementDescription;
	}

	public String getReimbursementReceipt() {
		return reimbursementReceipt;
	}

	public void setReimbursementReceipt(String reimbursementReceipt) {
		this.reimbursementReceipt = reimbursementReceipt;
	}

	public int getEmployeeAuthor() {
		return employeeAuthor;
	}

	public void setEmployeeAuthor(int employeeAuthor) {
		this.employeeAuthor = employeeAuthor;
	}

	public int getEmployeeResolver() {
		return employeeResolver;
	}

	public void setEmployeeResolver(int employeeResolver) {
		this.employeeResolver = employeeResolver;
	}

	public Status getReimbursementStatus() {
		return reimbursementStatus;
	}

	public void setReimbursementStatus(Status reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}

	public Type getReimbursementType() {
		return reimbursementType;
	}

	public void setReimbursementType(Type reimbursementType) {
		this.reimbursementType = reimbursementType;
	}

	public String getReimbursementSubmitDate() {
		return reimbursementSubmitDate;
	}

	public void setReimbursementSubmitDate(String reimbursementSubmitDate) {
		this.reimbursementSubmitDate = reimbursementSubmitDate;
	}

	public String getReimbursementResolveDate() {
		return reimbursementResolveDate;
	}

	public void setReimbursementResolveDate(String reimbursementResolveDate) {
		this.reimbursementResolveDate = reimbursementResolveDate;
	}

	public String getEncodedImage()
	{
		String img = null;
		
		try{
			img = new String(Base64.getEncoder().encode(getImage()), "UTF-8");
		}
		catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return img;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", reimbursementAmount=" + reimbursementAmount
				+ ", reimbursementDescription=" + reimbursementDescription + ", reimbursementReceipt="
				+ reimbursementReceipt + ", reimbursementSubmitDate=" + reimbursementSubmitDate
				+ ", reimbursementResolveDate=" + reimbursementResolveDate + ", employeeAuthor=" + employeeAuthor
				+ ", employeeResolver=" + employeeResolver + ", reimbursementStatus=" + reimbursementStatus
				+ ", reimbursementType=" + reimbursementType + "]";
	}

}
