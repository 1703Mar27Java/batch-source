package com.ers.domain;


public class Reimbursements {

	private int rid;
	private double amt;
	private String desc;
	private String receipt;
	private String timestamp;
	private int author;
	private int resolved;
	private int type;
	private int  status;
	
	public Reimbursements(int rid, double amt, String desc, String receipt,
			String timestamp, int author, int resolved, int type, int status) {
		// TODO Auto-generated constructor stub
		this.rid = rid;
		this.amt = amt;
		this.desc = desc;
		this.receipt = receipt;
		this.timestamp = timestamp;
		this.author = author;
		this.resolved = resolved;
		this.type = type;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reimbursements [rid=" + rid + ", amt=" + amt + ", desc=" + desc + ", receipt=" + receipt
				+ ", timestamp=" + timestamp + ", author=" + author + ", resolved=" + resolved + ", type=" + type
				+ ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + author;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((receipt == null) ? 0 : receipt.hashCode());
		result = prime * result + resolved;
		result = prime * result + rid;
		result = prime * result + status;
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + type;
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
		Reimbursements other = (Reimbursements) obj;
		if (Double.doubleToLongBits(amt) != Double.doubleToLongBits(other.amt))
			return false;
		if (author != other.author)
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (receipt == null) {
			if (other.receipt != null)
				return false;
		} else if (!receipt.equals(other.receipt))
			return false;
		if (resolved != other.resolved)
			return false;
		if (rid != other.rid)
			return false;
		if (status != other.status)
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getResolved() {
		return resolved;
	}

	public void setResolved(int resolved) {
		this.resolved = resolved;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
