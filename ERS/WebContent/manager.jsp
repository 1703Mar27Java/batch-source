<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import= "java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	//Check if user is logged in
if (session.getAttribute("uName") == null || session.getAttribute("uName").equals("")) {
RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
dispatcher.forward(request, response);
}
	//check if user is mgr. Non managers are not allowed here.
if (session.getAttribute("isMgr") == null || session.getAttribute("isMgr").equals("false")) {
RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
dispatcher.forward(request, response);
}
%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Revature ERS</title>

	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!-- Revature favicon -->
	<link href="img/favicon.ico" rel="icon" type="image/x-icon">
	<link type="text/css" media="all" href="css/rev.css" rel="stylesheet">


	<style>
		body {
			background-image: url('img/black-bg.png');
			position: relative;
			height: 150%;
			width: 100%;
			background-repeat: no-repeat;
			background-attachment: fixed;
			background-size: 100% 100%;
			height: 150%;
		}

		.btn {
			float: right;
		}
	</style>
</head>
<!-- bootstrap cdn's -->
<link
href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
rel="stylesheet"
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
crossorigin="anonymous">
<script
src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
crossorigin="anonymous">

</script>
<!-- This is obviously insecure, should put this in a separate file or something -->
<sql:setDataSource var="source" driver="oracle.jdbc.OracleDriver"
url="jdbc:oracle:thin:@testdb.ccr7b4olo7hr.us-west-2.rds.amazonaws.com:1521:ORCL"
user="master" password="p4ssw0rd" />

<body>

	<%
		//session.setAttribute("rBean", request.getAttribute("rBean"));
	%>

	<!-- Revature logo at top of page-->

	<div class="wwd-bg">


		<ul class="nav nav-pills" role="tablist"
			style="float: right; overflow: auto;">
			<li role="presentation" class="active"><a href="#">Requests</a></li>
			<li role="presentation"><a href="mgrUpdateEmp.jsp">Users</a></li>
			<li role="presentation"><a href="logout.jsp">Logout</a></li>
		</ul>
		<a href="https://revature.com"> 
			<img src="img/logo.png"
			style="float: left;" alt="Revature">
		</a> 
		<br> <br> <br> <br>
		<h4 style="text-align: left;">
			Employee Reimbursement System. Welcome Manager,
			<%=session.getAttribute("uName")%>.
		</h4>
	

	</div>
	
	
	
	<br>
	<br>

	<div class="Testimon-bgcolor">
	
	
		
	
		<table class="table table-inverse" style="width: 50%;">
			<tr class="bg-primary">
				<th>Sort Requests by:</th>
		
				<th></th>
				<th></th>
		
			</tr>
			<tr class="bg-success">
		
				<th align="left">
					<!-- Need to pull in dynamic list of possible types --> 
					<sql:query dataSource="${source}" var="result">
						SELECT RT_TYPE FROM ERS_REIMBURSEMENT_TYPE
					</sql:query> 
					<select id="selectType">
						<option>Show All Types</option>
						<c:forEach var="row" items="${result.rows}">
							<option>${row.RT_TYPE}</option>
						</c:forEach>
					</select>
				</th>
		
		
		
		
				<th>
					<sql:query dataSource="${source}" var="result">
						SELECT USER_NAME FROM VW_ERS_USERS
					</sql:query> 
					<select id="selectUser">
					<option>Show All Users</option>
						<c:forEach var="row" items="${result.rows}">
							<option>${row.USER_NAME}</option>
						</c:forEach>
					</select>
				</th>
		
		
				<th>
					<sql:query dataSource="${source}" var="result">
						SELECT RS_STATUS FROM ERS_REIMBURSEMENT_STATUS
					</sql:query> 
					<select id="selectStatus">
						<option>Show All Statuses</option>
						<c:forEach var="row" items="${result.rows}">
							<option>${row.RS_STATUS}</option>
						</c:forEach>
					</select>
				</th>
			</tr>
		</table>
	
	<!-- Input form for entering new requests -->
	<div id="requests"></div>
	
	</div>

</body>



<script>

	function resolve(stat,rid){
			
			if (stat!="No Change") {
				$.post("resReq", {
					rid : rid,
					status : stat
				});
				//location.reload();
				
			} else {
				console.log("error");
			}
			filter();
		
	}


	function filter() {
		var xhttp; 
		//determine sql string to use
		var u =$('#selectUser').val();
		var s =$('#selectStatus').val();
		var t =$('#selectType').val();
		var sql="";
		//very messy if statements.
		//we need to know what sql to send for each case
		if (u=="Show All Users" && s=="Show All Statuses" && t=="Show All Types")
			//string remains empty, we are just doing SELECT *
			sql="";
		else if(u!="Show All Users" && s=="Show All Statuses" && t=="Show All Types")
			sql="WHERE USERNAME='"+u+"'";
		else if(u=="Show All Users" && s!="Show All Statuses" && t=="Show All Types")
			sql="WHERE R_STATUS='"+s+"'";
		else if(u=="Show All Users" && s=="Show All Statuses" && t!="Show All Types")
			sql="WHERE R_TYPE='"+t+"'";
		else if(u!="Show All Users" && s!="Show All Statuses" && t=="Show All Types")
			sql="WHERE USERNAME='"+u+"'AND R_STATUS='"+s+"'";
		else if(u!="Show All Users" && s=="Show All Statuses" && t!="Show All Types")
			sql="WHERE USERNAME='"+u+"'AND R_TYPE='"+t+"'";
		else if(u=="Show All Users" && s!="Show All Statuses" && t!="Show All Types")
			sql="WHERE R_STATUS='"+s+"'AND R_TYPE='"+t+"'";
		else if(u!="Show All Users" && s!="Show All Statuses" && t!="Show All Types")
			sql="WHERE USERNAME='"+u+"'AND R_STATUS='"+s+"'AND R_TYPE='"+t+"'";
				
		xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("requests").innerHTML = this.responseText;
			}
		};
		xhttp.open("GET", "mgrSelect.jsp?q="+sql, true);
		xhttp.send();
	}
	
	$('#selectUser').change(function(){
		filter();
	});
	$('#selectStatus').change(function(){
		filter();
	});
	$('#selectType').change(function(){
		filter();
	});
	
	$(document).ready(function() {
		$.get("mgrSelect.jsp", function(responseTxt) {
			$("#requests").html(responseTxt);
		});
	});
	
</script>
</html>