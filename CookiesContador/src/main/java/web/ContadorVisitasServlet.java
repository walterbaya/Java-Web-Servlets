package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContadorVisitasServlet")
public class ContadorVisitasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int contador = 0;
        
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie c: cookies){
                if(c.getName().equals("contadorVisitas")){
                    contador = Integer.parseInt(c.getValue());
                    contador++;
                }
            }
        }
        
        Cookie c = new Cookie("contadorVisitas", Integer.toString(contador));
        
        //Indicamos que se almacenara en el cliente por una hora nomas
        
        c.setMaxAge(3600);
        
        //Si ya está definida simplemente sobrescribe el valor.
        
        response.addCookie(c);
    
        //Mandamos el mensaje al navegador
        
        response.setContentType("text/html;charset-UTF-8");
        PrintWriter out = response.getWriter();
        out.print("Contador de visitas del cliente" + contador);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
