package com.revature.dao;

import java.util.ArrayList;

import com.revature.bean.Request;

public interface RequestDAO {
	public ArrayList<Request> fetchReqs(String uName) ;
	public void createReq(String descr, double amt, String uName, String rType);
	public void resolveReq(int rid, String status, String mgr);
}
