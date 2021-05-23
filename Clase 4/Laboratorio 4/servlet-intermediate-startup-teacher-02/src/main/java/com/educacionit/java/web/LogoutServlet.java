package com.educacionit.java.web;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(LogoutServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        Cookie[] cookies = request.getCookies();
        /**
         * El sessionID Sirve para identificar unívocamente a un cliente. Tanto
         * su creación como su destrucción está a cargo del servlet container.
         * Es una cadena de caracteres sumamente larga, que combina números y
         * letras, e identifica unívocamente a un cliente dentro del “universo”
         * de clientes. Por su parte, el protocolo HTTP es “stateless” o sin
         * estado, con lo cual para que el servidor pueda determinar quién es el
         * cliente, necesita obtener algún identificador. El identificador es
         * precisamente el sessionID, que viaja permanentemente entre el cliente
         * y servidor de forma transparente para usuarios finales y también para
         * desarrolladores. Gracias al sessionID, el servidor podrá brindarle un
         * “trato personalizado” al cliente.
         */
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    logger.debug(String.format("JSESSIONID %s", cookie.getValue()));
                    break;
                }
            }
        }

        HttpSession session = request.getSession(false);
        /**
         * Destrucción de una sesión Una vez terminado el uso de los valores de
         * sesión, la sesión debe ser destruida Un mecanismo de destrucción es
         * por tiempo, presentado anteriormente con el session-timeout Para
         * eliminar una sesión en forma manual, se deberá utilizar el método
         * invalidate() El modo de utilización es el siguiente:
         * session.invalidate();
         */
        logger.debug(String.format("User %s", session.getAttribute("user")));

        //La session actual se elimina
        session.invalidate();

        response.sendRedirect("login.html");
    }

}
