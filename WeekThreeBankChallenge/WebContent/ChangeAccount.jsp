<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ page import = "com.revature.domain.BankAccount" %>
<%@ page import = "java.util.List" %>

<%  
//retrieve your list from the request, with casting 
List<BankAccount> list = (List<BankAccount>) session.getAttribute("accounts");
String acctId = (String)session.getAttribute("bankId");

%>


Article[] articles = (Article[]) request.getAttribute("articles");
</head>
<body>
	<h4>Change account</h4>
	<h4>Currently at: <%=acctId%> </h4>
	
	<table>
		<th>Acct ID</th>
		<th>Acct Name</th>
		<th>Balance</th>
		//print the information about every category of the list
		<% for(BankAccount ba : list) {
			out.println("<tr>");
			out.println("<td>");
 			out.println(ba.getBank_account_id());
 			out.println("</td>");
 			out.println("<td>");
 			out.println(ba.getBank_account_name());
 			out.println("</td>");
 			out.println("<td>");
 			out.println(ba.getBalance());
 			out.println("</td>");
 			out.println("</tr>");
		}%>
	</table>
	<form action="changeAccount" method="post">
  		<p class = "lbl">ID:<input type="text" name="id"><br></p> 
		<input class = "lbl" type="submit" value="Change" />
	</form>
</body>
</html>