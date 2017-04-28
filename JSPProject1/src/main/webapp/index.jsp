<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%String userRole = (String)session.getAttribute("userRole"); %>
<!--<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
   <style>
   	 /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
   	 body {
   	 	background-color: lightblue
   	 }
   	 .row.content {
   	 	height: 100px
   	 }
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
   	 
    </style>
    
</head>
<body >

	<Table class = "container-fluid">
		<TR class = "row content">
			<TD>
			<TABLE>
   				<TR class = "row content">
      				<td><h2>Reimbursement Platform</h2><h4><small>FREE MONEY FOR SQUEAKY WHEELS!</small></h4></td>
   				</TR>
			</TABLE>
			</TD>
		</TR>
		<TR  class = "row content">
		<TD>
			<TABLE>
			<tr class = "row content">
				<TD>
		 			<form action="Login" method="post">
  						<p>Name:<input class="form-control" type="text" name="un" style="float:right;"><br></p> 
  						<p>Password:<input class="form-control" type="text" name="pw"><br></p>
						<input class = "glyphicon glyphicon-log-in" type="submit" value="Login" name = "employee"/>
					</form>
				</TD>
			<tr class = "row content">
			</TABLE>
		</TD>
		</TR>
	</Table>
	</div>
	
</body>
</html>