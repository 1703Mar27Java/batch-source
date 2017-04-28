<%@include file="header.jsp"%>

<c:if test="${currentUser== null}">

<jsp:forward page="/index.jsp" />

</c:if>

<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin vitae pharetra felis, ac venenatis nibh. Aenean id risus sit amet tortor laoreet hendrerit. Phasellus erat orci, pulvinar et diam et, pharetra accumsan arcu. Interdum et malesuada fames ac ante ipsum primis in faucibus. Sed eu porttitor nunc. Etiam augue nisl, tincidunt quis vestibulum sed, luctus sit amet dolor. Suspendisse eu lacinia lectus. Nam mollis turpis neque, a lobortis lectus vestibulum ut. Donec dictum quam vitae sapien fermentum iaculis. Mauris nec ex vel risus consectetur tristique in eget justo. Sed ac odio maximus sapien gravida imperdiet. </p>

<%@include file="footer.jsp"%>