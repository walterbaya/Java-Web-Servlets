<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>El. y Variables Implicitas</title>
    </head>
    <body>
        <h1>El. y Variables Implicitas</h1>
        <ul>
            <!--El page context nos da toda la informacion relacionada
            con el JSP que se está ejecutando
            podemos acceder al contextPath, que manda a llamar al metodo getContextPath-->
            <li>Nombre de la aplicación: ${pageContext.request.contextPath}</li>
            <!--Accedemos a una propiedad del Header utilizando [] en vez de metodos.-->
            <li>Navegador del Cliente: ${header["User-Agent"]}</li>
            <!--Accedemos al valor de la sesion utilizando la cookie-->
            <li>Id Sesion: ${cookie.JSESSIONID.value}</li>
            <!--Obtenemos el nombre del servidor-->
            <li>Web Server: ${pageContext.servletContext.serverInfo}</li>
            <!--Accedemos al parametro que habiamos enviado-->
            <li>Valor Parametro: ${param.usuario}</li>
            <!--Tambien se podria hacer con corchetes, por ser param un map-->
        </ul>
        <br/>
        <br/>
        <a href="index.jsp">Regresar al Inicio</a>
        
    </body>
</html>
