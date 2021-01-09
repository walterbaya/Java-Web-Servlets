<%-- 
    Document   : index
    Created on : 9 ene. 2021, 12:18:06
    Author     : WalterAriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <body>
        <form method="POST"  action="action">
            <label>Nombre: <input type="text" name="nombre"/></label><br>
            <label>Apellido: <input type="text" name="apellido"/></label><br>
            <label>DNI: <input type="text" name="dni"/></label><br> 
            <label>Dirección: <input type="text" name="direccion"/></label><br> 
            <label>Ciudad: <input type="text" name="ciudad"/></label><br> 
            <label>Telefono: <input type="text" name="telefono"/></label><br> 
            <label>Email: <input type="email" name="email"/></label><br> 
            <label>Sexo: <input type="text" name="sexo"/></label><br> 
            <label>Fecha de nacimiento: <input type="date" name="fechaDeNacimiento"/></label><br> 
            <label>Graduado: <input type="checkbox" name="graduado"/></label><br> 
            <label>Titulo: <input type="text" name="titulo"/></label><br>   
            <input type="submit" name="enviar">
        </form>
        
        
        <p>Nombre recibido: </p>
    </body>
</html>
