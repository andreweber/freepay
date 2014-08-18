<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>FreePay</title>
	<style type="text/css">
		.oculto {
			display:none;
		}
		.form {
			width:100%;
			display:block;
		}
		.inlineForm {
			display:inline;
		}
		.titulo {
		}
		.error {
			color:red;
		}
	</style>
	<script type="text/javascript">
		function validarLogin() {
			var usuario = document.getElementById('usuario').value;
			var clave = document.getElementById('clave').value;
			var nombreUsuario;
			
			if(usuario && clave) {
				nombreUsuario = getNombreUsuario(usuario, clave);
				
				if(nombreUsuario) {
					document.getElementById('formLogin').className = 'oculto';
					document.getElementById('formApp').className = 'form';
					limpiarMensajes('');
					document.getElementById('nombreUsuario').innerHtml = nombreUsuario;
				} else {
					mostrarMensajeError('Usuario y/o calve no válidos.');
				}
			} else {
				mostrarMensajeError('Usuario y/o calve no válidos.');
			}
		}
		
		function getNombreUsuario(usuario, clave) {
			if(usuario == 'david' && clave == 'david') {
				return 'David Arango';
			} else if(usuario == 'andres' && clave == 'andres') {
				return 'Andrés González';
			} else {
				return null;
			}
		}
		
		function mostrarMensajeError(mensaje) {
			var mensajes = document.getElementById('mensajes'); 
			mensajes.className = 'error';
			mensajes.innerHTML = mensaje;
			setTimeout(function(){limpiarMensajes();}, 3000);
		}
		
		function limpiarMensajes() {
			var mensajes = document.getElementById('mensajes'); 
			mensajes.className = '';
			mensajes.innerHTML = '';
		}
	</script>
</head>
<body>
	<h1 class="titulo">Free Pay</h1>
	<span id="mensajes"></span>
	<div id="formLogin" class="form">
		<span class="inlineForm">
			Usuario&nbsp;
			<input type="text" id="usuario"/>
		</span>
		<span class="inlineForm">
			Clave&nbsp;
			<input type="password" id="clave"/>
		</span>
		<br/>
		<span class="inlineForm">
			<input type="button" value="login" onclick="validarLogin();" />
		</span>
	</div>
	<div id="formApp" class="oculto">
		<p>
			Bienvenido <span id="nombreUsuario"></span> al sistema de pagos para corresponsales no bancarios.
		</p>
	</div>
</body>
</html>