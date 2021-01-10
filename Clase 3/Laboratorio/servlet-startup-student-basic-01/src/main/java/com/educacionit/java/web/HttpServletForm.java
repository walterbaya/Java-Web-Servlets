package com.educacionit.java.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Es necesario primeramente agregar el anotation que indica el urlPatterns
@WebServlet(name = "HttpServletForm", urlPatterns = {"/action"})
public class HttpServletForm extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HashMap<String, Object> salida = new HashMap();
        //Captura de datos 
        Map<String, String[]> parametros = request.getParameterMap();

        String nombre = (String) parametros.get("nombre")[0];
        salida.put("nombre", nombre);
        String apellido = (String) parametros.get("apellido")[0];
        salida.put("apellido", apellido);
        String dni = (String) parametros.get("dni")[0];
        salida.put("dni", dni);
        String direccion = (String) parametros.get("direccion")[0];
        salida.put("direccion", direccion);
        String ciudad = (String) parametros.get("ciudad")[0];
        salida.put("ciudad", ciudad);
        String telefono = (String) parametros.get("telefono")[0];
        salida.put("telefono", telefono);
        String email = (String) parametros.get("email")[0];
        salida.put("email", email);
        String sexo = (String) parametros.get("sexo")[0];
        salida.put("sexo", sexo);
        //Proceso para transformar un String en date
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //try {
            String fechaDeNacimiento = (String)parametros.get("fechaDeNacimiento")[0];
            salida.put("fechaDeNacimiento", fechaDeNacimiento);
        //} catch (ParseException ex) {
        //    Logger.getLogger(HttpServletForm.class.getName()).log(Level.SEVERE, null, ex);
        //}
        String graduado = ((String) parametros.get("graduado")[0]);
        salida.put("graduado", graduado);
        String titulo = (String) parametros.get("titulo")[0];
        salida.put("titulo", titulo);

        //Guardado de información en el session.
        
        request.getSession().setAttribute("salida", salida);
        
        response.sendRedirect("index.jsp");
        
    }
}
