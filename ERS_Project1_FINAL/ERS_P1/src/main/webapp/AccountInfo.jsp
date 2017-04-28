<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%out.print(session.getAttribute("username")); %>
<sql:setDataSource var="source" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@testdb.ctct7rg6v32d.us-west-2.rds.amazonaws.com:1521:ORCL" user="master"
		password="pas5w0rd" />
<sql:query dataSource="${source}" var="result">
SELECT * FROM EMP_INFO WHERE U_USERNAME = "%";
</sql:query>  


<table>
		<tr>
		 	<th>USERNAME</th>
			<th>PASSWORD</th>
			<th>FIRSTNAME</th>
			<th>LASTNAME</th> 
			<th>EMAIL</th>
			
		</tr>
	
	
	<!-- now we're using jstl core... -->
	<c:forEach var="row" items="${result.rows}">
		<tr>
		<td><c:out value="${row.R_ID}"/></td>
			<td><c:out value="${row.R_USERNAME}"/></td>
			<td><c:out value="${row.R_PASSWORD}"/></td>
			<td><c:out value="${row.R_FIRSTNAME}"/></td>
			<td><c:out value="${row.R_LASTNAME}"/></td>
			<td><c:out value="${row.R_EMAIL}"/></td>
			
			
		</tr>
	</c:forEach>
	
	</table>
	

</body>
</html>