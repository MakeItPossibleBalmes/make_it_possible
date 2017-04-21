<%-- 
    Document   : index
    Created on : Apr 5, 2017, 6:00:19 PM
    Author     : hartbold <ardevolp at gmail dot com>
--%>

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
			<c:forEach var=destacado items="${destacados}">		
				{destacado.titulo}	
			</c:forEach>
        </div>

        <jsp:include page="WEB-INF/views/include/scripts.jsp"></jsp:include>
    </body>
    
    <jsp:include page="WEB-INF/views/include/foot.jsp"></jsp:include>
</html>
