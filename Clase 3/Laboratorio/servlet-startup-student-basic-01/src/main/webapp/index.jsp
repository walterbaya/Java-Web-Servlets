<%-- 
    Document   : index
    Created on : 9 ene. 2021, 12:18:06
    Author     : WalterAriel
--%>

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
            <label>Sexo: <input type="text" name="sexo"/></label><br> 
            <label>Fecha de nacimiento: <input type="date" name="fechaDeNacimiento"/></label><br> 
            <label>Graduado: <input type="checkbox" name="graduado"/></label><br> 
            <label>Titulo: <input type="text" name="titulo"/></label><br>   
            <input type="submit" name="enviar">
        </form>
        <%HashMap<String, Object> entrada = (HashMap<String, Object>) session.getAttribute("salida");
          String nombre="";
          String apellido="";
          String dni="";
          String direccion="";
          String ciudad="";
          String telefono="";
          String email="";
          String sexo="";
          String fechaDeNacimiento="";
          String graduado="";
          String titulo="";
        %>
        <%if (entrada == null) {%>
        <p>De momento no se ingreso nada</p>
        <%} else {%>
        <p>Se ingresaron datos</p>
        <%
            nombre = (String) entrada.get("nombre");
            apellido = (String) entrada.get("apellido");
            dni = (String) entrada.get("dni");
            direccion = (String) entrada.get("direccion");
            ciudad = (String) entrada.get("ciudad");
            telefono = (String) entrada.get("telefono");
            email = (String) entrada.get("email");
            sexo = (String) entrada.get("sexo");
            fechaDeNacimiento = (String) entrada.get("fechaDeNacimiento");
            graduado = (String) entrada.get("graduado");
            titulo = (String) entrada.get("titulo");
        %>        
        <%}%>

        <h2>Informacion de estudiante</h2>
        <p>El nombre ingresado es: <%=nombre%></p>
        <p>El apellido ingresado es: <%=apellido%></p>
        <p>El dni ingresado es: <%=dni%></p>
        <p>La direccion ingresada es: <%=direccion%></p>
        <p>La ciudad ingresada es: <%=ciudad%></p>
        <p>El Telefono ingresado es: <%=telefono%></p>
        <p>El Email ingresado es: <%=email%></p>
        <p>El sexo ingresado es: <%=sexo%></p>
        <p>La fecha de nacimiento ingresada es: <%=fechaDeNacimiento%></p>
        <p> La persona es graduada: <%=graduado%></p>
        <p>El titulo ingresado es: <%=titulo%></p>

    </body>
</html>
