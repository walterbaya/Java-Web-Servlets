<%@page import="utilerias.Conversiones, java.util.Date"  %>
<%@page contentType="application/vnd.ms-excel" %>
<!Redirigimos el flujo en caso de error a manejo errores.jsp>
<%@page errorPage="/WEB-INF/manejoErrores.jsp" %>
<!Debe ser un JSP privado, para que solo los JSP o servlet puedan acceder por eso lo metemos en webINF>
<%
    String nombreArchivo = "reporte.xls";
    //Hay que cambiar de attachment a inline para poder dirigirnos al jsp en caso de error
    //response.setHeader("Content-Disposition", "attachment;filename=" + nombreArchivo);
    response.setHeader("Content-Disposition", "inline;filename=" + nombreArchivo);
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Reporte de Excel</title>
    </head>
    <body>
        <h1>Reporte de Excel</h1>
        <br/>
        <table border="1">
            <tr>
                <th>Curso</th>
                <th>Descripcion</th>
                <th>Fecha</th>
            </tr>
            <tr>
                <td>1. Fundamentos de Java</td>
                <td>Aprenderemos la sintaxis basica de Java</td>
                <td><%= Conversiones.format(250)%></td>
            </tr>
            <tr>
                <td>2. Programacion con Java</td>
                <td>Pondremos en practica conceptos de la programacion orientada a objetos</td>
                <td><%= Conversiones.format(new Date())%></td>
            </tr>
        </table>
    </body>
</html>
