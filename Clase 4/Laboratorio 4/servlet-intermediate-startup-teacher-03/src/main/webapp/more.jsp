<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>

<%
	String userName = null;

	if (session.getAttribute("user") == null){
		response.sendRedirect("login.html");
	}else userName = (String) session.getAttribute("user");

	Cookie[] cookies = request.getCookies ();

	if (cookies !=null){

		for (Cookie cookie : cookies) {

			if (cookie.getName ().equals ("user")) userName = cookie.getValue ();
		}
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
</head>
<body>
<h3>Hi <%=userName %>, More Information.</h3>
<br>
<form action="<%=response.encodeURL ("logout") %>" method="post">
    <input type="submit" value="Logout" >
</form>
</body>
</html>