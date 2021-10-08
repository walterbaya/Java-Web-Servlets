/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author WalterAriel
 */
@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset-UTF-8");

        //Creamos o recuperamos el objeto http session
        HttpSession sesion = request.getSession();

        //Recuperamos la lista de articulos previos si ya existen
        List<String> articulos = (List<String>) sesion.getAttribute("articulos");

        //Verificamos si la lista de articulos existe
        if (articulos == null) {
            //Inicializamos la lista de articulos
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos", articulos);
        }

        //Procesamos el nuevo arituclo
        String articuloNuevo = request.getParameter("articulo");

        //revisamos y agregamos el articulo nuevo
        if (articuloNuevo != null && !articuloNuevo.trim().equals("")) {
            //Maneja la lista de articulos agregada a la sesion automaticamente
            articulos.add(articuloNuevo);
        }
        //Imprimimos la lista de articulos
        try (PrintWriter out = response.getWriter()) {
            out.print("<h1>Lista de Articulos</h1>");
            out.print("<br>");

            //Iteramos todos los articulos
            for (String articulo : articulos) {
                out.print("<li>" + articulo + "</li>");
            }

            out.print("<br>");
            out.print("<a href='/EjemploCarritoCompras'>Regresar al inicio </a>");
        }
    }

}
