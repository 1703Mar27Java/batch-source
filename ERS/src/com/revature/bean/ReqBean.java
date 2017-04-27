package com.revature.bean;

import java.util.ArrayList;


public class ReqBean {
	public ReqBean(ArrayList<Request> reqList) {
		super();
		this.reqList = reqList;
	}

	private ArrayList<Request> reqList;

	public ArrayList<Request> getReqList() {
		return reqList;
	}

	public void setReqList(ArrayList<Request> reqList) {
		this.reqList = reqList;
	}

	@Override
	public String toString() {
		return "ReqBean [reqList=" + reqList + "]";
	}
}
