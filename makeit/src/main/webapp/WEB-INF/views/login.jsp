<%-- 
    Document   : register_view
    Created on : 20-Apr-2017, 16:08:14
    Author     : hartbold <ardevolp at gmail dot com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login- Make it Possible</title>
        <jsp:include page="include/styles.jsp"></jsp:include>
    </head>
    <body>
    <jsp:include page="include/head.jsp"></jsp:include>
        <div class="container" id="login-page">
            <jsp:include page="login_form.jsp"></jsp:include>
        </div>

        <jsp:include page="include/scripts.jsp"></jsp:include>
    </body>
    <jsp:include page="include/foot.jsp"></jsp:include>
</html>

