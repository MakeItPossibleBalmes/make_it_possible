<%-- 
    Document   : index
    Created on : Apr 5, 2017, 6:00:19 PM
    Author     : hartbold <ardevolp at gmail dot com>
--%>

<%@page import="com.makeit.model.POJO.Categoria"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make it Possible</title>
        <jsp:include page="/WEB-INF/views/include/styles.jsp"></jsp:include>
    </head>
    <body>
    <jsp:include page="WEB-INF/views/include/head.jsp"></jsp:include>
        
        <div class="container" id="home-page">
        	<h1>Make it Possible y tal</h1>
        	<p>Descripción de qué consiste esta web u otro texto de relleno</p>
        	<div class="row">
				<!-- Contenido Principal -->
        		<div class="col-sm-9" id="destacados">
        			<h3>Temas Destacados</h3>
					<c:forEach var="tema" items="${destacados}">	
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
				<!-- Barra Lateral -->
        		<div class="col-sm-3">
        			<div id="categorias">
        				<h3>Categorías</h3>
        				<c:forEach var="categoria" items="${categorias}">
        					In		
	        				<div class='tag-big'>
	        					<a href="<%= request.getContextPath() %>/categoria?q=${categoria.id}" class="btn btn-link">${categoria.nombre}</a>
	        				</div>
						</c:forEach>
        			</div>
        			
        			<div id="mejorValorados">
        				<h3>Temas Mejor Valorados</h3>
        				<c:forEach var="tema" items="${mejorValorados}">		
	        				<jsp:include page="WEB-INF/views/include/bloque_tema.jsp"></jsp:include>
						</c:forEach>
        			</div>
        			
        		</div>
        	</div>		
			
        </div>
        
        <jsp:include page="WEB-INF/views/include/foot.jsp"></jsp:include>

        <jsp:include page="WEB-INF/views/include/scripts.jsp"></jsp:include>
    </body>    
</html>
