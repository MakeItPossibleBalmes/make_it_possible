<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="<%= request.getContextPath()%>/tema" method="POST" class="form-horizontal centrado"
      role="form">
      <c:if test="${err != null}">
        <div class="alert alert-danger">
            <p>El tema no se ha podido añadir.</p>
        </div>
    </c:if>
    
    <div class="form-group">
        <label for="titulo" class="control-label">Título:</label>
        <input type="text" class="form-control" name="titulo" id="titulo" required />
    </div>

    <div class="form-group">
        <label for="cuerpo" class="control-label">Cuerpo:</label>
        <textarea rows="" cols="" name="cuerpo" id="cuerpo" class="form-control"></textarea>
    </div>
    
    <div class="form-group">
    	<label class="control-label">Categorias a las que pertenece:</label>
        <c:forEach var='categoria' items='${categorias }'>
        <div class='checkbox'>
        	<label for='categoria${ categoria.id }'>
        	<input type='checkbox' id='categoria${ categoria.id }' name='categorias' value='${ categoria.id }' />${categoria.nombre }</label>
       	</div>
        </c:forEach>
    </div>

    <div class="form-group">
        <input type="submit" value="Añadir" class="btn btn-default form-control" />
    </div>  

</form>