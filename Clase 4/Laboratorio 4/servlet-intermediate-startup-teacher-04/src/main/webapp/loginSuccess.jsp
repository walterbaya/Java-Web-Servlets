<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>

<%
	String user = (String) session.getAttribute ("user");
	String userName  = null;
	String sessionID = null;

	Cookie[] cookies = request.getCookies ();

	if (cookies !=null) {

		for (Cookie cookie : cookies) {

		    if (cookie.getName ().equals ("user")) { userName = cookie.getValue (); };
			if (cookie.getName ().equals ("JSESSIONID")) { sessionID = cookie.getValue (); };
		}
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
</head>
<body>

    <h3>Hello <%=userName %>, Login successful. Your Session ID is <%=sessionID %></h3>

    <br>
    User=<%=user %>
    <br>
    <a href="more.jsp">More information...</a>
    <form action="logout" method="post">
        <input type="submit" value="Logout" >
     </form>
</body>

</html>