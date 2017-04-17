<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Here is your newly created account!</title>
</head>
<body>
	<%out.print(session.getAttribute("USER_IDKey")); %>
	<sql:setDataSource var="source" driver="oracle.jbdc.OracleDriver"
	url="jdbc:oracle:thin:@pbjbank.ctct7rg6v32d.us-west-2.rds.amazonaws.com:1521:ORCL"
	user="system" password="guasya"/>
	<sql:query dataSource="${source}" var="result">
		SELECT * FROM UER_LOGON
	</sql:query>
	
	<table>
		<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Passwords</th>
		</tr>
	</table>
	
</body>
</html>