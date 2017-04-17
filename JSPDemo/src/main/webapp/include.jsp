<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>dynamic include example</title>
</head>
<body>
this is a page<br/>
<jsp:include page="welcome.jsp">
<jsp:param name="username" value="bob"/>
<jsp:param name="favoriteColor" value="green"/>
</jsp:include>
</body>
</html>