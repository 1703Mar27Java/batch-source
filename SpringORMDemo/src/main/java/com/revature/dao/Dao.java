package com.revature.dao;

import com.revature.beans.*;

import java.util.*;

public interface Dao {
	
	public List<Bear> getBears();
	public List<Cave> getCaves();
	
	public void makeBear(Bear bear);

}
