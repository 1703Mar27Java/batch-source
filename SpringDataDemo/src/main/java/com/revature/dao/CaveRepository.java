package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Cave;

@Repository
public interface CaveRepository extends JpaRepository<Cave,Integer>{
}
