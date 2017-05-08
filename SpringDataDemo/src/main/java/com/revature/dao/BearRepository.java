package com.revature.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Bear;

@Repository
public interface BearRepository extends CrudRepository<Bear,Integer>{
	public Bear findBearByName(String name);
}
