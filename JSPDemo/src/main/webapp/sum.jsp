<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>sum</title>
</head>
<body>
<form action="" method="post" target="_this">  

<input type="text" name="aNumber"/>
<input type="submit" value="submit"/>
</form>

<% 

if(request.getParameter("aNumber")!=null){
int x = 1/Integer.parseInt(request.getParameter("aNumber")); 

out.println(x);
}
%>
<p>The current date and time are: </p><%@ include file="date.jsp" %>
</body>
</html>