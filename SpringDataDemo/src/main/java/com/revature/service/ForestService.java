package com.revature.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.*;
import com.revature.beans.*;

@Transactional
public class ForestService {
	
	@Autowired 
	BearRepository bearDao;
	
	@Autowired
	CaveRepository caveDao;
	
	@Autowired 
	AnimalRepository animalDao;
	
	public Bear getBearByName(String name) {
		return bearDao.findBearByName(name);
	}


	public Animal getRandomAnimal() {
		
		List<Animal> animals = animalDao.findAll();
		Random random = new Random();
		int index = random.nextInt(animals.size());
		return animals.get(index);}
		
		
}

