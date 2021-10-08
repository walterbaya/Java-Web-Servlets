/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Suponemos que es la primera vez que se visita el sitio
        boolean nuevoUsuario = true;
        //Obtenemos el arreglo de cookies 
        Cookie[] cookies = request.getCookies();
        
        //buscamos si ya existe una cookie creada con anterioridad
        //llamada visitanteRecurrente
        
        if(cookies != null){
            for(Cookie c: cookies){
                if(c.getName().equals("visitanteRecurrente") && c.getValue().equals("Si")){
                    nuevoUsuario = false;
                    break;
                }
            }
        }
        String mensaje = null;
        if(nuevoUsuario){
            Cookie visitanteCookie = new Cookie("visitanteRecurrente", "Si");
            response.addCookie(visitanteCookie);
            mensaje = "Gracias por visitar nuestro sitio por primera vez";
        }
        else{
            mensaje = "Gracias por visitar NUEVAMENTE nuestro sitio";
        }
        response.setContentType("text/html;charset-UTF-8");
        PrintWriter out = response.getWriter();
        out.print(mensaje);
    }
        
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
