<%String name=(String)session.getAttribute("username");

if(name==null)
{
    response.sendRedirect("index.jsp");
}
else
{
%>
<div id="container">
<link href="css.css" rel="stylesheet" type="text/css"/>
 
 <%session.invalidate();%>
    


<div id="content-container">
<div id="content">
<center><marquee><h2 style="color: red;"><i>- Welcome Guest -</i></h2></marquee><br/><br/>
<h2 style="color: green;">You are logged out!!</h2>
<img src="images/index.jpg" width="550" height="400px"/></center>
</div>

<div id="aside">
<h2>Login :-</h2>
<jsp:include page="LoginPage.jsp"></jsp:include>
</div>

</div>


</div>
<%}%>