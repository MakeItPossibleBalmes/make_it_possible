<%-- 
    Document   : head
    Created on : 10-Apr-2017, 16:13:51
    Author     : hartbold <ardevolp at gmail dot com>
--%>
<%@page import="com.makeit.model.POJO.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">

				<!-- Collapsed Hamburger -->
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#app-navbar-collapse">
					<span class="sr-only">Toggle Navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

				<!-- Branding Image -->
				<b><a class="navbar-brand" href="${pageContext.request.contextPath}/"> Make it Possible </a></b>

			</div>

			<div class="collapse navbar-collapse" id="app-navbar-collapse">
				<!-- Right Side Of Navbar -->
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath}/tema">Más Recientes</a></li>
					<c:choose>
					    <c:when test="${sessionScope.usuario != null}">
					        <li><a href="${pageContext.request.contextPath}/tema?a=create">Añadir Tema</a></li>
					        <li><a href="${pageContext.request.contextPath}/categoria">Añadir Categoria</a></li>
					        <li class="dropdown active">
					        	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
					        	<%= ((Usuario) request.getSession().getAttribute("usuario")).getNombre() %> <span class="caret"></span></a> 
						        <ul class="dropdown-menu" role="menu">
						        	<li><a href="${pageContext.request.contextPath}/login?a=logout">Logout</a></li>
						        </ul>
					        </li>
					    </c:when>    
					    <c:otherwise>							        	
							<li><a href="${pageContext.request.contextPath}/login">Entrar</a></li>
							<li><a href="${pageContext.request.contextPath}/registro">Registrarse</a></li>
					    </c:otherwise>
					</c:choose>	
					
				</ul>
			</div>
		</div>
	</nav>
</header>

