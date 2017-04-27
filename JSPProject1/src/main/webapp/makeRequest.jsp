<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="requestStyles.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- get userID from session -->
<%int userId = (int)session.getAttribute("uID");%>
</head>
<body>
<div class="container">
<a href="dashboard.jsp">Home</a>
 
 <form action="MakeRequest" method="post" id="usrform">
 	<p class = "lbl">Amount<input type="text" name="amt"></p>
  	<textarea rows="3" cols="40" name="comment" name="desc" placeholder="Description (optional)..."></textarea>
  	<input class = "userID" type = "hidden" name = "uID" value = <%=(Integer)session.getAttribute("id")%>>
  	<input class = "lbl" type="submit" value="Submit"/>
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