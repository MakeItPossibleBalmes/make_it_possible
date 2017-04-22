<form id='form-registro' action="/registro" method="POST" class="form-horizontal centrado"
	role="form">
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email*</label>
		<div class="col-sm-10">
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-envelope" aria-hidden="true"></i></span> <input
					type="text" class="form-control" name="email" id="email" pattern="^([a-z0-9\_\-\.]+[@]{1}[a-z0-9\.\-]+[\.][a-z\.]{2,6})$" required />
			</div>
		</div>
	</div>

	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Contraseña*</label>
		<div class="col-sm-10">
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-lock" aria-hidden="true"></i></span> <input
					type="password" class="form-control" name="password" id="passowrd" required />
			</div>
		</div>
	</div>
	
	<div class="form-group">
		<label for="password-confirmation" class="col-sm-2 control-label">Confirma la Contraseña*</label>
		<div class="col-sm-10">
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-lock" aria-hidden="true"></i></span> <input
					type="password" class="form-control" name="password-confirmation" id="password-confirmation" required />
			</div>
		</div>
	</div>
	<hr/>
	<fieldset>
		<legend><i class="glyphicon glyphicon-user" aria-hidden="true"></i> Datos Personales</legend>
		<div class="form-group">
			<label for="nombre" class="control-label">Nombre*</label>
			<input type="text" class="form-control" name="nombre" id="nombre" required />
		</div>
		
		<div class="form-group">
			<label for="primer_apellido" class="control-label">Apellido</label>
			<div class="form-group">
				<div class="col-sm-6">
					<input type="text" class="form-control" name="primer_apellido" id="primer_apellido" required placeholder="Primer Apellido*"/>
				</div>
			</div>			
		</div>
	</fieldset>
	
	<hr/>
	<fieldset>
		<div class="form-group">
			<label for="ciudad" class="control-label">Ciudad*</label>
			<input type="text" class="form-control" name="ciudad" id="ciudad" required />
		</div>
		<div class="form-group">
			<label for="pais" class="control-label">País*</label>
			<input type="text" class="form-control" name="pais" id="pais" required />
		</div>
	</fieldset>

	<div class="form-group">
		<input type="submit" value="Registrarme"
			class="btn btn-default form-control" />
	</div>
</form>