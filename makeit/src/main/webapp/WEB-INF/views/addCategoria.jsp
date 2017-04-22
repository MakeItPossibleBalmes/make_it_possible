<%-- 
    Document   : categoria
    Created on : Apr 22, 2017, 16:17:19 PM
    Author     : hartbold <ardevolp at gmail dot com>
--%>

<%@page import="com.makeit.model.POJO.Categoria"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make it Possible - Añadir Categoria</title>
        <jsp:include page="/WEB-INF/views/include/styles.jsp"></jsp:include>
    </head>
    <body>
    <jsp:include page="include/head.jsp"></jsp:include>
        
        <div class="container" id="categoria">
        	 <jsp:include page="include/categoria_form.jsp"></jsp:include>
        </div>
        
        <jsp:include page="include/foot.jsp"></jsp:include>

        <jsp:include page="include/scripts.jsp"></jsp:include>
    </body>    
</html>
