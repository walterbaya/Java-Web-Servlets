package com.educacionit.java.web;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final String userID = "hsimpson";
    private final String password = "qwerty";

    private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        logger.debug("User=" + user + " PWD=" + pwd);

        if (userID.equals(user) && password.equals(pwd)) {

            HttpSession session = request.getSession();
            session.setAttribute("user", "hsimpson");

            session.setMaxInactiveInterval(30 * 60);
            Cookie userName = new Cookie("user", user);
            response.addCookie(userName);

            //Codifica la url de loginSuccess.jsp usando response y la guarda en forma de string
            String encodedURL = response.encodeRedirectURL("loginSuccess.jsp");

            //para luego poder enviarla como redireccion en el encodedURL
            response.sendRedirect(encodedURL);

        } else {

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();

            out.println("<font color=red>User name or password is wrong !!!</font>");
            rd.include(request, response);
        }
    }
}
