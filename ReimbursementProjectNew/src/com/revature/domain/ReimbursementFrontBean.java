package com.revature.domain;

import java.sql.Date;

public class ReimbursementFrontBean
{

	private int id;
	private double amount;
	private String description;
	private String receipt;
	private Date submitted;
	private Date resolved;
	private int userAuthorID;
	private int userResolverID;
	private String type;
	private String status;

	
	public ReimbursementFrontBean() 
	{
	}




	public ReimbursementFrontBean(int id, double amount, String description, String receipt, Date submitted, Date resolved,
			int userAuthorID, int userResolverID, String type, String status) 
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
	public String getReceipt() 
	{
		return receipt;
	}
	public void setReceipt(String receipt) 
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
	public String getType() 
	{
		return type;
	}
	public void setType(String type) 
	{
		this.type = type;
	}
	public String getStatus() 
	{
		return status;
	}
	public void setStatus(String status) 
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