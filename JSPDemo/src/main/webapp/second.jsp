<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.revature.beans.CoffeeBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Second</title>
</head>
<body>
	<%
		Object app = application.getAttribute("appScope");
		Object sesh = session.getAttribute("sessionScope");
		Object req = request.getAttribute("requestScope");
		Object pag = pageContext.getAttribute("pageScope");
	%>
	application<br>
	<%=(CoffeeBean)app %><br>
	session<br>
	<%=(CoffeeBean)sesh %><br>
	request<br>
	<%=(CoffeeBean)req %><br>
	pageContext<br>
	<%=(CoffeeBean)pag %><br>
</body>
</html>