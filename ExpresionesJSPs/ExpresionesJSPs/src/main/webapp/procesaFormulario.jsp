<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Procesa formulario</title>
    </head>
    <body>
        <h1>Resultado de procesar el formularios</h1>
        Usuario: <%= request.getParameter("usuario") %>
        <br>
        Contraseña: <%= request.getParameter("password") %>
        <br>
        <br>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
