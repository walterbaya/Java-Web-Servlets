<%@page import="ar.com.eduit.entidades.Producto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

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

        <%List<String> mensajes =(List<String>)session.getAttribute("mensajes");
            if(mensajes != null){%>
        <ul> 
            <%for(String a : mensajes){%>
            <li><%=a.toString()%></li>
        </ul>
        <% } } %>
        
        <%List<Producto> productos =(List<Producto>) session.getAttribute("productos");%>
        
        <table border = "1">
            <tr>
                <td>Presentacion</td>
                <td>Cantidad</td>
                <td>Precio</td>
                <td>Descripcion</td>
                <td>Acciones</td>
            </tr>
            <%if(productos != null){%>
                <% for(Producto a : productos){%>
                <tr>
                    <td><%=a.getPresentacion()%></td>
                    <td><%=a.getCantidad()%></td>
                    <td><%=a.getPrecio()%></td>
                    <td><%=a.getDescripcion()%></td>
                    <td><a href="/SampleABM/producto?command=Borrar&id=<%=a.getId()%>">borrar</td>
                </tr>
                <%} }%>
                <%session.removeAttribute("productos");%>
                <%session.removeAttribute("mensajes");%>
        </table>
    </body>
</html>
