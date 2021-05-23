<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="ar.com.eduit.entidades.Producto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post", action="producto"> 
            Presentación: <input type="text" name="presentacion"/><br/>
            Cantidad: <input type="text" name="cantidad"/><br/>
            Precio: <input type="text" name="precio"/><br/>
            Descripcion: <input type="text" name="descripcion"/><br/>

            <input type="submit" name="command" value="Guardar"/>
            <input type="submit" name="command" value="Listar"/><br>
        </form>    
        <%--En items va el atributo de session, al cual podemos acceder
        podemos recorrer mensajes directamente sin necesariamente tener una lista--%>
        <c:forEach var="msg" items="${sessionScope.mensajes}">
        <li> <c:out value="${msg}"/></li>
        </c:forEach>

    <c:remove scope="session" var="mensajes" />

    <%List<Producto> productos = (List<Producto>) session.getAttribute("productos");%>

    <table border = "1">
        <tr>
            <td>Presentacion</td>
            <td>Cantidad</td>
            <td>Precio</td>
            <td>Descripcion</td>
            <td>Acciones</td>
        </tr>
        <c:forEach var="producto" items="${sessionScope.productos}">

            <tr>
                <td><c:out value="${producto.presentacion}"></c:out></td>
                <td><c:out value="${producto.cantidad}"></c:out></td>
                <td><c:out value="${producto.precio}"></c:out></td>
                <td><c:out value="${producto.descripcion}"></c:out></td>
                <td><a href="/SampleABM/producto?command=Borrar&id=<c:out value="${producto.id}"></c:out>">borrar</td>
                </tr>
        </c:forEach>
        <c:remove scope="session" var="productos" />

    </table>
</body>
</html>
