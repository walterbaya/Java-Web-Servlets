<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%--
<%@taglib prefix="xml" uri="http://java.sun.com/jsp/jstl/xml"%>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%-- Asignacion con set --%>

        <c:set var="Income" scope="session" value="${4000*4}"/>
        <c:out value="${Income}"/>
        <br><hr>

        <%-- Prueba con WHEN --%>
        <c:set var="Income" scope="session" value="${4000*4}"/>
        <p>Su valor de income es: <c:out value="${Income}"/> </p>
        <c:choose>
            <c:when test="${Income<= 1000}">
                Income no es bueno.
            </c:when>
            <c:when test="${Income> 1000}">
                Income es muy bueno.
            </c:when>
            <c:otherwise>
                Income indeterminado 
            </c:otherwise>
        </c:choose>

        <c:forEach var="j" begin="1" end="5">
            <p>Item: <c:out value="${j}" /></p>
        </c:forEach>

        <%-- Prueba con condicional y redireccionamiento --%>
        <br><hr>
        <%--
        <c:set var="url" value="0" scope="request" />
        <c:if test="${url < 1}">
            <c:redirect url="https://google.com" />
        </c:if>
        
        --%>
        <br><hr>
        <%--Prueba con Funciones --%>
        <c:set var="str1" value="Welcome-to-JSP-Programming."  />
        <c:set var="str2" value="${fn:split(str1, '-' )}" /> 
        <c:set var="str3" value="${fn:join(str2, ' ')}" /> 
        <p>String3: ${str3}</p> 
        <c:set var="cadena" value="Esta es mi primer cadena" />
        Cadena Parseada: ${fn:substring(cadena,6,20)}
        
        <%--Prueba con Formatos--%>
        <c:set var="MiFecha" value="09-09-2019" />
        <fmt:parseDate value="${MiFecha}" var="parseDate" pattern="dd-MM-yyyy" />
        <p>Fecha Parseada: <c:out value="${parseDate}"/></p>
    </body>
</html>
