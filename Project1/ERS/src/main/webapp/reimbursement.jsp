<%@ include file="includes/head.html" %>
<body>
<%@ include file="includes/navbar.html" %>
<script type="text/javascript" src="scripts/reimbursement.js"></script>


<%  %>
<div class="col-xs-10 col-xs-offset-1 well"  style="border-radius:1%;">
	
	<% Reimbursement r = (Reimbursement)  session.getAttribute("currentReim");%>
	<label style="position:absolute; right: 20px;  font-size:18pt;"><%= r.getSubmitted() %></label>
	<table>
	<tr>
	<td style="width:35%;">
	<label style="font-size:20pt;"><%=r.getType()%></label><br>
	<label style="font-size:20pt;">$<%=r.getAmount()%></label><br><br>
	<label style="font-size:14pt;">Description:</label><br>
	<div style="height: 280px; overflow-y: auto;"> <%=r.getDescription()%> It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).

	</div>
	</td >
	
	<td style="width:200px;">
		<div style ="margin-left: 50px; margin-right:50px; height: 280px; overflow: auto; width:550px; height:350px;">
			<%  
			   byte[] imgData = r.getPic();	
			   String src=  new String(Base64.getEncoder().encode(imgData), "UTF-8");
			%>
			<img src="data:image/png;base64,<%=src%>">
		</div>
	</td>
	<td>
	</td>
	</tr>
	</table>
	<label id="stat" style="position:absolute; right: 20px; bottom:20px; font-size:18pt;">
	<%if(r.getStatus().equals("PENDING")){%>
        	 			<span style="color:gold">PENDING</span>
        	 			<% }
        	 			
        	 			else if(r.getStatus().equals("APPROVED")){%>
        	 			<span style="color:#32d811;">APPROVED</span>
        	 			<%}			
        	 			else{%>
        	 			<span style="color:red;">DECLINED</span>
        	 			<%} %>
	
	</label>
	
	
	<%if(user.getRole().equals("MANAGER") && r.getStatus().equals("PENDING")){  %>
	<div style="float:right; margin-top:50px;">
	<button class= "btn btn-primary"  id="app" style= "margin-right:30px; background:#14e83e; width:200px; height:60px; display:inline;" >Approve&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-ok"></span></button>
	<button  class= "btn btn-primary" id="dec"  style="background:#ed2121; width:200px;height:60px; display:inline;" >Decline&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-remove"></span></button>
	<%} %>
	</div>
</div>



</body>