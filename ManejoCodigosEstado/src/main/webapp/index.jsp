<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Codigos de Estado</title>
    </head>
    <body>
        <h1>Codigos de Estado</h1>
        <fieldset> 
            <legend>Formulario de Autorizacion</legend>
            <form name ="form1" action="/ManejoCodigosEstado/Servlet" method="POST"> 
                Usuario: <input type="text" name="usuario">
                <br/><br/>
                Password: <input type="password" name="password">
                <br/><br/>
                <input type="submit" value="Enviar"/>
            </form>
        </fieldset>
        
    </body>
</html>
