package com.revature.dao;
	
import java.util.List;

import one.to.many.*;

public interface DAO {
	
	public List<Cave> getCaves();
	public List<Bear> getBears();
	public Bear getBearByName(String name);
	public int saveBear(Bear b);
	public void persistBear(Bear b);
	public int saveCave(Cave c);
	public void persistCave(Cave c);
	public int feedBear(int bId, int bhId, int honeyAmt);
	

}
