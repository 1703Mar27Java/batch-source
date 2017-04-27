<%@ include file="includes/head.html" %>
<body>
<%@ include file="includes/navbar.html" %>
<script type="text/javascript" src="scripts/associate.js"></script>


<div class="col-xs-10 col-xs-offset-1 well" style="border-radius:1%;">
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
    <table class="table table-scroll" id="reimz">
        <thead>
            <tr>
                <th>ID</th>
                <th>Amount</th>
                <th>Type</th>
                <th>Submitted</th>
                <th>Resolved</th>
                <th>Resolver</th>
                <th>Status</th>
                
            </tr>
        </thead>
        <tbody>
        	<%ReimbursementDAOImp rdao= new ReimbursementDAOImp();
        	 for(Reimbursement r : rdao.getReimbursements(user.getId())){ %>
        	 	<tr>
        	 		<td><%=r.getId()%></td>
        	 		<td><%="$"+r.getAmount()%></td>
        	 		<td><%=r.getType()%></td>
        	 		<td><%=r.getSubmitted().substring(0,10)%></td>
        	 		<td><%if(r.getResolved() != null){out.write(r.getResolved().substring(0,10));}else{out.write("-");}%></td>
        	 		<td><%if(r.getResolver() != null){out.write(r.getResolver());}else{out.write("-");}%></td>
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
    <form method="post" action="app">
    <input type="hidden" name="location" value="request.jsp"> 
    <button style="float:right; height:60px; width:30%; min-width:150px;" type=submit class="btn btn-primary">New Request</button>
    </form>
    
    <form id="viewR" action="app" method="post">
    <input type="hidden" name="location" value ="reimbursement"> 
    <input id="rId" type="hidden" name ="newR" value ="sdf">
    </form>
</div>


</body>
</html>