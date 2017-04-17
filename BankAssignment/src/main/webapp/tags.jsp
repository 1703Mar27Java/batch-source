<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ page import="java.io.*,java.util.*,java.sql.*"%>

   
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BankAssignment</title>
</head>
<body>
<%out.print(session.getAttribute("userID")); %>
<sql:setDataSource var ="source" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:xe"
		user="SYSTEM" password="admin" />
		<sql:query dataSource="${source}" var="result">
		SELECT * FROM CAVE
		</sql:query>
		
		<table border="1" width="100%">
        <tr>
            <th>Cave ID</th>
            <th>Cave Name</th>
            <th>Last Name</th>
        </tr>
        <c:forEach var="row" items="${result.rows}">
            <tr>
                <td><c:out value="${row.CAVE_ID}" /></td>
                <td><c:out value="${row.CAVE_NAME}" /></td>
                <td><c:out value="${row.MAX_BEARS}" /></td>
            </tr>
        </c:forEach>
    </table>
		
		
</body>
</html>