<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*" %>
    <%
    
    //get session creation time
    Date createTime=new Date(session.getCreationTime());
    //get time of last access
    Date lastAccessTime=new Date(session.getLastAccessedTime());
    //
    String title="Session Tracking";
    Integer visitCount= new Integer(0);
    String visitCountKey= new String ("visitCount");
    String userID = new String ("ABCD");
    String userIDKey=new String("userID");
    
    //check if the session is new
    if(session.isNew()){
    	title="Welcome to my website";
    	session.setAttribute(userIDKey,userID);
    	session.setAttribute(visitCountKey,visitCount);
    }
    
    
    //set up visit count
   
    visitCount= (Integer) session.getAttribute(visitCountKey);
   if(visitCount==null)
	   visitCount=0;
    visitCount ++;
    session.setAttribute(visitCountKey, visitCount);
     %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%out.print(title);%></title>
</head>
<body>
<form method="get" action="logout.jsp">
<input type="submit" value="get me out of here"/>

</form>
<center>
<h1>SessionInformation</h1>
</center>
<table border="1" align="center">

<tr>

<th>Session data</th>
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
<th>time of last access</th>
<th><%out.print(lastAccessTime); %></th>
</tr>
<th>user id</th>
<th><%out.print(userID); %></th>
</tr>
<th>number of visits</th>
<th><%out.print(visitCount); %></th>
</tr>
</table>
</body>
</html>