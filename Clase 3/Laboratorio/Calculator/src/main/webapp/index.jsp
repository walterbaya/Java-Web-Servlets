<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculator</title>
    </head>
    <body>
        <%String result = request.getParameter("result");%>
        <h1 style="text-align: center;">Calculator</h1>
        <form method="post" action="action" style="display: flex;
              flex-direction: column;
              align-items: center;">
            <input name="operator1" placeholder="Operando1" style="margin-bottom: 1em;" required>
            <input name="operator2" placeholder="Operando2" required> 
            <div style="padding-left: 1em; padding-right: 1em;font-size: 1.5em;" required>=</div>
            <input type="text" value="<%=result%>">
            <div style="padding: 2em;">
                <input type="radio" style="font-size: 2em; margin:0.5em;" value="adition" name="operation" required>+</input>
                <br>
                <input type="radio" style="font-size: 2em; margin:0.5em;" value="substraction" name="operation">-</input>
                <br>
                <input type="radio" style="font-size: 2em; margin:0.5em;" value="product" name="operation">x</input>
                <br>
                <input type="radio" style="font-size: 2em; margin:0.5em;" value="divide" name="operation">/</input>
            </div>
            <input type="submit" value="Calcular">
        </form>
    </body>
</html>
