package sga.web;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sga.domain.Persona;
import sga.servicio.PersonaService;

//path para poder acceder a este servlet
@WebServlet("/personas")
public class PersonaServlet extends HttpServlet{
    
    //Para poder hacer la llamada al ejb es necesario hacer la inyection
    //es parte del api de cdi 
    @Inject 
    PersonaService personaService;
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        
       List<Persona> personas = personaService.listarPersonas(); 
        System.out.println("personas: " + personas);
        request.setAttribute("personas", personas);
        request.getRequestDispatcher("listadoPersonas.jsp").forward(request, response);
    }
}
