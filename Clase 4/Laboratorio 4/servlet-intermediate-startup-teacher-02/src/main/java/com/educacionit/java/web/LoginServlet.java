package com.educacionit.java.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private final String userID = "hsimpson";
    private final String password = "qwerty";

    private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        logger.debug(String.format("User %s PWD %s", user, pwd));

        //Si  el password y usuario coinciden
        if (userID.equals(user) && password.equals(pwd)) {

            //guarda en session el nombre de usuario
            HttpSession session = request.getSession();
            session.setAttribute("user", "hsimpson");

            //Seteo cuanto tiempo maximo de inactividad permitira session
            //Antes de perder la información capturada desde la ultima vez.
            session.setMaxInactiveInterval(30 * 60);

            //Creo una nueva cookie que guarda el nombre de usuario unicamente.
            Cookie userName = new Cookie("user", user);
            //Se le setea una duracion de tiempo a la cookie
            userName.setMaxAge(30 * 60);
            //guardamos la cookie en response
            response.addCookie(userName);
            //redireccionamos hacia la pagina de exito
            response.sendRedirect("loginSuccess.jsp");

        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            //en el objeto response coloca el texto
            PrintWriter out = response.getWriter();
            out.println("<font color=red>User name or password is wrong !!!</font>");
            //Se incluye el contenido del recurso del servlet login y lo incluye en el servlet actual.
            /*El servlet asociado a login.html es quien imprime todo lo necesario hace los out
            de todo el contenido que se imprime en pantalla, este mismo contenido lo incluimos en el
            contenido de nuestro servlet actual, entoncs va a tener todo eso pero ademas va a imprimir el
            texto de error en rojo, siempre primero imprime nuestro texto o lo que haga nuestro server principal
            y luego lo que haga el servlet secundario*/
            rd.include(request, response);
        }
    }
}
