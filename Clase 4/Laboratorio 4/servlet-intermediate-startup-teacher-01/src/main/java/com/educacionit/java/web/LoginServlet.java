package com.educacionit.java.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(
        description = "Login Servlet",
        urlPatterns = {"/login"},
        //Se inicializa los valores que debe tener user y password.
        /*<init-param> and <context-param> are static parameters which 
        are stored in web. xml file. If you have any data which doesn't
        change frequently you can store it in one of them. If you want
        to store particular data which is confined to a particular servlet
        scope, then you can use <init-param>
         */
       
        initParams = {
            @WebInitParam(name = "user", value = "hsimpson"),
            @WebInitParam(name = "password", value = "qwerty")
        }
)
public class LoginServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        //Obtenemos los parametros que estaban inicializados previamente
        //antes los parametros de init se escribian en el archivo web.xml pero ahora
        //Podemos definir los parametros init usando lo que se uso antes.
        
        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");

        logger.debug(String.format("User %s PW %s", user, pwd));

        if (userID.equals(user) && password.equals(pwd)) {

            response.sendRedirect("loginSuccess.html");

        } else {

            response.sendRedirect("loginFail.html");
        }
    }
}
