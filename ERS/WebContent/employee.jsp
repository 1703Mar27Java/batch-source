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
	<!-- 
	TODO 
		need to work on this page, and process the bean in request.uBean and request.rBean
	-->
	<!-- Revature logo at top of page-->

	<%
	session.setAttribute("rBean", request.getAttribute("rBean"));
	%>


	<div class="wwd-bg">


		<ul class="nav nav-pills" role="tablist"
		style="float: right; overflow: auto;">
		<li role="presentation" class="active"><a href="#">Requests</a></li>
		<li role="presentation"><a href="getUser">Your Info</a></li>
		<li role="presentation"><a href="logout.jsp">Logout</a></li>
	</ul>

	<a href="https://revature.com"> <img src="img/logo.png"
		style="float: left;" alt="Revature">
	</a> <br> <br> <br> <br>
	<h4 style="text-align: left;">
		Employee Reimbursement System. Welcome Employee, 
		<%=session.getAttribute("uName")%>.
	</h4>


</div>






<div class="Testimon-bgcolor">

	
	<div class="container" style="visibility: hidden;">
		<div class="alert alert-danger">
			<strong id="errorText"></strong>
			
		</div>
	</div>

	



	<table class="table table-inverse" style="width: 50%;">
		<tr class="bg-primary">
			<th></th>
			<th>Description</th>
			<th>Amount</th>
			<th>Request Type</th>
			
			<th>New Request:</th>
			<th></th>
			<th></th>
			<th></th>
			<th>Sort Requests by:</th>
		</tr>
		<tr class="bg-success">
			<th></th>
			<th align="left"><input type="text" id="descrIn"
				value="Description" maxlength="35" size="35"></th>

				<th align="left"><input type="number" id="amtIn" value="0"
					maxlength="6" style="width: 75px;"></th>
					<th align="left">
						<!-- Need to pull in dynamic list of possible types --> <sql:query
						dataSource="${source}" var="result">
						SELECT RT_TYPE FROM ERS_REIMBURSEMENT_TYPE
					</sql:query> <select id="typeIn">
					<c:forEach var="row" items="${result.rows}">
					<option>${row.RT_TYPE}</option>
				</c:forEach>
			</select>
		</th>

		<th> </th>
		<th>
			<button id="submitReq">Submit</button>
		</th>
		
		<th></th>
		<th></th>
		<th><sql:query dataSource="${source}" var="result">
			SELECT RS_STATUS FROM ERS_REIMBURSEMENT_STATUS
		</sql:query> <select id="selectStatus" onchange="filter(this.value)">
		<option>Show All</option>
		<c:forEach var="row" items="${result.rows}">
		<option>${row.RS_STATUS}</option>
	</c:forEach>
</select></th>
</tr>
</table>
<!-- Input form for entering new requests -->

<table class="table table-inverse" style="width: 50%;">

           <tr class="bg-primary">
           		<th>Choose your file</th>
           		<th>Enter the Request ID to Modify</th>
           		<th></th>
           
           </tr>
           <tr class="bg-success"> 
           <td> <input type="number" id="rid4img"  maxlength="15" size="15"></td>
           <td> <label for="photo"> Portrait Photo:  </label>
            <input type="file" name="photo" size="50" id="imgUp" placeholder="Upload Your Image" /></td>
           <td> </td>
		</tr>
</table>



<div id="requests"></div>


</div>

</body>
<script>

function readURL(input) {

    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
           // $('#blah').attr('src', e.target.result);
            console.log(e);
            
            $.post("img", {
				img : e.target.result,
				rid: $("#rid4img").val()
			});
            filter($('#selectStatus').val());
        }

        reader.readAsDataURL(input.files[0]);
    }
}

$("#imgUp").change(function(){
    readURL(this);
});


//totally using two different ways of performing ajax here, 
//but it works and i dont want to re-do it -_-


//this occurs when user changes the drop down
function filter(str) {
	var xhttp; 
	if(str=="Show All") 
		str="";
	else
		str="AND R_STATUS= '" + str+"'"
	console.log(str);
	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("requests").innerHTML = this.responseText;
		}
	};
	xhttp.open("GET", "select.jsp?q="+str, true);
	xhttp.send();
}


	//load the user requests
	$(document).ready(function() {
		$.get("select.jsp", function(responseTxt) {
			$("#requests").html(responseTxt);
		});
	});
/*
	function readURL(input) {

       
            var reader = new FileReader();

            reader.onload = function (e) {
                //$('#blah').attr('src', e.target.result);
                console.log(e);
                
            	$.post("addReq", {
    				descr : $("#descrIn").val(),
    				amt : $("#amtIn").val(),
    				type : $("#typeIn").val(),
    				blob : e.target.result
    			});
            }
            reader.readAsDataURL($('#imgUp')[0].files[0]);
            //reader.readAsDataURL(input.files[0]);
        }
    
	*/
	//when user clicks submit button
	$("#submitReq").click(function() {
		if ($('#amtIn').val() > 0) {
			//readURL($('#imgUp'))
			
			$.post("addReq", {
				descr : $("#descrIn").val(),
				amt : $("#amtIn").val(),
				type : $("#typeIn").val()
			});
			//location.reload();
			filter($('#selectStatus').val());
		} else {
			$('#errorText').text("Amount in must be positive");
			$('.container').css('visibility','visible');
		}
	});

	
</script>
</html>