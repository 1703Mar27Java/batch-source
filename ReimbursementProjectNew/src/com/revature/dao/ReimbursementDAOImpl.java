package com.revature.dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.ReimbursementBackBean;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO
{
	
	public boolean createReim(ReimbursementBackBean reim, String filename) 
	{
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "BEGIN SP_CREATE_REIM(?, ?, ?, ?, ?, ?, ?); END;";
			CallableStatement cstmt = con.prepareCall(sql);
			cstmt.setDouble(1, reim.getAmount());
			cstmt.setString(2, reim.getDescription());
			cstmt.setBlob(3, reim.getReceipt());
			cstmt.setInt(4, reim.getUserAuthorID());
			cstmt.setInt(5, reim.getType());
			cstmt.setInt(6, reim.getStatus());
			cstmt.registerOutParameter(7, Types.INTEGER);
			cstmt.execute();
			int success = cstmt.getInt(7);
			if(success == 1)
			{
				return true;
			}
			else return false;

		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
			return false;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		} 
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public ReimbursementBackBean getReimbursement(int id, String filename) 
	{
		ReimbursementBackBean reim = new ReimbursementBackBean();
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE R_ID = "+ id;
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet results = pstmt.executeQuery();
			
			while (results.next())
			{
				reim.setId(Integer.parseInt(results.getString("R_ID")));
				reim.setAmount(Double.parseDouble(results.getString("R_AMOUNT")));
				reim.setDescription(results.getString("R_DESCRIPTION"));
				reim.setReceipt(results.getBlob("R_RECEIPT"));
				reim.setSubmitted(results.getDate(("R_SUBMITTED")));
				reim.setResolved(results.getDate(("R_RESOLVED")));
				reim.setUserAuthorID(Integer.parseInt(results.getString("U_ID_AUTHOR")));
				if(results.getString("U_ID_RESOLVER") == null)
				{
					reim.setUserResolverID(0);
				}
				else
				{
					reim.setUserResolverID(Integer.parseInt(results.getString("U_ID_RESOLVER")));
				}
				
				reim.setType(Integer.parseInt(results.getString("RT_TYPE")));
				reim.setStatus(Integer.parseInt(results.getString("RT_STATUS")));
			}
			return reim;
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		} 
		
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public List<ReimbursementBackBean> getAllReimbursements(String filename) 
	{
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			
			List<ReimbursementBackBean> reimList = new ArrayList<ReimbursementBackBean>();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS";
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet results = pstmt.executeQuery();

			while (results.next())
			{
				ReimbursementBackBean reim = new ReimbursementBackBean();

				reim.setId(Integer.parseInt(results.getString("R_ID")));
				reim.setAmount(Double.parseDouble(results.getString("R_AMOUNT")));
				reim.setDescription(results.getString("R_DESCRIPTION"));
				reim.setReceipt(results.getBlob("R_RECEIPT"));
				reim.setSubmitted(results.getDate(("R_SUBMITTED")));
				reim.setResolved(results.getDate(("R_RESOLVED")));
				reim.setUserAuthorID(Integer.parseInt(results.getString("U_ID_AUTHOR")));
				if(results.getString("U_ID_RESOLVER") == null)
				{
					reim.setUserResolverID(0);
				}
				else
				{
					reim.setUserResolverID(Integer.parseInt(results.getString("U_ID_RESOLVER")));
				}
				
				reim.setType(Integer.parseInt(results.getString("RT_TYPE")));
				reim.setStatus(Integer.parseInt(results.getString("RT_STATUS")));
					
				reimList.add(reim);

			}
			return reimList;
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		} 
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public List<ReimbursementBackBean> getAllUserReimbursements(int userID, String filename) 
	{
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{			
			List<ReimbursementBackBean> reimList = new ArrayList<ReimbursementBackBean>();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE U_ID_AUTHOR =" + userID;
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet results = pstmt.executeQuery();

			while (results.next())
			{
				ReimbursementBackBean reim = new ReimbursementBackBean();

				reim.setId(Integer.parseInt(results.getString("R_ID")));
				reim.setAmount(Double.parseDouble(results.getString("R_AMOUNT")));
				reim.setDescription(results.getString("R_DESCRIPTION"));
				reim.setReceipt(results.getBlob("R_RECEIPT"));
				reim.setSubmitted(results.getDate(("R_SUBMITTED")));
				reim.setResolved(results.getDate(("R_RESOLVED")));
				reim.setUserAuthorID(Integer.parseInt(results.getString("U_ID_AUTHOR")));
				if(results.getString("U_ID_RESOLVER") == null)
				{
					reim.setUserResolverID(0);
				}
				else
				{
					reim.setUserResolverID(Integer.parseInt(results.getString("U_ID_RESOLVER")));
				}
				
				reim.setType(Integer.parseInt(results.getString("RT_TYPE")));
				reim.setStatus(Integer.parseInt(results.getString("RT_STATUS")));
					
				reimList.add(reim);

			}
			return reimList;
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		} 
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateReim(ReimbursementBackBean reim, String filename) 
	{
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "BEGIN SP_UPDATE_REIM(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?); END;";
			CallableStatement cstmt = con.prepareCall(sql);
			cstmt.setInt(1, reim.getId());
			cstmt.setDouble(2, reim.getAmount());
			cstmt.setString(3, reim.getDescription());
			cstmt.setBlob(4, reim.getReceipt());
			cstmt.setDate(5, reim.getSubmitted());
			cstmt.setDate(6, reim.getResolved());
			cstmt.setInt(7, reim.getUserAuthorID());
			cstmt.setInt(8, reim.getUserResolverID());
			cstmt.setInt(9, reim.getType());
			cstmt.setInt(10, reim.getStatus());

			cstmt.registerOutParameter(11, Types.INTEGER);
			cstmt.execute();
			int success = cstmt.getInt(11);
			if(success == 1)
			{
				return true;
			}
			else return false;

			
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
			return false;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		} 
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteReim(int id, String filename) 
	{
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "DELETE FROM ERS_REIMBURSEMENTS WHERE R_ID = "+ id;
			PreparedStatement pstmt = con.prepareStatement(sql);
			int numRowsAffected = pstmt.executeUpdate();
			if (numRowsAffected == 1) 
			{
				return true;
			}
			
			else
			{
				return false;
			}
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
			return false;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		} 
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<String> getReimTypes(String filename) 
	{
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{			
			List<String> typeList = new ArrayList<String>();
			String sql = "SELECT DISTINCT RT_TYPE FROM ERS_REIMBURSEMENT_TYPE";
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet results = pstmt.executeQuery();

			while (results.next())
			{
				String type;
				
				type = results.getString("RT_TYPE");
	
					
				typeList.add(type);

			}
			return typeList;
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		} 
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getTypeID(String type, String filename) 
	{
		int typeID = 0;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT RT_ID FROM ERS_REIMBURSEMENT_TYPE WHERE RT_TYPE = '"+ type + "'";
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet results = pstmt.executeQuery();
			
			while (results.next())
			{
				typeID = Integer.parseInt(results.getString("RT_ID"));
			}
			return typeID;
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			return typeID;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return typeID;
		} 
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return typeID;
		}
	}

	@Override
	public int getStatusID(String status, String filename) 
	{
		int statusID = 0;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT RS_ID FROM ERS_REIMBURSEMENT_STATUS WHERE RS_STATUS = '"+ status + "'";
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet results = pstmt.executeQuery();
			
			while (results.next())
			{
				statusID = Integer.parseInt(results.getString("RS_ID"));
			}
			return statusID;
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			return statusID;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return statusID;
		} 
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return statusID;
		}
	}

	@Override
	public Blob StringtoBlob(String receipt, String filename) 
	{
		
		if(receipt == null) return null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			Blob blob = con.createBlob();
			blob.setBytes(1, receipt.getBytes());
			return blob;
			

		}
		catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		} 
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getType(int typeID, String filename) 
	{
		
		String type = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT RT_TYPE FROM ERS_REIMBURSEMENT_TYPE WHERE RT_ID = "+ typeID;
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet results = pstmt.executeQuery();
			
			while (results.next())
			{
				type = results.getString("RT_TYPE");
			}
			return type;
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			return type;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return type;
		} 
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return type;
		}	
	}

	@Override
	public String getStatus(int statusID, String filename) 
	{
		String status = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT RS_STATUS FROM ERS_REIMBURSEMENT_STATUS WHERE RS_ID = " + statusID;
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet results = pstmt.executeQuery();
			
			while (results.next())
			{
				status = results.getString("RS_STATUS");
			}
			return status;
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			return status;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return status;
		} 
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return status;
		}	}
}
