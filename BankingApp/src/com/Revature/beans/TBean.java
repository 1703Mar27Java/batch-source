package com.Revature.beans;

import java.util.ArrayList;

public class TBean {
	public TBean(ArrayList<Trans> transList) {
		super();
		this.transList = transList;
	}

	private ArrayList<Trans> transList;

	public ArrayList<Trans> getTransList() {
		return transList;
	}

	public void setTransList(ArrayList<Trans> transList) {
		this.transList = transList;
	}

	@Override
	public String toString() {
		return "Bean [transList=" + transList + "]";
	}
}