<form action="<%= request.getContextPath() %>/login" method="POST" class="form-horizontal centrado"
	role="form">
	<div class="form-group">
		<label for="email" class="cols-sm-2 control-label">Email</label>
		<div class="cols-sm-10">
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-envelope" aria-hidden="true"></i></span> <input
					type="text" class="form-control" name="email" id="email"
					pattern="^([a-z0-9\_\-\.]+[@]{1}[a-z0-9\.\-]+[\.][a-z\.]{2,6})$" required />
			</div>
		</div>
	</div>

	<div class="form-group">
		<label for="password" class="cols-sm-2 control-label">Contraseña</label>
		<div class="cols-sm-10">
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-lock" aria-hidden="true"></i></span> <input
					type="password" class="form-control" name="password" id="passowrd"
					placeholder="Introduce tu contraseña" required />
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="checkbox">
			<label for="recordarme"> <input type="checkbox"
				name="recordarme" id="recordarme" /> Recordarme
			</label>
		</div>
	</div>

	<div class="form-group">
		<input type="submit" value="Entrar"
			class="btn btn-default form-control" />
	</div>

	<div>
		<p>
			No tienes una cuenta? <a href="/registro">Regístrate</a>!
		</p>
	</div>
</form>