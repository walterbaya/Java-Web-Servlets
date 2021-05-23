servlet-startp-student-intermediate-01
======================

## Instrucciones

> 1.	Escriba un servlet usando el API 3.0 que permita:
>    * Mapear multiples URls, ejemplo WelcomeServlet y HelloWorldServlet
> 2.	No puede utilizarse el archivo web.xml
> 3.	Desplegar dentro de Tomcat.
> 4.	Probar.

Solucion parcial
----

```
package XXX;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name="",
    description="",
    urlPatterns={"/WelcomeServlet","/HelloWorld"}
    )
    public class WelcomeServlet extends HttpServlet {
    
        @Override
        protected void doGet (HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            
        }
        
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException
        {
            
        }
}
```