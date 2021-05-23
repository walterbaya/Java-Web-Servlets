<%@ page language="java" contentType="text/html; charset=US-ASCII"  pageEncoding="US-ASCII"%>

<%
    String user = null;
    String userName = null;
    String sessionID = null;

    if (session.getAttribute("user") == null) {

        response.sendRedirect("login.html");

    } else {

        user = (String) session.getAttribute("user");
        userName = null;
        sessionID = null;

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {

            for (Cookie cookie : cookies) {

                if (cookie.getName().equals("user")) {
                    userName = cookie.getValue();
                }
                if (cookie.getName().equals("JSESSIONID")) {
                    sessionID = cookie.getValue();
                }
            }
        }
    }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    </head>
    <body>

        <h3>Hi <%=userName%>, Login successful. Your Session ID is <%=sessionID%></h3>
        <br>
        User=<%=user%>
        <br>
        <a href="checkoutPage.jsp">Checkout your information.</a>
        <br>
        <form action="logout" method="post">
            <input type="submit" value="Logout" >
        </form>
    </body>
</html>