<!Decimos por medio de la directiva que es una pagina de error
    asi nos permite utilizar el objeto exception>
<%@page isErrorPage="true"%>
<%@page import="java.io."%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manejo de Errores</title>
    </head>
    <body>
        <h1>Manejo de Errores</h1>
        <br/>
        <!-- getMessage() nos devuelve le mensaje -->
        Ocurrio una Exception: <%= exception.getMessage() %>
        <br/>
        <textarea cols="30", rows="5">
           <!--El objeto out se utiliza para enviar un error
            la funcion printStackTrace nos manda el error al out utilizando el printWriter
            -->
           <% exception.printStackTrace(new PrintWriter(out)); %>;

        </textarea>

    </body>
</html>
