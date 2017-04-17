<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="BankStyle.css">
<title>Edit User</title>
</head>
<body>
	<h1>Edit User</h1>
	<table cellspacing="10">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Password</th>
		</tr>
	
	<c:forEach var="row" items="${sessionUsers}">
		<tr>
			<td><c:out value="${row.BANK_USER_ID}"/></td>
			<td><c:out value="${row.BANK_USER_NAME}"/></td>
			<td><c:out value="${row.BANK_USER_PASSWORD}"/></td>
		</tr>
	</c:forEach>
	</table>
   	<form method="post" action="EditUser">
		User ID<br><input type="text" name="userId"><br/><br/>
		Enter New User Name<br><input type="text" name="userName"><br/>
		Enter New User Password<br><input type="text" name="userPassword"><br/>
		<input type="submit" value="Edit User"><br/>
	</form>
</body>
</html>