package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Procesamos los parametros enviados por el formulario y luego enviamos una respuesta.
        //leemos los parametros del formulario HTML

        //Solicitamos el valor de una parametro que habia en el formulario
        //seran los name :)
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        System.out.println("usuario: " + usuario);
        System.out.println("password: " + usuario);
        
        //ESTO NO LO HACE NADIE NUNCA SOLO ES PARA MOSTRAR QUE SE PUEDE MANDAR HTML como respuesta.
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("El parametro usuario es: " + usuario);
        out.println("<br/>");
        out.println("El parametro password es: " + password);
        out.println("</body>");
        out.println("</html>");
    }
}
