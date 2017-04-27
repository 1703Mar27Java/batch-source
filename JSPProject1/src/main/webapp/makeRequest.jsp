<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="requestStyles.css">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
    	<ul class="nav navbar-nav navbar-left">
    		<li><a href="dashboard.jsp" class="glyphicon glyphicon-home"></a></li>
    	</ul>
		<ul class="nav navbar-nav navbar-right" id="viewMyInformation">
        	<li><a href="UserProfile?param=value"><span class="glyphicon glyphicon-user"></span>My Account</a></li>
      	</ul>
    </div>
  </div>
</nav>


<div class="container">
 	<form action="MakeRequest" method="post" id="usrform">
 		<ul>
 			<li><input class = "nav navbar-nav navbar-right" type="submit" value="Submit"/></li>
 		<div style="width:50%;">
 			<li><input class="form-control" type="text" name="amt" placeholder="Amount (numbers only)"></li>
 		</div>
 		</ul>
  		<textarea class="form-control" rows="3" cols="40" name="comment" name="desc" placeholder="Description (optional)..."></textarea>
  		<input class = "userID" type = "hidden" name = "uID" value = <%=(Integer)session.getAttribute("id")%>>
  		<div class="dropdown">
  			<button class="dropbtn">Type</button>
  		<div class="dropdown-content">
  			<input class = "typeDropDown" type = "hidden" name = "types" value ="">
    		<a href="javascript:void(0)" class = "training">Training</a>
    		<a href="javascript:void(0)" class = "supplies">Supplies</a>
    		<a href="javascript:void(0)" class = "travel">Travel</a>
    		<a href="javascript:void(0)" class = "lodging">Lodging</a>
    		<a href="javascript:void(0)" class = "medical">Medical</a>
  		</div>
  	</div>
 	</form>
<div>
	
</div>
</div>
</body>
<script>
$(document).ready(
	//JQUERY
	//handle notifications
	function(){
		$(".typeDropDown").val("Default");
		$(".training").on("click",function(){
			  $(".dropbtn").html('Training');
			  $(".typeDropDown").val('Training');
		})
		$(".supplies").on("click",function(){
			  $(".dropbtn").html('Supplies');
			  $(".typeDropDown").val('Supplies');
		})
		$(".travel").on("click",function(){
			  $(".dropbtn").html('Travel');
			  $(".typeDropDown").val('Travel');
		})
		$(".lodging").on("click",function(){
			  $(".dropbtn").html('Lodging');
			  $(".typeDropDown").val('Lodging');
		})
		$(".medical").on("click",function(){
			  $(".dropbtn").html('Medical');
			  $(".typeDropDown").val('Medical');
		})
	}	
);
</script>
</html>