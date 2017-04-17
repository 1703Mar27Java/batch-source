<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.io.*, java.util.*" %>
    <%
    
    	//get session creation 
    	Date createTime = new Date(session.getCreationTime());
    	Date lastAccessTime = new Date(session.getLastAccessedTime());
    	String title = "Wealcome back Homie";
    	Integer visitCount = new Integer(0);
    	String visitCountKey =new String("visitCount");
    	String userID = new String("ABCD");
    	String userKeyID = new String("userID");
    	
    	//check if shession is new
    	//throws null pointer exeption needs to be rethought
    	if(session.isNew()){
    		title = "Welcome To the BEST THING IN YOUR LIFE";
    		session.setAttribute(userKeyID, userID);
    		session.setAttribute(visitCountKey, visitCount);
    	}
    	//visit count setup
    	
    	visitCount = (Integer) session.getAttribute(visitCountKey);
    	visitCount = visitCount + 1;
    	session.setAttribute(visitCountKey, visitCount);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">-->
<title>Session Tracking</title>
</head>
<body>
	
	<form method="get" action="logout.jsp"><input type="submit" values="getmeoutahere"></form>
	<center>
		<h1>Session Info</h1>
	</center>
	<table border ="1" align="center">
		<tr>
			<th>Shession Data</th>
			<th>Value</th>
		</tr>
		
		<tr>
			<th>id</th>
			<th><%out.print(session.getId()); %></th>
		</tr>
		
		<tr>
			<th>creation time</th>
			<th><%out.print(createTime); %></th>
		</tr>
		
		<tr>
			<th>Time of last Access</th>
			<th><%out.print(lastAccessTime);%></th>
		</tr>
		
		<tr>
			<th>UserID</th>
			<th></th>
		</tr>
		<tr>
			<th>Visit Numba</th>
			<th><%out.print(visitCount); %></th>
		</tr>
	</table>
</body>
</html>