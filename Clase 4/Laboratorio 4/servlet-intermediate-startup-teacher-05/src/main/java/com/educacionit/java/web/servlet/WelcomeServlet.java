

package com.educacionit.java.web.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {


	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {


			ServletContext ctx = request.getServletContext ();
			ctx.setAttribute ("User", "Homer Simpson");

			String user = (String) ctx.getAttribute("User");
			ctx.removeAttribute ("User");
			
			HttpSession session = request.getSession ();
			session.invalidate ();
			
			PrintWriter out = response.getWriter ();
			out.write ("Welcome " + user);
	}
}