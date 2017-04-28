<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Homepage</title>
<link rel="stylesheet" href="radar.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<style>
form{
	clear: right;
	float: right;
	margin-right: 50px;
}
</style>
</head>
<body>
	<img src="images/revradar.png"></img>
	<div class="orange-box">
		<h1>Welcome, ${user.getFirstname()}</h1>
		<input type="checkbox" id="unresolved" value="Unresolved">Pending<br>
		<input type="checkbox" id="resolved" value="Resolved">Resolved<br>
		<div id="list" class="listbox">
			<ul></ul>
		</div>
		<c:if test="${user.getUserRoleID()==1}">
			<form action="createReimbursement.html">
				<input type="submit" class="button" value="New Reimbursement">
			</form>
			<a href="/ReimbursementSystem/viewuser?uid=${user.userID}" class="button" style="clear:right;float:right;margin-right:50px;">My Info</a>
		</c:if>
		<c:if test="${user.getUserRoleID()==2}">
			<form action="viewemployees">
				<input type="submit" class="button" value="View Employees">
			</form>
		</c:if>
			<form action="logout.jsp">
				<input type="submit" class="button" value="Logout">
			</form>
	</div>
</body>
<script>
$(document).ready(function(){
	$("#resolved,#unresolved").on("change",function(){
		if($(this).is(":checked")){
			$("#list ul").empty();
			populateList();
		}else{
			$("#list ul").empty();
			populateList();
		}
	});
	function populateList(){
		var xhttp = new XMLHttpRequest();
		var url=readFilters("reimblist");
		xhttp.open("GET",url,true);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		console.log('url: '+url);
		xhttp.onreadystatechange = function(){
			if (this.readyState == 4 && this.status == 200){
				$(".listbox").removeClass("loading");
				console.log(this.responseText)
				var items = JSON.parse(this.responseText);
				for(var i in items){
					$("#list ul").append("<li><a href=\"viewreimb?rid="+items[i].id+"\"><div class=\"accountCard\"><h3>$"+items[i].amt+"<br>"+items[i].description+"</h3></div></a></li>");
				}	
			}else{
				$(".listbox").addClass("loading");
			}
		};
		xhttp.send();
	}
	function readFilters(url){
		if($("#unresolved").is(':checked')){
			url = url+'?unresolved=1&';
		}else{
			url = url+'?unresolved=0&';
		}
		if($("#resolved").is(':checked')){
			url = url+'resolved=1';
		}else{
			url = url+'resolved=0';
		}
		return url;
	}
});
</script>
</html>