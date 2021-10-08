<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejercicio Formulario</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="Recursos/estilos.css" type="text/css"/>
        <script type="text/javascript" src="Recursos/funciones.js"></script>
    </head>
    <body>
        <form name="form1" action="/ManejoHttpFormulariosHTML/Servlet" method="post" onsubmit="return validarForma(this)">
            <input type="hidden" name="oculto" value="valorOculto"/> 
            <table width="200" id="enfasis-columna">
                <caption> 
                    Formulario Registro de Datos
                </caption>
                <tr>
                    <td class="columna">
                        Usuario: (*)
                    </td>
                    <td>
                        <input class="default" type="text" name="usuario" value="Escribir usuario" onfocus="this.select()"/>
                    </td>       
                </tr>
                <tr> 
                    <td class="columna">
                        Password: (*)
                    </td>
                    <td><!-- comment -->
                        <input class="default" type="password" name="password" onfocus="this.select()"/>
                    </td>
                </tr>
                <tr> 
                    <td class="columna">
                        Tecnologías de Internet: (*)
                    </td>
                    <td>
                        Java <input type="checkbox" name="tecnologia" value="java"/>
                        &nbsp;&nbsp;&nbsp;
                        .Net <input type="checkbox" name="tecnologia" value="net"/>
                        &nbsp;&nbsp;&nbsp;
                        Php <input type="checkbox" name="tecnologia" value="php"/>
                    </td>
                </tr>
                <tr><!-- comment -->
                    <td class="columna">
                        Genero: (*)
                    </td>
                    <td>
                        Hombre<input type="radio" name="genero" value="H"/>
                        &nbsp;&nbsp;&nbsp;
                        Mujer<input type="radio" name="genero" value="M"/>
                    </td>
                </tr>
                <tr><!-- comment -->
                    <td class="columna">
                        Ocupación: (*)
                    </td>
                    <td>
                        <select name="ocupacion" class="default">
                            <option value=""> Seleccionar </option>
                            <option value="1"> Profesor </option>
                            <option value="2"> Ingeníero </option>
                            <option value="3"> Jubílado </option>
                            <option value="4"> Otro </option>
                    </td>
                </tr>
                <tr><!-- comment -->
                    <td class="columna">
                        Música Favorita: 
                    </td>
                    <td>
                        <select name="musica" multiple class="default">
                            <option value="rock"> Rock</option>
                            <option value="pop"> Pop</option>
                            <option value="salsa"> Salsa</option>
                        </select>
                    </td>
                </tr>   
                <tr><!-- comment -->
                    <td class="columna">
                        Comentarios: 
                    </td>
                    <td>
                        <textarea name="comentarios" cols="30" rows="2" class="default" onfocus="this.select()"> 
                            Escribir un texto 
                        </textarea>
                    </td>
                </tr>   
                <tr style="text-align: center" ><!-- comment -->
                    <td class="columna">
                        <input type="reset" value="limpiar" class="default">
                    </td>
                    <td>
                        <input type="submit" value="enviar" class="default">
                    </td>
                </tr>   
            </table>
        </form>
    </body>
</html>
