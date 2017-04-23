<%-- 
    Document   : head
    Created on : 10-Apr-2017, 16:13:51
    Author     : hartbold <ardevolp at gmail dot com>
--%>
		<header>
			<nav class="navbar navbar-default navbar-static-top">
				<div class="container">
					<div class="navbar-header">
		
						<!-- Collapsed Hamburger -->
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#app-navbar-collapse">
							<span class="sr-only">Toggle Navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
		
						<!-- Branding Image -->
						<b><a class="navbar-brand" href="${pageContext.request.contextPath}/"> Make it Possible </a></b>
		
					</div>
		
					<div class="collapse navbar-collapse" id="app-navbar-collapse">
						<!-- Right Side Of Navbar -->
						<ul class="nav navbar-nav navbar-right">
							<%-- Si es guest --%>
							<li><a href="${pageContext.request.contextPath}/tema">Más Recientes</a></li>	
							<li><a href="${pageContext.request.contextPath}/login">Entrar</a></li>
							<li><a href="${pageContext.request.contextPath}/registro">Registrarse</a></li>					
							<%-- Si es usuario --%>							
							<li><a href="${pageContext.request.contextPath}/tema?create">Añadir Tema</a></li>
							<li><a href="${pageContext.request.contextPath}/user">Usuario</a></li>
							<li><a href="${pageContext.request.contextPath}/user?logout">Logout</a></li>
							<%-- Si es admin --%>
							<li><a href="${pageContext.request.contextPath}/categoria">Añadir Categoria</a></li>
							
							
						</ul>
					</div>
				</div>
			</nav>
		</header>

