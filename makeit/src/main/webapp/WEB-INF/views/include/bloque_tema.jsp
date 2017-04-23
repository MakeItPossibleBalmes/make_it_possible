<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="bloque-tema-min" id="tema-${tema.id}">
    <p>${tema.categorias }</p>
    <h3>${tema.titulo }</h3>
    <div class="row">
        <div class="col-xs-8 autor">
            <p>${tema.categorias }</p>
        </div>
        <div class="col-xs-4 votos">
            <%-- <p>${fn:length(tema.votos)}</p> --%>
        </div>
    </div>
</div>