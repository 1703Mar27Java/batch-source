package com.revature.dao;

import java.util.List;

import com.revature.domain.Cave;

public interface CaveDAO {
public void createCave(Cave cave);
public Cave retrieveCaveById(int id);
public List<Cave> retrieveAllCaves();
public void updateCave(Cave cave);
public void deleteCave(int id);
}
