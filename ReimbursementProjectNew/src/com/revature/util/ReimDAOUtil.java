package com.revature.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.*;

import com.revature.dao.ReimbursementDAOImpl;
import com.revature.domain.ReimbursementBackBean;
import com.revature.domain.ReimbursementFrontBean;

public class ReimDAOUtil 
{
	private static final String filename = new File("C:\\Revature\\ReimbursementProjectNew\\WebContent\\connection.properties").getAbsolutePath();


	public static List<String> getTypeListHelper()
	{
		ReimbursementDAOImpl dao = new ReimbursementDAOImpl();
		List<String> types = new ArrayList<String>();
		types = dao.getReimTypes(filename);
		
		return types;
	}

	public static boolean createReimHelper(ReimbursementFrontBean front)
	{
		
		ReimbursementDAOImpl dao = new ReimbursementDAOImpl();
		ReimbursementBackBean back = new ReimbursementBackBean();
		back = translateFrontToBackBean(front);
		return dao.createReim(back, filename);
	}
	
	public static ReimbursementBackBean translateFrontToBackBean(ReimbursementFrontBean front)
	{
		ReimbursementDAOImpl dao = new ReimbursementDAOImpl();
		ReimbursementBackBean back = new ReimbursementBackBean();
		back.setId(front.getId());
		back.setAmount(front.getAmount());
		back.setDescription(front.getDescription());
		back.setReceipt(dao.StringtoBlob(front.getReceipt(), filename));
		back.setSubmitted(front.getSubmitted());
		back.setResolved(front.getResolved());
		back.setUserAuthorID(front.getUserAuthorID());
		back.setUserResolverID(front.getUserResolverID());
		back.setType(dao.getTypeID(front.getType(), filename));
		back.setStatus(dao.getStatusID(front.getStatus(), filename));
		
		return back;
	}
	
	public static ReimbursementFrontBean translateBackToFrontBean(ReimbursementBackBean back)
	{
		ReimbursementDAOImpl dao = new ReimbursementDAOImpl();
		ReimbursementFrontBean front = new ReimbursementFrontBean();
		front.setId(back.getId());
		front.setAmount(back.getAmount());
		front.setDescription(back.getDescription());
		front.setReceipt(ReimDAOUtil.BlobToString(back.getReceipt()));
		front.setSubmitted(back.getSubmitted());
		front.setResolved(back.getResolved());
		front.setUserAuthorID(back.getUserAuthorID());
		front.setUserResolverID(back.getUserResolverID());
		front.setType(dao.getType(back.getType(), filename));
		front.setStatus(dao.getStatus(back.getStatus(), filename));
		
		return front;
	}

	

	public static String BlobToString(Blob blob)
	{
		if (blob == null)return null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];

		try(InputStream in = blob.getBinaryStream())
		{
			int n = 0;
			while ((n=in.read(buf))>=0)
			{
			   baos.write(buf, 0, n);
			}

			in.close();
			byte[] bytes = baos.toByteArray();
			String blobString = new String(bytes);
			return blobString;
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
	}

	public static List<ReimbursementFrontBean> getUserReims(int userID)
	{
		List<ReimbursementBackBean> backList = new ArrayList<ReimbursementBackBean>();
		List<ReimbursementFrontBean> frontList = new ArrayList<ReimbursementFrontBean>();

		ReimbursementDAOImpl dao = new ReimbursementDAOImpl();
		backList = (ArrayList<ReimbursementBackBean>)dao.getAllUserReimbursements(userID, filename);
		
		for(int i = 0; i < backList.size(); i++)
		{
			frontList.add(i,ReimDAOUtil.translateBackToFrontBean( backList.get(i)));
		}
		return frontList;
	}

	public static List<ReimbursementFrontBean> getReimsHelper()
	{
		List<ReimbursementBackBean> backList = new ArrayList<ReimbursementBackBean>();
		List<ReimbursementFrontBean> frontList = new ArrayList<ReimbursementFrontBean>();

		ReimbursementDAOImpl dao = new ReimbursementDAOImpl();
		backList = (ArrayList<ReimbursementBackBean>)dao.getAllReimbursements(filename);
		
		for(int i = 0; i < backList.size(); i++)
		{
			frontList.add(i,ReimDAOUtil.translateBackToFrontBean( backList.get(i)));
		}
		return frontList;
	}
	
	public static List<ReimbursementFrontBean> getAllPending(List<ReimbursementFrontBean> list)
	{
		List<ReimbursementFrontBean> frontList = new ArrayList<ReimbursementFrontBean>();
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).getStatus().equals("PENDING"))
			{
				frontList.add(list.get(i));
			}
		}
		return frontList;
	}
	
	public static List<ReimbursementFrontBean> getAllResolved(List<ReimbursementFrontBean> list)
	{
		List<ReimbursementFrontBean> frontList = new ArrayList<ReimbursementFrontBean>();
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).getStatus().equals("APPROVED") || list.get(i).getStatus().equals("DECLINED"))
			{
				frontList.add(list.get(i));
			}
		}
		return frontList;
	}

	public static ReimbursementBackBean getReim(int reimID)
	{
		ReimbursementDAOImpl dao = new ReimbursementDAOImpl();
		ReimbursementBackBean back = dao.getReimbursement(reimID, filename);
		return back;
	}
	
	public static boolean updateReimHelper(ReimbursementBackBean back)
	{
		ReimbursementDAOImpl dao = new ReimbursementDAOImpl();
		return dao.updateReim(back, filename);
	}
}
