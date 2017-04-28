package com.revature.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.*;

import com.revature.beans.Reimbursements;

import com.revature.beans.User;

public class DataFacadeImple implements DataFacadeDAO , AutoCloseable{

	public DataFacadeImple() {}
	
	
	public User getUser(String userName) {
		
		Connection conn = null;
		UserDAO usersDAO;
		User user = null;

		try {
			conn = ConnectionUtil.getConnection();
			usersDAO = new UserDAOImple(conn);
			user = usersDAO.getUserByName(userName);
			conn.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		} finally{
			try {
				System.out.println("here");
				conn.close();
				System.out.println("there");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
		
	}

	public String getUserPass(String userName) {
		Connection conn = null;
		UserDAO usersDAO;
		String password = null;

		try {
			conn = ConnectionUtil.getConnection();
			usersDAO = new UserDAOImple(conn);
			password = usersDAO.getUserPassword(userName);
			conn.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return password;
	}

	public boolean authenticate(User user, String pass) {
		
	
			return true;
		
	}

	public void newReimbursement(Reimbursements r) {
		Connection conn = null;
		ReimbursementsDAO reimbDAO;

		try {
			conn = ConnectionUtil.getConnection();
			reimbDAO = new ReimbursementsDAOImple(conn);
			reimbDAO.saveNewReimbursement(r);
			conn.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
	}

	public List<Reimbursements> getUsersReimbursements(int userID) {
		Connection conn = null;
		ReimbursementsDAO reimbDAO;
		List<Reimbursements> usersReimb = new ArrayList<Reimbursements>();
		
		try {
			conn = ConnectionUtil.getConnection();
			reimbDAO = new ReimbursementsDAOImple(conn);
			
			usersReimb = reimbDAO.getUserReimbursements(userID);
			conn.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		
		return usersReimb;
	}

	public List<Reimbursements> getAllReimbursements() {
		Connection conn = null;
		ReimbursementsDAO reimbDAO;
		List<Reimbursements> allReimb = new ArrayList<Reimbursements>();
		
		try {
			conn = ConnectionUtil.getConnection();
			reimbDAO = new ReimbursementsDAOImple(conn);
			
			allReimb = reimbDAO.getAllReimbursements();
			conn.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return allReimb;
	}

	public List<Reimbursements> getFilteredReimbursements(int status) {
		Connection conn = null;
		ReimbursementsDAO reimbDAO;
		List<Reimbursements> filteredReimb = new ArrayList<Reimbursements>();
		
		try {
			conn = ConnectionUtil.getConnection();
			reimbDAO = new ReimbursementsDAOImple(conn);
			
			filteredReimb = reimbDAO.getFilteredReimbursements(status);
			conn.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return filteredReimb;
	}

	public void updateReimbursementsStatus(int resolverID, int reimbID, int status) {
		Connection conn = null;
		ReimbursementsDAO reimbDAO;
		
		try {
			conn = ConnectionUtil.getConnection();
			reimbDAO = new ReimbursementsDAOImple(conn);
			reimbDAO.updateReimbursementsStatus(resolverID, reimbID, status);
			conn.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void close() throws Exception {
	}
	

}
