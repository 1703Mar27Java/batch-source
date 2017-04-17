<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<link rel="import"
	href="url(http://fonts.googleapis.com/css?family=Libre+Baskerville|Roboto:300,100);">

<title>AwesomeBank</title>
</head>
<style>
body {
	background-color: #ccc;
	font-family: 'Roboto';
	font-weight: 100;
	line-height: 1.2em;
	margin: 50px auto;
	color: #ccc;
}
h1 {
	font-size: 90px;
	opacity: .5;
	position: relative;
	left: -20px;
	top: -50px;
	float: top;
}
.container {
	width: 825px;
	height: 825px;
	background-color: #333;
	margin: 20px auto;
	padding: 30px;
	//border: 1px solid #999;
	border-radius: 10px;
	
	box-shadow: 0 0 10px #333;
}

.container2 {
	width: 820px;
	height: 700px;
	background-color: grey;
	margin: 20px auto;
	padding: 20px;
	//border: 5px solid #999;
	border-radius: 10px;
	box-shadow: 0 0 10px #333;
	float : right;
	position : relative;
	top: -50px;
 	 left: 17px;
}


ul {
	margin: 0;
	padding: 0;
	list-style: none;
	font-size: 24px;
	color: #fff;
	position: relative;
	bottom: 70px;
}
input {
	padding: 4px;
	margin: 8px 0 15px;
	font-family: 'Roboto';
}
input:focus {
	border: none;
	background-color: #666;
	outline: none;
	padding: 6px;
	color: #fff;
	font-family: 'Roboto';
}
button {
	border-radius: 7px;
	background-color: #999;
	border: none;
	padding: 6px 15px;
	color: #fff;
	margin: 0;
	font-family: 'Roboto';
}
button:hover {
	background-color: #666;
	border: none;
	padding: 6px 15px;
	color: #fff;
	margin: 0;
	font-family: 'Roboto';
}
th{
	border-bottom:1px solid #ddd;
}
</style>


<body>
	<form action="account" method="post">
		<div class="container">
			<h1>AWESOME BANK</h1>
			<div class="container2">
			<h1>Available Accounts</h1>
				<%out.print(session.getAttribute("userIDKey")); %>
	<sql:setDataSource var="source" driver="oracle.jdbc.OracleDriver" 
		url="jdbc:oracle:thin:@localhost:1521:xe"
		user="bankmaster" password="bank1234"/>
	<sql:query dataSource="${source}" var="result">
	SELECT * FROM BANK_USER
	</sql:query>
	 <table >
        <tr>
            <th>USER ID</th>
            <th>USER NAME</th>
            <th>PASSWORD</th>
            <th>SELECT</th>
        </tr>
        <c:forEach var="row" items="${result.rows}">
            <tr>
                <td><c:out value="${row.USER_ID}" /></td>
                <td><c:out value="${row.USER_NAME}" /></td>
                <td><c:out value="${row.USER_PASSWORD}" /></td>
                <td><button type="submit" id=${row.USER_ID}>SELECT</button></td>
            </tr>
        </c:forEach>
    </table>
				
			</div>
			
			
		</div>
	</form>

</body>
</html>