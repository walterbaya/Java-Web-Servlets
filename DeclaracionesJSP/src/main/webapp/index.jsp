<%--Agregamos una declaracion de JSP

Todo el codigo se agregara como parte de la clase servlet asociada al JSP
Lo que agregamos dentro de un scriplet en cambio no se agrega dentro de la clase
sino que se agrega dentro del metodo jsp service.
Con la declaracion podemos utilizarlas dentro y fuera de esos metodos
--%>

<%!
    //Declaramos una variable con su metodo get.
    private String usuario = "Alberto";
    
    public String getUsuario(){
        return this.usuario;
    }
    //Declaramos un contador de visitas
    
    private int contadorVisitas = 1;

    
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uso de declaraciones con JSPs</title>
    </head>
    <body>
        <h1>Uso de declaraciones con JSPs</h1>
        Valor de usuario por medio del atributo: <%= this.usuario %>
        <br>
        Valor usuario por medio del metodo: <%= this.getUsuario() %>
        <br>
        Valor de contador de visitas: <%= this.contadorVisitas++ %>
    </body>
</html>
