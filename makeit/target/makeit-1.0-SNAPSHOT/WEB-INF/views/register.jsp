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
        <title>Registro- Make it Possible</title>
        <jsp:include page="include/styles.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="include/head.jsp"></jsp:include>
            <div class="container" id="register-page">
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3">
                        <h2 class="text-center">
                            Únete a Make It Possible

                            <br />
                        </h2>
                        <p class="text-center">Forma parte de la mayor comunidad de propuestas. Tú haces la portada.</p>
                    </div>
                </div>
                        <div class="row"><div class="col-sm-6 col-sm-offset-3 text-center">
                                <%
                                    //de momento no funciona
                                    if(request.getParameter("error")!=null){
                                        out.print("<p><strong>"+request.getParameter("error")+"</strong><p>");
                                    }else{
                                        //out.print("es null");
                                    }
                                %>
                    </div></div>
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3">
                    <jsp:include page="include/register_form.jsp"></jsp:include>
                    </div>
                </div>
            </div>

        <jsp:include page="include/scripts.jsp"></jsp:include>
        </body>
    <jsp:include page="include/foot.jsp"></jsp:include>
</html>

