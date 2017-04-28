<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<link rel="stylesheet" href="Main.css">
	


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Home</title>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js">
	</script>

</head>
<body>
<h1>Welcome to Reimbursevature!</h1>

<!-- Option div. View Pending/View Resolved/Register Employee/ logout -->
<div class = "container">
<div class = "left-element">
	<form action = "#results">
		<button id="ViewPendingReims" autofocus="" style="height: 50px;width:150px">View Pending Reimbursements</button><br>
	
		<button id="ViewResolvedReims" style="height: 50px;width:150px">View Resolved Reimbursements</button><br>
	
		<button id="ViewEmps" style="height: 50px;width:150px">View Employees</button><br>
		
		<button id="RegisterEmp" style="height: 50px;width:150px">Register Employee</button>
	</form>


<!-- Log out -->
	<form action="logout" method="post">
		<input type="submit"  name="logout" value="Log Out" type="Submit" style="height: 50px;width:150px"></button><br>
	</form>
</div>



<!-- Results-->
<div id="results" class = "right-element";>

</div>



</div>



</body>

<script type="text/javascript">


//resolved reims view
$(document).ready(function() {
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	$("#ViewResolvedReims").on("click",(function(){
		$("#results").html("LOADING RESOLVED REIMBURSEMENTS...");
		$("#results").load("reimList.jsp", function(){
			$("#resolveList").show();
			$("#pendList").hide();
		});

	}));
	
	//pending reims view
	$("#ViewPendingReims").on("click",(function(){
		$("#results").html("LOADING PENDING REIMBURSEMENTS...");
		$("#results").load("reimList.jsp", function(){
			$("#pendList").show();
			$("#resolveList").hide();
		});


	}));
	//view all employees
	$("#ViewEmps").on("click",(function(){
		$("#results").html("LOADING EMPLOYEES...");
		$("#results").load("allEmps.jsp", function(){
			$("#empList").show();
		});

	}));
	
	//manage reimbursments
	$('pendListTable').on('click', 'button', function(){
		var butName = $(this).attr('name');
		var butID = $(this).attr('id');
		
		$.post("front",{
			control: "manReims", 
			status: butName, 
			reimID: butID, 
			}, function(results){
				$("#results").load(results);
			});
		
	});
	
	
	//view a employee button
	$("#ViewEmp").on("click",(function(){
		$("#results").html($("#hidden1"));
		$("#hidden1").show();
		
	}));
	
	//view employee and reimbursements
	$('#empListTable').on('click', 'button', function(){
		$("#results").html("LOADING EMPLOYEE...");
		$("#results").load("viewEmp.jsp", function(){
			$("#empList").show();
		});
	});
	
	//register employee button
	$("#RegisterEmp").on("click",(function(){
		$("#results").load("registerEmp.jsp")}));
	
	//register employee
	//submit request
	$('input[name="regEmpSubmit"]').click(function(){
		var regUsername = $('input[name="regUsername"]').val();
		var regPassword = $('input[name="regPassword"]').val();
		var regFirstname = $('input[name="regFirstname"]').val();
		var regLastname = $('input[name="regLastname"]').val();
		var regEmail = $('input[name="regEmail"]').val();

		$.post("front",{
			control: "regNewUser", 
			rUname: regUsername, 
			rPword: regPassword, 
			rFName: regFirstname,
			rLName: regLastname,
			rEmail: regEmail
			}, function(result){
				console.log(result);
			$("#results").append(result);
		});
	});
	
	
});

</script>