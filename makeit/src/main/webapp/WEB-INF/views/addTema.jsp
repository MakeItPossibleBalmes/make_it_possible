<%-- 
    Document   : addTema
    Created on : Apr 23, 2017, 15:37:19 PM
    Author     : hartbold <ardevolp at gmail dot com>
--%>

<%@page import="javax.annotation.Resource"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make it Possible - Añadir Tema</title>
        <jsp:include page="include/styles.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="include/head.jsp"></jsp:include>

            <div class="container" id="categoria">
                <h1>Crea un nuevo Tema</h1>
                <jsp:include page="include/tema_form.jsp"></jsp:include>
            </div>

        <jsp:include page="include/foot.jsp"></jsp:include>

        <jsp:include page="include/scripts.jsp"></jsp:include>
    </body>    
</html>
