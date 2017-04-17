<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*, java.util.*"%>
<%
	//get session creation time
	Date createTime = new Date(session.getCreationTime());
	Date lastAccessTime = new Date(session.getLastAccessedTime());

	String title = "Welcome back to my website";
	Integer visitCount = new Integer(0);
	String visitCountKey = new String("visitCount");
	String userID = new String("ABCD");
	String userIdKey = new String("userID");
	//set up visit count

	if(session.isNew())
	{
		title="Welcome to my website";
		session.setAttribute(userIdKey, userID);
		session.setAttribute(visitCountKey, visitCount);
	}
	
	visitCount = (Integer) session.getAttribute(visitCountKey);
	if (visitCount != null) {
		visitCount += 1;
		session.setAttribute(visitCountKey, visitCount);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Session tracking</title>
</head>
<body>
<%out.print(session.getAttribute(userID)); %>
	<center>
		<h1>Session Information:</h1>
		<table border="1" align="center">
			<tr>
				<th>Session data</th>
				<th>value</th>
			</tr>
			<tr>
				<th>id</th>
				<th>
					<%
						out.print(session.getId());
					%>
				</th>
			</tr>
			<tr>
				<th>creation time</th>
				<th>
					<%
						out.print(createTime);
					%>
				</th>
			</tr>
			<tr>
				<th>time of last access</th>
				<th>
					<%
						out.print(lastAccessTime);
					%>
				</th>
			</tr>
			<tr>
				<th>user id</th>
				<th></th>
			</tr>
			<tr>
				<th>number of visits</th>
				<th>
					<%
						if (visitCount != null)
							out.print(visitCount);
					%>
				</th>
			</tr>
		</table>
	</center>

</body>
</html>