package com.revature.dao;

import java.util.List;

import com.revature.beans.Cocoa;

public interface CocoaDAO {
public Cocoa getBeanById(int id);
public List<Cocoa> getBeans();
}
