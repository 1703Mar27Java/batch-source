<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.revature.BankAssignment.domain.*" %>
    <%@ page import="com.revature.BankAssignment.dao.*" %>
    <%@ page import="com.revature.BankAssignment.exceptions.*" %>
    <%@ page import="javax.swing.JOptionPane" %>
    
    <%



String username=request.getParameter("username");
String password=request.getParameter("password");
User user=new User(username,password);
UserDAOImpl userDAO=new UserDAOImpl();

try {
	userDAO.Login(user);
	
	
}catch(IncorrectPassword e){
	
	response.sendRedirect("incorrectlogininfo.jsp");
}
	
	%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<br/>



<%



String option=request.getParameter("option");




if(option.equals("View my accounts")){
	
	
out.print(userDAO.ViewAllAccounts(user));
}
else

if(option.equals("Create an account")){
	
	userDAO.CreateNewAccount(user);
	
	out.print("A new account has been created for you click view all accounts to see it");
}


else
if(option.equals("Delete an empty account")){
	
	
	int accountNumber= Integer.parseInt(JOptionPane.showInputDialog("Enter the number of the account to be deleted"));
	
	
	if(userDAO.DeleteAccount(user, accountNumber))
	out.print("Account number "+accountNumber+" has been deleted");
	
	else
		out.print("Your account could not be deleted check to see if it is empty");
}
else


if(option.equals("Make a deposit")){
	
	
	int accountNumber= Integer.parseInt(JOptionPane.showInputDialog("Enter the number of the account you wish to deposit money into"));
	double amount= Double.parseDouble(JOptionPane.showInputDialog("Enter the amount to be deposited"));
	
	if(userDAO.Deposit(user,accountNumber, amount))
	out.print("Your Deposit of "+amount+" dollars was successful");
	else
		out.print("Deposit failed");
}

if(option.equals("Make a withdrawl")){
	Integer accountNumber;
	Double amount;
	
	accountNumber= Integer.parseInt(JOptionPane.showInputDialog("Enter the number of the account to withdraw money from"));
	amount= Double.parseDouble(JOptionPane.showInputDialog("Enter the amount to be withdrawn"));
	
	
		
	
	if(userDAO.Withdraw(user,accountNumber, amount))
	out.print("Your Withdrawl of " +amount+"dollars was successful");

	else
		out.print("Your Withdrawl of " +amount+"dollars failed, either you do not have enough money or your account number was invalid");
	response.sendRedirect("OperationFailed.jsp");
}


%>

</body>
</html>