<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>    
    <%String str = request.getParameter("username"); 
session.setAttribute("username",request.getParameter("username"));%>
 Welcome <%=session.getAttribute("username")%>
<%if (session.getAttribute("username").equals("")){ %>
<a href="Login.jsp"><b>Login</b></a>
<%} 
else{%>
<a href="logout.jsp"><b>Logout</b></a>
<%}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>