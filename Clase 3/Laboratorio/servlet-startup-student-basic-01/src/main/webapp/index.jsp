<%-- 
    Document   : index
    Created on : 9 ene. 2021, 12:18:06
    Author     : WalterAriel
--%>

<%@page import="com.educacion.java.entidades.Estudiante"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post"  action="action">
            <label>Nombre: <input type="text" name="nombre"/></label><br>
            <label>Apellido: <input type="text" name="apellido"/></label><br>
            <label>DNI: <input type="text" name="dni"/></label><br> 
            <label>Dirección: <input type="text" name="direccion"/></label><br> 
            <label>Ciudad: <input type="text" name="ciudad"/></label><br> 
            <label>Telefono: <input type="text" name="telefono"/></label><br> 
            <label>Email: <input type="email" name="email"/></label><br> 
            <label>Sexo: <input type="radio" name="sexo"/></label><br> 
            <label>Fecha de nacimiento: <input type="date" name="fechaDeNacimiento"/></label><br> 
            <label>Graduado: <input type="checkbox" name="graduado"/></label><br> 
            <label>Titulo: <input type="text" name="titulo"/></label><br>   
            <input type="submit" name="enviar">
        </form>
        <%Estudiante entrada = (Estudiante)session.getAttribute("estudiante");
        %>
        <%if (entrada == null) {%>
        <p>De momento no se ingreso nada</p>
        <%} else {%>
        <p>Se ingresaron datos</p>
        <h2>Informacion de estudiante</h2>
        <p>El nombre ingresado es: <%=(String) entrada.getNombre()%></p>
        <p>El apellido ingresado es: <%=(String) entrada.getApellido()%></p>
        <p>El dni ingresado es: <%=(String) entrada.getDni()%></p>
        <p>La direccion ingresada es: <%=(String) entrada.getDireccion()%></p>
        <p>La ciudad ingresada es: <%=(String) entrada.getCiudad()%></p>
        <p>El Telefono ingresado es: <%=(String) entrada.getTelefono()%></p>
        <p>El Email ingresado es: <%=(String) entrada.getEmail()%></p>
        <p>El sexo ingresado es: <%=(String) entrada.getSexo()%></p>
        <p>La fecha de nacimiento ingresada es: <%=(String) entrada.getFechaDeNacimiento()%></p>
        <p> La persona es graduada: <%=(String) entrada.getGraduado()%></p>
        <p>El titulo ingresado es: <%=(String) entrada.getTitulo()%></p>
        <%}%>

        
    </body>
</html>
