<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.revature.beans.CoffeeBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>First</title>
</head>
<%!

int getCount(){
	System.out.println("in getCount method");
	return 0;
}
%>
<body>
<div>
<h1>This is a JSP</h1>
<p>I can write HTML here</p>
<!--  this is an html comment -->
<%--This is a java comment --%>
</div>
<%int count=0; %>
<%out.println(++count); %>
<%String user= request.getParameter("user"); %>
<p>Hello, <%=user %></p>
<%
//application scope
CoffeeBean appScope=new CoffeeBean(1,"Application Scope",50,"Sumatra");
application.setAttribute("appScope",appScope);
//session scope
CoffeeBean sessionScope= new CoffeeBean(2,"Session Scope",40,"Colombia");
session.setAttribute("SessionScope", sessionScope);
//request scope
CoffeeBean requestScope= new CoffeeBean(3,"Request Scope",30,"Brazil");
request.setAttribute("requestScope", requestScope);
//page scope
CoffeeBean pageScope = new CoffeeBean(4,"Page Scope",20,"this page");
pageContext.setAttribute("pageScope",pageScope);
%>
<%=appScope %><br/>
<%=sessionScope %><br/>
<%=requestScope %><br/>
<%=pageScope %><br/>
<% for(int i=1; i<7; i++){ %>
<div><h1 ><%=i %>This is interesting<%=i %></h1></div><%} %>
<!-- What if we used declarations -->
<% out.println(getCount()); %>
<!-- this will redirect you, this request will be null -->
<form action="second.jsp" method="get">

<input type="submit" value="to the second!!!!!!"/>

</form>
<%--
<!--  this will forward you, and the request will be the same! -->
<%RequestDispatcher rd =request.getRequestDispatcher("second.jsp");

rd.forward(request,response);

%>
--%>
</body>
</html>