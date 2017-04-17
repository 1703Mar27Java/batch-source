<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.revature.BankAssignment.domain.*" %>
    <%@ page import="com.revature.BankAssignment.dao.*" %>
    <%@ page import="com.revature.BankAssignment.exceptions.*" %>
    <%@ page import="javax.swing.JOptionPane" %>
    
    
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Result</h1>
<br/>
<%out.print(request.getParameter("username")+" " +request.getParameter("password")+" "+request.getParameter("option")); %>


<%



String option=request.getParameter("option");




if(option.equals("View all users")){
	
out.print(SuperUser.ViewAll());
}
else

if(option.equals("Create a user")){
	
	String newusername=JOptionPane.showInputDialog("Enter a username for the new user");
			String newpassword=JOptionPane.showInputDialog("Enter a password for the new user");
		
					UserDAOImpl userDAO=new UserDAOImpl();
					
					User user=new User(newusername,newpassword);
					
					if(userDAO.CreateUser(user))
					
					out.print("New user has been created");
					
					else
						out.print("New user could not be created");
}



if(option.equals("Delete a user")){
	
	Integer id=Integer.parseInt(JOptionPane.showInputDialog("Enter the id of the user you wish to delete"));


			UserDAOImpl userDAO=new UserDAOImpl();
			
		
			
			if(userDAO.DeleteUser(id))
			
			out.print("User"+id.toString()+ "has been deleted");
			
			else
				out.print("User"+id.toString()+"could not be deleted");
	 
}
else


if(option.equals("Update a user")){
	
	Integer id=Integer.parseInt(JOptionPane.showInputDialog("Enter the id of the user you wish to update"));
	String username=JOptionPane.showInputDialog("Enter the new username for the user");
			String password=JOptionPane.showInputDialog("Enter the new password for the user");

	UserDAOImpl userDAO=new UserDAOImpl();
	

	
	if(userDAO.Update(id,username,password))
	
	out.print("User"+id.toString()+ "has been updated");
	
	else
		out.print("User"+id.toString()+"could not be updated");
	
	
}




%>

</body>
</html>