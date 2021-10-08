package Servlet;

import Base.BaseDeDatos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Respuesta")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Se obteiene el documento ingresado
        
        Double documento = Double.valueOf(request.getParameter("documento"));
        System.out.println("El Documento es: " + documento);
        
        
        /*Lo mas importante y prioritario va a ser el tiempo que se tarde en buscar
        una estructura con sentido parece ser el treeMap, considerando alrededor de 
        50000000 de posibles dnis lo que ocurre es que en encontrar uno en peor caso
        el tiempo sería alredor 7 segundos considerando que el tiempo en pasar por cada uno es un
        segundo, en la realidad esto es en microsegundos asi que es bastante eficiente
        La insersion va a costar lo mismo, pero se efectua al igual que el borrado menos veces podemos
        pensar*/
        
        /*LA IDEA NO ES HACER ESTO, PERO A MODO DE PRUEBA PARA VER SIRVE.*/
        
        BaseDeDatos base = new BaseDeDatos();
        base.insertarCliente(30.0 , "Fabrizio");
        base.insertarCliente(31.0 , "Fabio");
        base.insertarCliente(32.0 , "Fabian"); 
        
        String nombreObtenido = base.obtenerNombreCliente(documento);
        PrintWriter escritor = response.getWriter();
        escritor.println(nombreObtenido);
    }

}
