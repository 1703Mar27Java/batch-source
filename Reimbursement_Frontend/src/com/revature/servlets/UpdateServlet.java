package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.domain.Employee;
import com.revature.domain.Roles;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
@MultipartConfig(maxFileSize = 16177215)
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Employee employee = new Employee();
		EmployeeDaoImpl eDao = new EmployeeDaoImpl();
		
		HttpSession session = request.getSession();
		
		employee.setEmployeeID(Integer.valueOf(session.getAttribute("id").toString()));
		employee.setEmployeeUsername(session.getAttribute("user").toString());
		employee.setEmployeePassword(session.getAttribute("pass").toString());
		employee.setEmployeeFirstname(session.getAttribute("first").toString());
		employee.setEmployeeLastname(session.getAttribute("last").toString());
		employee.setEmployeeEmail(session.getAttribute("email").toString());
		
		Roles role = (Roles)session.getAttribute("role");
		employee.setUserRoleID(role);
		
		String username = request.getParameter("u");
		System.out.println(username);
		if(username != null && username != "")
			employee.setEmployeeUsername(username);
		
		String password = request.getParameter("p");
		
		if(password != null && !password.isEmpty())
		{
			System.out.println("Password" +password +"!");
			employee.setEmployeePassword(password);
		}
		
		String firstname = request.getParameter("f");
		if(firstname != null && !firstname.isEmpty())
			employee.setEmployeeFirstname(firstname);
		
		String lastname = request.getParameter("l");
		if(lastname != null && !lastname.isEmpty())
			employee.setEmployeeLastname(lastname);
		
		String email = request.getParameter("e");
		if(email != null&& !email.isEmpty())
			employee.setEmployeeEmail(email);
		
		System.out.println(eDao.UpdateInfo(employee));
	}
}
