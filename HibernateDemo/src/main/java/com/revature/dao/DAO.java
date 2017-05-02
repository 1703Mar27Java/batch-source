package com.revature.dao;
	
import java.util.List;

import one.to.many.*;

public interface DAO {
	
	public List<Cave> getCaves();
	public List<Bear> getBears();
	public Bear getBearByName(String name);

}
