<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="<%= request.getContextPath() %>/categoria" method="POST" class="form-horizontal centrado"
	role="form">
	<div class="form-group">
		<label for="nombre" class="control-label">Nombre</label>
		<input type="text" class="form-control" name="nombre" id="nombre"
					pattern="^[a-zA-ZñÑáéíóúÁÉÍÓÚ]+$" required />
	</div>

	<div class="form-group">
		<input type="submit" value="Añadir"
			class="btn btn-default form-control" />
	</div>
	
	<c:if test="${error}">
		<div class="alert alert-danger">
		  	<p>La categoría no se ha podido guardar.</p>
		</div>
	</c:if>
	
</form>