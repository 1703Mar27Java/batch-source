package com.revature.dao;

import java.util.List;

import com.revature.beans.Coffee;

public interface CoffeeDAO {
	public Coffee getBeanById(int id);
	public List<Coffee> getBeans();
}
