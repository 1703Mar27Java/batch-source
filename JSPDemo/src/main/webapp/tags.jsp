<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Caves</title>
</head>
<body>
<%out.print(session.getAttribute("userID")); %>
	<sql:setDataSource var="source" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:xe" user="SYSTEM"
		password="admin" />
	<sql:query dataSource="${source}" var="result">
	SELECT * FROM CAVE
	</sql:query>
	
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>MaxBears</th>
		</tr>
	
	
	<!-- now we're using jstl core... -->
	<c:forEach var="row" items="${result.rows}">
		<tr>
			<td><c:out value="${row.CAVE_ID}"/></td>
			<td><c:out value="${row.CAVE_NAME}"/></td>
			<td><c:out value="${row.MAX_BEARS}"/></td>
		</tr>
	</c:forEach>
	
	</table>

</body>
</html>