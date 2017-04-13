package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Cocoa;
import com.revature.beans.Coffee;

public class CoffeeDAOImpl implements CoffeeDAO{
	
	private static List<Coffee> beanList = new ArrayList<>();
	static {
		beanList.add(new Coffee(1,"coffee","Sumatra"));
		beanList.add(new Coffee(2,"coffee","Colombia"));
		beanList.add(new Coffee(3,"coffee","Brazil"));
	}

	@Override
	public Coffee getBeanById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coffee> getBeans() {
		// TODO Auto-generated method stub
		return beanList;
	}

}
