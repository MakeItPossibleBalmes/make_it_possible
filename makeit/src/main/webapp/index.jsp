<%-- 
    Document   : index
    Created on : Apr 5, 2017, 6:00:19 PM
    Author     : hartbold <ardevolp at gmail dot com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make it Happen</title>
        <jsp:include page="/WEB-INF/views/include/styles.jsp"></jsp:include>
            <!--        <link rel="stylesheet" type="text/css" href="/css/app.css"/>-->
        <style>    
            #home-page form.centrado {
                max-width: 300px;
                display: block;
                margin: 0 auto;
            }
        </style>
    </head>
    <body>
    <jsp:include page="WEB-INF/views/include/head.jsp"></jsp:include>
        <div class="container" id="home-page">
            <form action="/login" method="POST" class="form-horizontal centrado" role="form">
                <div class="form-group">
                    <label for="usuario" class="cols-sm-2 control-label">Usuario</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="usuario" id="usuario"  placeholder="Escribe tu DNI" pattern="^[0-9]{8}[a-zA-Z]$" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="cols-sm-2 control-label">Contraseña</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock" aria-hidden="true"></i></span>
                            <input type="password" class="form-control" name="password" id="passowrd"  placeholder="Introduce tu contraseña" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="checkbox">
                        <label for="recordarme">
                            <input type="checkbox" name="recordarme" id="recordarme"/> Recordarme
                        </label>
                    </div>
                </div>

                <div class="form-group">
                    <input type="submit" value="Entrar" class="btn btn-default form-control"/>
                </div>

                <div>
                    <p>No tienes una cuenta? <a href="/registro">Regístrate</a>!</p>
                </div>
            </form>
        </div>

        <jsp:include page="WEB-INF/views/include/scripts.jsp"></jsp:include>
    </body>
</html>
