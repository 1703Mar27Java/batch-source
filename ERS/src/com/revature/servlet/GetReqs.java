package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.bean.ReqBean;
import com.revature.dao.RequestDAOImpl;

/**
 * Servlet implementation class GetReqs
 */
@WebServlet("/GetReqs")
public class GetReqs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReqs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDAOImpl rDAO = new RequestDAOImpl();
		HttpSession session=request.getSession(); 
		String n= (String) session.getAttribute("uName");
		System.out.println(n);
		ReqBean b = null;
		
		b = new ReqBean(rDAO.fetchReqs(n));
		System.out.println(b);
		request.setAttribute("rBean", b);
		request.setAttribute("target", "employee");
		request.getRequestDispatcher("employee.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
