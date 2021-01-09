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
        
        //Captura de datos 
        Map<String, String[]> parametros = request.getParameterMap();
        
        String nombre = (String)parametros.get("nombre")[0];
        String apellido = (String)parametros.get("apellido")[0];
        String dni = (String)parametros.get("dni")[0];
        String direccion = (String)parametros.get("direccion")[0];
        String ciudad = (String)parametros.get("ciudad")[0];
        String telefono = (String)parametros.get("telefono")[0];
        String email = (String)parametros.get("email")[0];
        String sexo = (String)parametros.get("sexo")[0];
        //Proceso para transformar un String en date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaDeNacimiento = sdf.parse(parametros.get("fechaDeNacimiento")[0]);
        } catch (ParseException ex) {
            Logger.getLogger(HttpServletForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean graduado = Boolean.parseBoolean((String)parametros.get("nombre")[0]);
        String titulo = (String)parametros.get("nombre")[0];
        
    }
}
