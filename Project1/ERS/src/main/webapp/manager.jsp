<%@ include file="includes/head.html" %>
<body>
<%@ include file="includes/navbar.html" %>
<script type="text/javascript" src="scripts/manager.js"></script>


<div class="col-xs-10 col-xs-offset-1 well" id="userbox" style="border-radius:1%;">
    <button style="float:right; height:40px; width:15%; min-width:150px;" id="newUBtn" type=submit class="btn btn-primary">Add User</button>
    
     <div class="form-inline" style="float:right" id="newU">
    <div class="form-group">
      <label for="email">Username:</label>
      <input type="email" class="form-control" id="username" placeholder="Enter username">
    </div>
    <div class="form-group">
      <label for="pwd">First:</label>
      <input type="text" class="form-control" id="first" placeholder="Enter first name">
    </div>
    <div class="form-group">
      <label for="pwd">Last:</label>
      <input type="text" class="form-control" id="last" placeholder="Enter last name">
    </div>
    <div class="form-group">
      <label for="pwd">Email:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter email">
    </div>
    <div class="checkbox">
      <label><input id ="manager" type="checkbox">Manager?</label>
    </div>
    <button class="btn btn-primary" id="subuser" style="height:40px">Submit</button>
    </div>
    <span id="addSuc" style="float:right; margin-right:60px; margin-top:10px;" >sdf</span>
<h3 style="display:inline;">Users</h3>
<br><br><br>	
	    <table class="table table-scroll" id="usertab">
        <thead>
            <tr>
                <th>Username</th>
                <th>First</th>
                <th>Last</th>
                <th>Email</th>
                <th>Role</th>              
            </tr>
        </thead>
        <tbody>
        	<%UserDAOImp udao= new UserDAOImp();
        	 for(User u : udao.getUsers()){ %>
        	 	<tr id="users">
        	 		<td><%=u.getUsername() %></td>
        	 		<td><%=u.getFirstName() %></td>
        	 		<td><%=u.getLastName() %></td>
        	 		<td><%=u.getEmail() %></td>
        	 		<td><%=u.getRole()%></td>
        	 	</tr>
        	<% }%>
       
        </tbody>
    </table>
    <button id="viewU" style="float:right; height:40px; width:15%; min-width:150px;" type=submit class="btn btn-primary">View User</button> 
</div>
<div class="col-xs-10 col-xs-offset-1 well" id="reimbox" style="border-radius:1%;">
<h3 style="display:inline;">Reimbursements</h3>
 <div class="dropdown" style="float:right; display:inline;">
    <button id="filtered"  class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">All
    <span class="caret"></span></button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
   	  <li role="presentation"><a class="filter" role="menuitem" tabindex="-1">All</a></li>
   	  <li role="presentation" class="divider"></li>
      <li role="presentation"><a class="filter" role="menuitem" tabindex="-1">Pending</a></li>
      <li role="presentation"><a class="filter" role="menuitem" tabindex="-1">Approved</a></li>
      <li role="presentation"><a class="filter" role="menuitem" tabindex="-1">Declined</a></li>
    </ul>
  </div>
	<br><br><br>	
    <table class="table table-scroll" id="reimtab">
        <thead>
            <tr>
                <th>ID</th>
                <th>Amount</th>
                <th>Type</th>
                <th>Submitted</th>
                <th>Resolved</th>
                <th>Author</th>
                <th>Status</th>
                
            </tr>
        </thead>
        <tbody>
        	<%ReimbursementDAOImp rdao= new ReimbursementDAOImp();
        	 for(Reimbursement r : rdao.getReimbursements()){ %>
        	 	<tr>
        	 		<td><%=r.getId()%></td>
        	 		<td><%="$"+r.getAmount()%></td>
        	 		<td><%=r.getType()%></td>
        	 		<td><%=r.getSubmitted().substring(0,10)%></td>
        	 		<td><%if(r.getResolved() != null){out.write(r.getResolved().substring(0,10));}else{out.write("-");}%></td>
        	 		<td><%if(r.getAuthor() != null){out.write(r.getAuthor());}else{out.write("-");}%></td>
        	 		<td><%if(r.getStatus().equals("PENDING")){%>
        	 			<span style="color:gold">PENDING</span>
        	 			<% }
        	 			
        	 			else if(r.getStatus().equals("APPROVED")){%>
        	 			<span style="color:#32d811;">APPROVED</span>
        	 			<%}			
        	 			else{%>
        	 			<span style="color:red">DECLINED</span>
        	 			<%} %>
        	 		</td>
        	 		
        	 	</tr>
        	<% }%>
       
        </tbody>
    </table>
    
        <form id="viewR" action="app" method="post">
    <input type="hidden" name="location" value ="reimbursement"> 
    <input id="rId" type="hidden" name ="newR" value ="sdf">
    </form>
</div>

</body>
</html>