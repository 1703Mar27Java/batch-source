<%@include file="header.jsp" %>

<%if(currentUser == null) {%>
	<jsp:forward page="/index.jsp"/>
<%}%>

<%@include file="footer.jsp" %>