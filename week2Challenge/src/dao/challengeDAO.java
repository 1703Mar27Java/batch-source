package dao;

import java.util.ArrayList;

import domain.Department;

public interface challengeDAO {
	public ArrayList<Department> getDepartments();
	public void callRaise(int id, double raise);
}
