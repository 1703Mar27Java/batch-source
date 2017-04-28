package com.revature.domain;

import java.sql.Blob;
import java.sql.Date;

public class ReimbursementBackBean
{

	private int id;
	private double amount;
	private String description;
	private Blob receipt;
	private Date submitted;
	private Date resolved;
	private int userAuthorID;
	private int userResolverID;
	private int type;
	private int status;

	
	public ReimbursementBackBean() 
	{
	}




	public ReimbursementBackBean(int id, double amount, String description, Blob receipt, Date submitted, Date resolved,
			int userAuthorID, int userResolverID, int type, int status) 
	{
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.userAuthorID = userAuthorID;
		this.userResolverID = userResolverID;
		this.type = type;
		this.status = status;
	}




	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public double getAmount() 
	{
		return amount;
	}
	public void setAmount(double amount) 
	{
		this.amount = amount;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	public Blob getReceipt() 
	{
		return receipt;
	}
	public void setReceipt(Blob receipt) 
	{
		this.receipt = receipt;
	}
	public Date getSubmitted() 
	{
		return submitted;
	}
	public void setSubmitted(Date submitted) 
	{
		this.submitted = submitted;
	}
	public Date getResolved() 
	{
		return resolved;
	}
	public void setResolved(Date resolved) 
	{
		this.resolved = resolved;
	}
	public int getUserAuthorID() 
	{
		return userAuthorID;
	}
	public void setUserAuthorID(int userAuthorID) 
	{
		this.userAuthorID = userAuthorID;
	}
	public int getUserResolverID() 
	{
		return userResolverID;
	}
	public void setUserResolverID(int userResolverID) 
	{
		this.userResolverID = userResolverID;
	}
	public int getType() 
	{
		return type;
	}
	public void setType(int type) 
	{
		this.type = type;
	}
	public int getStatus() 
	{
		return status;
	}
	public void setStatus(int status) 
	{
		this.status = status;
	}




	@Override
	public String toString() 
	{
		return "Reimbursement [id=" + id + ", amount=" + amount + ", description=" + description + ", receipt="
				+ receipt + ", submitted=" + submitted + ", resolved=" + resolved + ", userAuthorID=" + userAuthorID
				+ ", userResolverID=" + userResolverID + ", type=" + type + ", status=" + status + "]";
	}
	
}