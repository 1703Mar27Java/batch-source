<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
optgroup { 
	font-size:14px; 
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


<body>

	<!-- Revature logo at top of page-->

	<div class="wwd-bg">


		<ul class="nav nav-pills" role="tablist"
			style="float: right; overflow: auto;">
			<li role="presentation"><a href="manager.jsp">Requests</a></li>
			<li role="presentation" class="active"><a href="#">Users</a></li>
			<li role="presentation"><a href="logout.jsp">Logout</a></li>
		</ul>
		<a href="https://revature.com"> <img src="img/logo.png"
			style="float: left;" alt="Revature">
		</a> <br> <br> <br> <br>
		<h4 style="text-align: left;">
			Employee Reimbursement System. Welcome Manager,
			<%=session.getAttribute("uName")%>.
		</h4>


	</div>



	<br>
	<br>
	<div >
		<!-- This is obviously insecure, should put this in a separate file or something -->
		<sql:setDataSource var="source" driver="oracle.jdbc.OracleDriver"
			url="jdbc:oracle:thin:@testdb.ccr7b4olo7hr.us-west-2.rds.amazonaws.com:1521:ORCL"
			user="master" password="p4ssw0rd" />
		<sql:query dataSource="${source}" var="result">
			SELECT USER_NAME FROM VW_ERS_USERS
		</sql:query>

		<select style="font-size:25px;" id="selectUsers">
				<option>Users</option>
			<c:forEach var="row" items="${result.rows}">
				<option><c:out value="${row.USER_NAME}" /></option>
			</c:forEach>
		</select>


		<div class="container" 	style="visibility:hidden; width: 25%; float:left;">
			<div class="alert alert-danger">
				<strong id="error">Whoops!</strong>

			</div>
		</div>
	<br><br>
	</div>







	<div class="Testimon-bgcolor">


		

<br>
		<button id="showMakeEmp" style="float: left;" onclick="showEmpMaker()">Make New Employee</button>
		<br>
		<!-- Section for updating user info -->
		<div id="empInfoHere"></div>
		
		<div id="makeEmp" style="visibility:hidden;">
		<h2>New Employee Form:</h2>
			<table class="table table-inverse" style="width: 90%;">
				<tbody style="font-size: 20px !important;">
					<tr class="bg-primary">
						<th>Email</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Username</th>
						<th>Title</th>
						<th></th>
					</tr>
					<tr class="bg-success">
						<td align="left"><input type="text" id="newEmailIn" value=""
						maxlength="30" size="25"></td>
						<td align="left"><input type="text" id="newFirstIn" value=""
						maxlength="30" size="15"></td>
						<td align="left"><input type="text" id="newLastIn" value=""
						maxlength="30" size="15"></td>
						<td align="left"><input type="text" id="newUserIn" value=""
						maxlength="30" size="15"></td>
						<td align="left"><input type="text" id="newTitleIn" value=""
						maxlength="20" size="15"></td>
						<td><button id="submitNewEmp" style="float: left;" onclick="makeNewEmp()">Submit Employee</button></td>
					</tr>
				</tbody>
			</table>
		
		</div>
	</div>



</body>
<script>
	function makeNewEmp(){
		var e= $('#newEmailIn')[0].value;
		var f= $('#newFirstIn')[0].value;
		var l= $('#newLastIn') [0].value;
		var u= $('#newUserIn') [0].value;
		var t= $('#newTitleIn')[0].value;
		$.post("makeUser", {
			e : e,
			f : f,
			l : l,
			u : u,
			t : t
		}, function(result){
			$(".container").css("visibility","visible");
			if(result=="true"){
				$('#error').text("New User Successfully created.");
				$('#selectUsers').append('<option>'+u+'</option>');
			}
			else
				$('#error').text("Failure Creating New User. The Userame is taken.");
			
		});
	};
	function showEmpMaker(){
		$('#makeEmp').css('visibility','visible');
	}
	
	$(document).on('change', '#selectUsers', function() {
		var curEmp =$('#selectUsers')[0].value;
		//console.log(curEmp);
		empFilter(curEmp)
	});
	
	function empFilter(emp) {
		var xhttp; 
		if(emp!="Users"){
			emp="USER_NAME='" + emp + "'";
			xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					document.getElementById("empInfoHere").innerHTML = this.responseText;
				}
			};
			xhttp.open("GET", "mgrEmpSelect.jsp?q="+emp, true);
			xhttp.send();
		}
	}
	
function btnPress(str){
		if(str=="Reset Password"){
			var uName=$('#txtUserVal')[0].innerHTML;
			var email=$('#txtEmailVal')[0].innerHTML;
			
			$.post("resetPass", {
				uName : uName,
				email : email
			});
			$('.container').css("visibility", "visible");
			$('#error')[0].innerHTML="User's password has been reset. "
		} else if (str=="Update Other Info"){
			$.post("updateInfo", {
				"user"  : $('#txtUserVal').text(),
				"email" : $('#txtEmailIn').val(),
				"fName" : $('#txtFirstIn').val(),
				"lName" : $('#txtLastIn').val()
			});
			setTimeout(function (){
				empFilter($('#txtUserVal').text());
				  // Something you want delayed.
				}, 1000);
			
		}
	}
	

</script>
</html>