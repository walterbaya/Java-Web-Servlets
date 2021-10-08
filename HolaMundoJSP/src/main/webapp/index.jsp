<%-- 
    Document   : index
    Created on : 20 dic. 2020, 11:39:38
    Author     : WalterAriel
--%>

<%--Se define la taglib con prefijo c, con el que luego sera llamado--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Hola mundo JSPs</title>
    </head>
    <body>
        <h1>Hola Mundo JSPs</h1>
        <ul>
            <%-- uso de scripplet --%>
            <%-- Ya tiene el out de tipo printWriter por defecto, el cual se puede usar para imprimirf --%>
            <li><% out.print("Hola mundo con Scripplets"); %></li>
            
            <%-- expression language usando el caracter $ para enviar informacion a nuestro cliente --%>
            <li> ${"Hola mundo con expression language"}</li>
            
            <%-- expresion común, usar de manera interna la variable out, todo se mandara a imprimir de manera automatica --%>
            <li><%= "Hola mundo con expresion" %></li>
            
            <%-- Utilizando jstl --%>
            <li> <c:out value="Hola Mundo con jstl" /> </li>
        </ul>
    </body>
</html>
