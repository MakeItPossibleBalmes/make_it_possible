<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="<%= request.getContextPath()%>/tema" method="POST" class="form-horizontal centrado"
      role="form">
    <div class="form-group">
        <label for="titulo" class="control-label">Título</label>
        <input type="text" class="form-control" name="titulo" id="titulo" required />
    </div>

    <div class="form-group">
        <label for="cuerpo" class="control-label">Cuerpo</label>
        <textarea rows="" cols="" name="cuerpo" id="cuerpo" class="form-control"></textarea>
    </div>

    <div class="form-group">
        <input type="submit" value="Añadir" class="btn btn-default form-control" />
    </div>

    <c:if test="${error}">
        <div class="alert alert-danger">
            <p>El tema no se ha podido añadir.</p>
        </div>
    </c:if>

</form>