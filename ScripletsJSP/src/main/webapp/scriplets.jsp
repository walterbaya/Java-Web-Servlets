<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Scriptlets</title>
    </head>
    <body>
        <h1>JSP con Scriptlet</h1>
        <br>
        <%--Los comentarios de html se despliegan al navegador, pero estos de JSP no
            Scriptlet para enviar al navegador--%>
        <%
            out.print("Saludos desde un scriptlet");
        %>
        
        <%--Scriptlet para manipular los objetos implicitos--%>
        
        <%
            String nombreAplicacion = request.getContextPath();
            out.print("nombre de la aplicacion: " + nombreAplicacion);
        %>
        
        <br>
        
        <%--Scriptlet con codigo condicionado--%>
        
        <%
            if(session != null && session.isNew()){
        %>
        La sesion SI es nueva
        
        <%
            }else if(session != null){
        %>
        la sesion NO es nueva
        <% } %>
        
       <a href="index.jsp">Regreso a inicio</a>
    </body>
</html>
