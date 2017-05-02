package com.revature.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.revature.beans.Cocoa;

public class CocoaDAOImpl implements CocoaDAO {
	
	private static List<Cocoa> beanList = new ArrayList<>();
	static {
		beanList.add(new Cocoa(1,"chocolate","Colombia"));
		beanList.add(new Cocoa(2,"chocolate","Peru"));
		beanList.add(new Cocoa(3,"chocolate","Ivory Coast"));
	}
	

	@Override
	public Cocoa getBeanById(int id) {
		return CocoaDAOImpl.beanList.get(id);
	}

	@Override
	public List<Cocoa> getBeans() {
		return this.beanList;
	}

}
