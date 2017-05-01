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
                <br/>
                <c:forEach var="tema" items="${recientes}">	
                	<div class="bloque-tema-min panel panel-body panel-default col-sm-4 col-sm-offset-1" id="tema-${tema.id}">
<%-- 					    <p>${tema.categorias }</p> --%>
					    <h3>${tema.titulo } <small>- creado por ${tema.usuario.nombre }</small></h3>
					    <p>${tema.cuerpo }</p>
					    <div class="row">
					    	<div class="col-xs-8">
<%-- 					    		<p>${tema.votos.length() }</p> --%>
					    	</div>
					    	<div class="col-xs-4">
					    		<a class="btn" href='#'><i class='glyphicon glyphicon-thumbs-up'></i>Votar</a>
					    	</div>
					    </div>
					</div>
                </c:forEach>
                
            </div>

        <jsp:include page="include/foot.jsp"></jsp:include>

        <jsp:include page="include/scripts.jsp"></jsp:include>
    </body>    
</html>
