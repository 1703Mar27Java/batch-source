package com.Revature.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.Revature.domain.Reimbursement;
import com.Revature.domain.SimpleReimb;
import com.Revature.domain.User;
import com.Revature.util.ConnectionUtil;

import oracle.jdbc.internal.OracleTypes;

public class ReimbursementDAOimpl implements ReimbursementDAO {
	@Override
	public void createReimbursement(Reimbursement reimb) {
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");) {
			double amount = reimb.getAmount();
			String desc = reimb.getDescription();
			InputStream receipt = reimb.getReceipt();
			Timestamp timestamp = reimb.getTimestamp();
			int uid = reimb.getSubmitterID();
			int rtid = reimb.getTypeID();
			PreparedStatement cs = con.prepareStatement("{call CREATE_REIMBURSEMENT(?,?,?,?,?,1)}"); //1 is unresolved status id
			cs.setDouble(1, amount);
			cs.setString(2, desc);
		    //cs.setBlob(3, receipt);
			cs.setTimestamp(3, timestamp);
			cs.setInt(4, uid);
			cs.setInt(5, rtid);
			int numRowsAffected = cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	@Override
	public List<SimpleReimb> filter(int userid, String filterType) {
		List<SimpleReimb> reimbs = null;
		switch(filterType){
		case "resolved":	reimbs = resolved(userid);
							break;
		case "unresolved": 	reimbs = unresolved(userid);
							break; 
		}
		return reimbs;
	}
	@Override
	public List<SimpleReimb> filter(String filterType) {
		List<SimpleReimb> reimbs = null;
		switch(filterType){
		case "resolved":	reimbs = allResolved();
							break;
		case "unresolved": 	reimbs = allUnresolved();
							break; 
		}
		return reimbs;
	}
	@Override
	public List<SimpleReimb> allResolved() {
		CallableStatement cs = null;
		List<SimpleReimb> reimbs = new ArrayList<SimpleReimb>();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");){
			cs = con.prepareCall("{call ALL_RESOLVED_REIMBURSEMENTS(?)}");
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.executeUpdate();
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()){
				SimpleReimb reimb = new SimpleReimb();
				reimb.setId(rs.getInt(1));
				reimb.setAmount(rs.getInt(2));
				reimb.setDescription(rs.getString(3));
				reimb.setSubmitterID(rs.getInt(7));
				reimbs.add(reimb);
			}
		}catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reimbs;
	}
	@Override
	public List<SimpleReimb> allUnresolved() {
		CallableStatement cs = null;
		List<SimpleReimb> reimbs = new ArrayList<SimpleReimb>();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");){
			cs = con.prepareCall("{call ALL_UNRESOLVED_REIMBURSEMENTS(?)}");
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.executeUpdate();
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()){
				SimpleReimb reimb = new SimpleReimb();
				reimb.setId(rs.getInt(1));
				reimb.setAmount(rs.getInt(2));
				reimb.setDescription(rs.getString(3));
				reimb.setSubmitterID(rs.getInt(7));
				reimbs.add(reimb);
			}
		}catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reimbs;
	}
	@Override
	public List<SimpleReimb> unresolved(int userid) {
		CallableStatement cs = null;
		List<SimpleReimb> reimbs = new ArrayList<SimpleReimb>();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");){
			cs = con.prepareCall("{call REIMBURSEMENTS_BY_STATUS(1,?,?)}");
			cs.setInt(1, userid);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.executeUpdate();
			ResultSet rs = (ResultSet) cs.getObject(2);
			while(rs.next()){
				SimpleReimb reimb = new SimpleReimb();
				reimb.setId(rs.getInt(1));
				reimb.setAmount(rs.getInt(2));
				reimb.setDescription(rs.getString(3));
				reimb.setSubmitterID(rs.getInt(7));
				reimbs.add(reimb);
			}
		}catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reimbs;
	}
	@Override
	public List<SimpleReimb> resolved(int userid) {
		CallableStatement cs = null;
		List<SimpleReimb> reimbs = new ArrayList<SimpleReimb>();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");){
			cs = con.prepareCall("{call RESOLVED_REIMBURSEMENTS(?,?)}");
			cs.setInt(1, userid);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.executeUpdate();
			ResultSet rs = (ResultSet) cs.getObject(2);
			while(rs.next()){
				SimpleReimb reimb = new SimpleReimb();
				reimb.setId(rs.getInt(1));
				reimb.setAmount(rs.getInt(2));
				reimb.setDescription(rs.getString(3));
				reimb.setSubmitterID(rs.getInt(7));
				reimbs.add(reimb);
			}
		}catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reimbs;
	}
	@Override
	public Reimbursement byId(int rid) {
		CallableStatement cs = null;
		Reimbursement reimb = new Reimbursement();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");){
			cs = con.prepareCall("{call REIMBURSEMENT_BY_ID(?,?)}");
			cs.setInt(1, rid);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.executeUpdate();
			ResultSet rs = (ResultSet) cs.getObject(2);
			
			while(rs.next()){
				reimb.setId(rs.getInt(1));
				reimb.setAmount(rs.getInt(2));
				reimb.setDescription(rs.getString(3));
				//reimb.setReceipt();
				reimb.setTimestamp(rs.getTimestamp(5));
				reimb.setTimestamp(rs.getTimestamp(6));
				reimb.setSubmitterID(rs.getInt(7));
				reimb.setResolverID(rs.getInt(8));
				reimb.setTypeID(rs.getInt(9));
				reimb.setStatusID(rs.getInt(10));
			}
		}catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reimb;
	}
	@Override
	public void approveReimb(int rid, int uid) {
		CallableStatement cs = null;
		Reimbursement reimb = new Reimbursement();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");){
			cs = con.prepareCall("{call UPDATE_REIMBURSEMENT_STATUS(?,?,3)}"); //id 3 is approved
			cs.setInt(1, rid);
			cs.setInt(2, uid);
			cs.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void denyReimb(int rid, int uid) {
		CallableStatement cs = null;
		Reimbursement reimb = new Reimbursement();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");){
			cs = con.prepareCall("{call UPDATE_REIMBURSEMENT_STATUS(?,?,4)}"); //id 4 is denied
			cs.setInt(1, rid);
			cs.setInt(2, uid);
			cs.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
