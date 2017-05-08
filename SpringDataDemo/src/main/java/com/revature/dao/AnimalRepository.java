package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Integer>{
}
