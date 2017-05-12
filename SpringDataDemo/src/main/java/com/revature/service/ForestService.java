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
	
	public List<Cave> getCaves(){
		return caveDao.findAll();
	}
	
	public List<Bear> getBears(){
		return (List<Bear>) bearDao.findAll();
	}
	
	public List<Animal> getAnimals(){
		return animalDao.findAll();
	}
	
	public Bear getBearByName(String name) {
		return bearDao.findBearByName(name);
	}
	
	public Cave getCaveByName(String name){
		return caveDao.findBearByName(name);
	}


	public Animal getRandomAnimal() {
		
		List<Animal> animals = animalDao.findAll();
		Random random = new Random();
		int index = random.nextInt(animals.size());
		return animals.get(index);}
		
	public boolean addBear(Bear bear){
		return (bearDao.save(bear) != null);
	}
	
	public boolean addCave(Cave cave){
		return (caveDao.save(cave) != null);
	}

	public boolean deleteCave(int id) {
		try {
			Cave newCave = caveDao.findCaveById(id);
			caveDao.delete(newCave);
			return true;
		}catch (Exception e){
			return false;
		}
	}
		
}

