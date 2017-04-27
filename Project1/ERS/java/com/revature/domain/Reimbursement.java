package com.revature.domain;

import java.io.InputStream;

public class Reimbursement {

	private int id;
	private double amount;
	private String description;
	private InputStream receipt;
	private String submitted;
	private String resolved;
	private String author;
	private String resolver;
	private String type;
	private String status;
	private byte[] pic;
	
	public Reimbursement() {
		super();
	}
	
	public Reimbursement(int id, double amount, String description, InputStream receipt, String submitted, String resolved, String author,
			String resolver, String type, String status) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.author = author;
		this.resolver = resolver;
		this.type = type;
		this.status = status;
	}
	
	public Reimbursement( double amount, String description, InputStream receipt, String submitted, String resolved, String author,
			String resolver, String type, String status) {
		super();
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.author = author;
		this.resolver = resolver;
		this.type = type;
		this.status = status;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public InputStream getReceipt() {
		return receipt;
	}

	public void setReceipt(InputStream receipt) {
		this.receipt = receipt;
	}

	
	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getResolver() {
		return resolver;
	}

	public void setResolver(String resolver) {
		this.resolver = resolver;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", receipt=" + receipt + ", submitted=" + submitted
				+ ", resolved=" + resolved + ", author=" + author + ", resolver=" + resolver + ", type=" + type
				+ ", status=" + status + "]";
	}

		

}
