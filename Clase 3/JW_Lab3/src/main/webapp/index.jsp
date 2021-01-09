<%@page import="ar.educacionit.com.models.Auto"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%Map<String, String> valida = (Map<String, String>) session.getAttribute("validaciones");%>
        <%if (valida == null) {
                valida = new HashMap<String, String>();
            }
        %>
        <form method="post" action="action">

            Marca: <input type="text" name="marca" />
            <br> 
            <div style="color: red">
                <%=valida.getOrDefault("marca", "")%>
            </div>
            <br>
            Modelo: <input type="text" name="modelo" />
            <br>
            <div style="color: red">
                <%=valida.getOrDefault("modelo", "")%>
            </div>
            <br>
            <input type="submit" value="guardar" /> 

        </form>
        <!--El request lo recibe el jsp como resultado de la respuesta generada por el
         servlet.-->

        <%session.removeAttribute("validaciones");%>


        <%String mensaje = request.getParameter("mensaje");%>
        <%if (mensaje != null && !mensaje.isEmpty()) {%>
        <p style="color: red">
            <%=mensaje%>
        </p>
        <%}%>

        <%List<Auto> autos = (List<Auto>) session.getAttribute("autos"); %>
        <table border="1">
            <tr>
                <td>Marca</td>
                <td>Modelo</td>
            </tr>
            <%if (autos != null) {%>
                <%for (Auto a : autos) { %>
                <tr>
                    <td><%=a.getMarca()%></td>
                    <td><%=a.getModelo()%></td>
                </tr>
                <%}%>
                <%session.removeAttribute("autos");%>
            <%}%>
        </table>
    </body>
</html>
