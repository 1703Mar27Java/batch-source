package com.Revature.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Revature.dao.ReimbursementDAOimpl;
import com.Revature.domain.Reimbursement;
import com.Revature.domain.SimpleReimb;
import com.Revature.domain.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ReimbursementListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Integer unresolved = Integer.parseInt(req.getParameter("unresolved"));
		Integer resolved = Integer.parseInt(req.getParameter("resolved"));
		
		List<SimpleReimb> reimbs = new ArrayList<SimpleReimb>();
		List<SimpleReimb> temp = new ArrayList<SimpleReimb>();
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		ReimbursementDAOimpl reimbDAO = new ReimbursementDAOimpl();
		if(user.getUserRoleID()==1){
			if(unresolved==1){
				temp = reimbDAO.filter(user.getUserID(), "unresolved");
				reimbs.addAll(temp);
			}
			if(resolved==1){
				temp = reimbDAO.filter(user.getUserID(), "resolved");
				reimbs.addAll(temp);
			}
		}else{	//manager
			if(unresolved==1){
				temp = reimbDAO.filter("unresolved");
				System.out.println("unresolved temp.toString(): "+temp.toString());
				reimbs.addAll(temp);
			}
			if(resolved==1){
				temp = reimbDAO.filter("resolved");
				System.out.println("unresolved temp.toString(): "+temp.toString());
				reimbs.addAll(temp);
			}
		}
		String json="[]";
		if(reimbs.isEmpty()){
			System.out.println("[Reimbs is empty]");
		}else{
			json = makeJSON(reimbs);
			System.out.println(json);
		}
		resp.getWriter().write(json);
		//resp.sendRedirect("homepage.jsp");
	}
	public String makeJSON(List<SimpleReimb> sr){
		StringBuilder json = new StringBuilder();
		json.append("[");
		boolean first = true;
		for(SimpleReimb r: sr){
			Double temp = r.getAmount();
			if(first == false){
				json.append(",");
			}
			json.append("{\"id\":\""+r.getId()+"\",\"amt\":\""+temp.toString()+"\",\"description\":\""+r.getDescription()+"\"}");
			first = false;
		}
		json.append("]");
		return json.toString();
	}	
}
