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
<%out.print(session.getAttribute("userIDKey")); %>
	<sql:setDataSource var="source" driver="oracle.jdbc.OracleDriver" 
		url="jdbc:oracle:thin:@localhost:1521:xe"
		user="bankmaster" password="bank1234"/>
	<sql:query dataSource="${source}" var="result">
	SELECT * FROM BANK_USER
	</sql:query>
	 <table border="1" width="100%">
        <tr>
            <th>USER ID</th>
            <th>USER PASSWORD</th>
            <th>USER NAME</th>
        </tr>
        <c:forEach var="row" items="${result.rows}">
            <tr>
                <td><c:out value="${row.USER_ID}" /></td>
                <td><c:out value="${row.USER_PASSWORD}" /></td>
                <td><c:out value="${row.USER_NAME}" /></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>