package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//Los servlets son clases java que extienden de HttpServlet
//Para poder reconocerlo desde el navegador usamos la notacion de WebServlet
//con el path al cual podemos acceder, no tiene que ser exactamente igual al nombre de la clase.
@WebServlet("/HolaMundo")
public class HolaMundo extends HttpServlet {
    //Cual es el metodo que va a procesar nuestro server?
    //es directo desde el navegador entonces get
    //es un formulario entonces post
    //POST Y GET 
    //llamaremos a traves del navegador en este caso.
    
    //El codigo HTML lo vamos a manejar desde los jsp
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //decimos que al navegador le vamos a devolver texto HTML
        response.setContentType("text/html;charset=UTF-8");
        //el out lo usamos para escribir en el navegador web, abrimos el flujo de datos 
        PrintWriter out = response.getWriter();
        //luego de guardar en out un puntero a un escritor de response 
        //podemos en el imprimir o sea escribir un texto que va a quedar tipo HTML
        out.println("Hola Mundo! desde servlet");
        //Se genera el archivo war que es donde se va a empaquetar el archivo web
        
    }

}
