<%@include file="header.jsp"%>
<%@include file="navbar_af_login.jsp"%>

<%
Cookie cookie[] = request.getCookies();

if(cookie==null){
	response.sendRedirect("home.jsp");
}

boolean verify = false;
String username ="";
for (int i = 0; i < cookie.length; i++) {
	if(cookie[i].getName().equals("AUTHUSER")){
		username = cookie[i].getValue();
		verify = true;
	}
}
if (!verify) {
	response.sendRedirect("index.jsp");
}
%>



<div class="container">
	<h1>
		Welcome <%=username %></h1>
</div>
<%@include file="footer.jsp"%>