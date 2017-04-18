<%@ page import = "com.revature.domain.Bank"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>

	<% Bank user = (Bank) session.getAttribute("user");
    session.setAttribute("contact_status","null");    			      					      			
    %>
    
<link href="css.css" rel="stylesheet" type="text/css"/>


<div id="content-container">
<div id="content"> 

<marquee><h2 style="color: red;"><i>
            <%
            if(user==null)
            {%>
                  Welcome Guest 
            <%}
            else
            {%>
            	Welcome <%=user%> 
            <%}%>
            </i></h2></marquee><br/><br/>

<center><img src="WebContent/index.jpg" width="550" height="400px"/></center>
</div>

<div id="aside">
    <%
    if(user==null)
    {%>
<h2>Login :-</h2>


<jsp:include page="LoginPage.jsp"></jsp:include>

    <%}
    else
      {%>
	<p> Let's do some Banking!!!
	<%} %>

</div>
</div>
</body>
</html>