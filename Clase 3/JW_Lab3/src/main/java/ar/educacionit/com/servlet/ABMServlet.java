/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.educacionit.com.servlet;

import ar.educacionit.com.models.Auto;
import ar.educacionit.com.repository.AutoRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ABMServlet", urlPatterns = {"/action"})
public class ABMServlet extends HttpServlet {

    private AutoRepository autoRepository;
    //Este metodo hay que escribirlo manualmente, recordar que es el que le da vida al 
    //servlet

    @Override
    public void init() {
        this.autoRepository = new AutoRepository();
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ABMServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ABMServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String mensaje="";
        Map<String, String> validaciones = new HashMap();
        
        
        if( marca.length() > 10) {
            validaciones.put("marca", "La marca no puede superar los 10 caracteres");
        }
        if (modelo.length() > 10) {
            validaciones.put("modelo", "El modelo no puede superar los 10 caracteres");
        }
        if (validaciones.isEmpty()) {
            Auto auto = new Auto(marca, modelo);
            autoRepository.save(auto);
            mensaje = "Guardado: " + " " + auto.getMarca() + " " + auto.getModelo();
            List<Auto> autos = autoRepository.get();
            request.getSession().setAttribute("autos", autos);
        } else {
            //Generamos una session, para manejar los objetos, y no el query string.
            //enviamos un atributo llamado validaciones que contiene el map.
            request.getSession().setAttribute("validaciones", validaciones);
        }
        response.sendRedirect("index.jsp?mensaje=" + mensaje);
        
        /*IMPORTANTE le enviamos al jsp en una variable mensaje el contenido de mensaje como response
          al JSP le llegara como request.

          response.sendRedirect("index.jsp?mensaje=" + mensaje);
          No se puede enviar por queryString un objeto como el mapa, entonces tengo que utilizar otro mecanismo.
          para enviar la informacion al frontend
        */
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
