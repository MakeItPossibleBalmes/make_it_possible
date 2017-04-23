<%-- 
    Document   : temasRecientes
    Created on : 23-Apr-2017, 15:17:56
    Author     : hartbold <ardevolp at gmail dot com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make it Possible - Temas Recientes</title>
        <jsp:include page="include/styles.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="include/head.jsp"></jsp:include>

            <div class="container" id="temas-categoria">
                <h1>Temas Recientes</h1>
                <p class="desc">Temas ordenados por la fecha en que fueron creados</p>
                <c:forEach var="tema" items="${recientes}">		
                    <jsp:include page="include/bloque_tema.jsp"></jsp:include>
                </c:forEach>
            </div>

        <jsp:include page="include/foot.jsp"></jsp:include>

        <jsp:include page="include/scripts.jsp"></jsp:include>
    </body>    
</html>
