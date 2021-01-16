package com.educacionit.java.web;

import com.educacion.java.entidades.Estudiante;
import java.io.IOException;
import java.util.Map;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Es necesario primeramente agregar el anotation que indica el urlPatterns
@WebServlet(name = "HttpServletForm", urlPatterns = {"/action"})
public class HttpServletForm extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //Captura de datos 
        Map<String, String[]> parametros = request.getParameterMap();

        Estudiante estudiante = new Estudiante(
                (String) parametros.get("nombre")[0],
                (String) parametros.get("apellido")[0],
                (String) parametros.get("dni")[0],
                (String) parametros.get("direccion")[0],
                (String) parametros.get("ciudad")[0],
                (String) parametros.get("telefono")[0],
                (String) parametros.get("email")[0],
                (String) parametros.get("sexo")[0],
                (String) parametros.get("fechaDeNacimiento")[0],
                (String) parametros.get("graduado")[0],
                (String) parametros.get("titulo")[0]
        );

        //Guardado de información en el session.
        request.getSession().setAttribute("estudiante", estudiante);

        //ESTO NO SE BIEN PARA QUE SIRVE, MIRAR EN UDEMY SEGURO ENCONTRARE
        //RESPUESTAS Y BUSCAR EN INTERNET, SOLO SE QUE ME DEVUELVE A INDEX
        response.sendRedirect("index.jsp");

    }
}
