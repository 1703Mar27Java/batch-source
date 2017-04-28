<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import="com.ers.util.ERSUtil;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reimbursements Page</title>
</head>
<body>


<%out.print(session.getAttribute("username")); 

%>

		<sql:setDataSource var="source" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@testdb.ctct7rg6v32d.us-west-2.rds.amazonaws.com:1521:ORCL" user="master"
		password="pas5w0rd" />
	<sql:query dataSource="${source}" var="result">
	SELECT R_SUBMMITTED, R_RESOLVED FROM ERS_REIMBURSEMENTS
	</sql:query>  
	
<table>
		<tr>
		<!-- <th>R_Id</th>
			<th>Amount</th>
			<th>Description</th>
			<th>Receipt</th> -->
			<th>Submitted</th>
			<th>Resolved</th>
		<!--  <th>Id Author</th>
			<th>Id Resolver</th>
			<th>Type</th>
			<th>Status</th>-->
		</tr>
	
	
	<!-- now we're using jstl core... -->
	<c:forEach var="row" items="${result.rows}">
		<tr>
	<!--	<td><c:out value="${row.R_ID}"/></td>
			<td><c:out value="${row.R_AMMOUNT}"/></td>
			<td><c:out value="${row.R_DESCRIPTION}"/></td> -->	
			<td><c:out value="${row.R_SUBMITTED}"/></td>
			<td><c:out value="${row.R_RESOLVED}"/></td>
	<!--	<td><c:out value="${row.R_ID_AUTHOR}"/></td>
			<td><c:out value="${row.R_RESOLVER}"/></td>
			<td><c:out value="${row.RT_TYPE}"/></td>
			<td><c:out value="${row.RT_STATUS}"/></td>  -->
			
		</tr>
	</c:forEach>
	
	</table>
	

</body>
</html>