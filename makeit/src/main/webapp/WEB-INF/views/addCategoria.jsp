<%-- 
    Document   : categoria
    Created on : Apr 22, 2017, 16:17:19 PM
    Author     : hartbold <ardevolp at gmail dot com>
    Vista de administrador: Administración de categorías.
--%>

<%@page import="javax.annotation.Resource"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make it Possible - Categorias</title>
        <jsp:include page="/WEB-INF/views/include/styles.jsp"></jsp:include>
    </head>
    <body>
    <jsp:include page="include/head.jsp"></jsp:include>
        
        <div class="container" id="categoria">
        	<h1>Categorías</h1>
        	<div class="row">
        		<div class="col-sm-7">
        			<h3>Listado</h3>
        			<p class="desc">Estas son la categorías que existen actualmente. Crea una nueva o selecciona la categoría que desees borrar.</p>
        			<br/>
        			<table class="table">
        				<c:forEach var="categoria" items="${categorias}">
        					<tr><td>${ categoria.nombre }</td><td><a href="<%= request.getContextPath() %>/categoria?delete=${categoria.id}"><i class="glyphicon glyphicon-trash"></i></a></td></tr>
        				</c:forEach>        				
        			</table>
        			<c:if test="${ errorDelete }">
        				<div class="alert alert-danger">
						  	<p>La categoría no se ha podido eliminar.</p>
						</div>
        			</c:if>
        		</div>
        		<div class="col-sm-4 col-sm-offset-1">
        			<h3>Crea una nueva categoría</h3>
        			<jsp:include page="include/categoria_form.jsp"></jsp:include>
        		</div>
        	</div>
        	 
        </div>
        
        <jsp:include page="include/foot.jsp"></jsp:include>

        <jsp:include page="include/scripts.jsp"></jsp:include>
    </body>    
</html>
