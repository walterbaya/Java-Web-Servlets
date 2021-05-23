servlet-startp-student-intermediate-02
======================

## Instrucciones

Usar el ejercicio servlet-startp-student-intermediate-01 y definir 2 init param. Actualizar el código
del servlet para leear y mostrar los nombres de los parametros y sus valores en la pantalla. No debe de
usarse el arcchivo web.xml. Recuerde que el ejercicio debe de ser desplegado y probado en Tomcat.

Solucion parcial
----

```
package XXX;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(
    name="",
    description="",
    initParams={@WebInitParam(),
                @WebInitParam()},
    urlPatterns={"/WelcomeServlet","/HelloWorld"}
    )
public class WelcomeServlet extends HttpServlet{
    
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        ServletConfig config= getServletConfig ();
        Enumeration<String> paramEnumeration= config.getInitParameterNames ();
        StringBuffer buffer = new StringBuffer ();
        
        while (paramEnumeration.hasMoreElements ())
        {
        
        }
        
        response.setContentType ("text/html");
        PrintWriter writer = response.getWriter ();
        writer.println (buffer.toString ());
    }                                     
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }                    
}
```