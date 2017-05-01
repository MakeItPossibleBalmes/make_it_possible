<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id='form-registro' action="<%= request.getContextPath()%>/registro" method="POST" class="form-horizontal centrado"
      role="form">
      
    <c:if test="${error != null}">
        <div class="alert alert-danger">
            <p><%= request.getAttribute("error") %></p>
        </div>
    </c:if>
      
    <div class="form-group">
        <label for="email" class="col-sm-3 control-label">Email*</label>
        <div class="col-sm-9">
            <div class="input-group">
                <span class="input-group-addon"><i
                        class="glyphicon glyphicon-envelope" aria-hidden="true"></i></span> <input
                    type="text" class="form-control" name="email" id="email" pattern="^([a-z0-9\_\-\.]+[@]{1}[a-z0-9\.\-]+[\.][a-z\.]{2,6})$" required />
            </div>
        </div>
    </div>

    <div class="form-group">
        <label for="password" class="col-sm-3 control-label">Contraseña* (min. 8 carácteres)</label>
        <div class="col-sm-9">
            <div class="input-group">
                <span class="input-group-addon"><i
                        class="glyphicon glyphicon-lock" aria-hidden="true"></i></span> <input
                    type="password" class="form-control" name="password" id="passowrd" required />
            </div>
        </div>
    </div>

    <div class="form-group">
        <label for="password-confirmation" class="col-sm-3 control-label">Confirma la Contraseña*</label>
        <div class="col-sm-9">
            <div class="input-group">
                <span class="input-group-addon"><i
                        class="glyphicon glyphicon-lock" aria-hidden="true"></i></span> <input
                    type="password" class="form-control" name="password-confirmation" id="password-confirmation" required />
            </div>
        </div>
    </div>
    <hr/>
    <div class="row">
        <div class="col-sm-12">
            <div class="row">
                <div class="col-sm-12">
                    <fieldset>
                        <legend><i class="glyphicon glyphicon-user" aria-hidden="true"></i> Datos Personales</legend>
                        <div class="row">
                            <div class="col-sm-5"> 
                                <div class="form-group">
                                    <label for="nombre" class="control-label">Nombre*</label>
                                    <input type="text" class="form-control" name="nombre" id="nombre" required placeholder="nombre" />
                                </div></div>
                            <div class=" col-sm-6 col-sm-offset-1">
                                <div class="form-group">
                                    <label for="primer_apellido" class="control-label">Apellido</label>
                                    <input type="text" class="form-control" name="primer_apellido" id="primer_apellido" required placeholder="apellido*"/>
                                </div>			
                            </div>
                        </div>
                </div>
            </div>



            </fieldset>

            <hr/>
            <div class="row">
                <div class="col-sm-12">
                    <fieldset>
                        <div class="row">
                            <div class="col-sm-5"> 
                                <div class="form-group">
                                    <label for="ciudad" class="control-label">Ciudad*</label>
                                    <input type="text" class="form-control" name="ciudad" id="ciudad" required />
                                </div>
                            </div>
                            <div class="col-sm-6 col-sm-offset-1">
                                <div class="form-group">
                                    <label for="pais" class="control-label">País*</label>
                                    <input type="text" class="form-control" name="pais" id="pais" required />
                                </div>
                            </div>
                        </div>
                    </fieldset>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-4 col-sm-offset-4">
                    <div class="form-group">
                        <input type="submit" value="Registrarme"
                               class="btn btn-success form-control" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</form>