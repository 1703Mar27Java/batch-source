<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Home</title>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js">
	</script>
		<link rel="stylesheet" href="Main.css">
	

</head>
<body>

<h1>Welcome to Reimbursevature!</h1>
<div>

<!-- Option div. Submit/ View Reqs/ View prof/ logout -->

<div>
	<button id="SubReq" style="height: 50px;width:150px">Start Request</button><br>
	
	<button id="ViewReq" style="height: 50px;width:150px">View Requests</button><br>
	
	<button id="UpdateProf" style="height: 50px;width:150px">Update Profile</button><br>
	

<!-- Log out -->
	<form action="logout" method="post">
		<input type="submit"  name="logout" value="Log Out" type="Submit" style="height: 50px;width:150px"></button><br>
	</form>
</div>


<!-- Results-->
<div id="results" class = "resultDiv">
<br><br><br>

</div>
</div>




<!-- hidden fields -->
<div id = SubReqView style="display: none">
<jsp:include page="submitRequest.jsp" />
</div>

<div id = ViewReqReim style="display: none">
<jsp:include page="viewReqReim.jsp" />
</div>

<div id = UpdateEmpProf style="display: none">
<jsp:include page="updateEmp.jsp" />
</div>
</body>



<script type="text/javascript">



$(document).ready(function() {
	//fill out submit request
	$("#SubReq").click(function(){
			$("#SubReqView").show();
			$("#ViewReqReim").hide();
			$("#UpdateEmpProf").hide();

			$("#results").html($("SubReqView")).show();

	});
	
	//submit request
	$('input[name="SubmitReq"]').click(function(){
		var type = $("#subReqType").val();
		var amt = $('input[name="subReqAmt"]').val();
		var desc = $('input[name="subReqDesc"]').val();
		$.post("front",{
			control: "subReq", 
			subReqType: type, 
			subReqAmt: amt, 
			subReqDesc: desc
			}, function(result){
				console.log(result);
			$("#results").append(result);
		});
	});
	
	
	//View request button
	$("#ViewReq").click(function(){
			$("#ViewReqReim").show();
			$("#SubReqView").hide();
			$("#UpdateEmpProf").hide();

			$("#results").html($("ViewReqReim")).show();

	});
	
	//View update button
	$("#UpdateProf").click(function(){
			$("#UpdateEmpProf").show();
			$("#ViewReqReim").hide();
			$("#SubReqView").hide();

			$("#results").html($("ViewReqReim")).show();

	});
	
	//submit update
	$('input[name="updateEmployee"]').click(function(){
		var firstN = $('input[name="firstName"]').val();
		var lastN = $('input[name="lastName"]').val();
		var userN = $('input[name="userName"]').val();
		var eml = $('input[name="email"]').val();
		if($("#pwReset").is(':checked')){
			var pWord = 1;
		}
		else{
			var pWord = 0;
		}
		$.post("front",{
			control: "updateEmployee", 
			firstName: firstN, 
			lastName: lastN, 
			userName: userN,
			email: eml,
			pwReset: pWord
			}, function(result){
				console.log(result);
			$("#results").append(result);
		});
	});
	
	
	
});
</script>
</html>