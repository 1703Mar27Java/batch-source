<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sum</title>
</head>
<body>
<form method="post" action="sum.jsp">
	<input type="text" name="aNumber">
	<input type="submit" value="submit">
</form>
	<% if (request.getParameter("aNumber") != null){
		int x = 1/Integer.parseInt(request.getParameter("aNumber"));
		out.println(x);
	}
	 %>
</body>
</html>