
package com.educacionit.java.web.session;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {


	private final String   userID = "hsimpson";
	private final String password = "qwerty";


	public LoginServlet () {

	    super ();
    }

	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	    String user = request.getParameter ("user");
		String  pwd = request.getParameter ("pwd");
		
		if  (userID.equals(user) && password.equals (pwd)) {

		    HttpSession session = request.getSession ();

			session.setAttribute ("user", "Homer Simpson");
			session.setMaxInactiveInterval (30*60);

			Cookie userName = new Cookie ("user", user);
			userName.setMaxAge (30*60);
			response.addCookie (userName);
			response.sendRedirect ("loginSuccess.jsp");

		} else {

			RequestDispatcher rd = getServletContext ().getRequestDispatcher ("/login.html");
			PrintWriter out= response.getWriter ();

			out.println ("<font color=red>Either user name or password is wrong.</font>");
			rd.include (request, response);
		}
	}
}