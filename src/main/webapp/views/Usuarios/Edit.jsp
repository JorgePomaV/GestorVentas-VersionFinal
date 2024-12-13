<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar</title>
</head>
<body>
		<h1>Editar</h1>
		<form action="" method="post">
			<p>
				Usuario: <input value="${usuario.nombreUsuario}" name="nombreUsuario" />
			</p>
			<p>
				Contraseña: <input value="${usuario.contrasenia}" name="contrasenia" />
			</p>
			<p>
				Saldo: <input value="${usuario.saldoActual}" name="saldoActual" />
			</p>
			<input type="submit" value="Enviar"/>
		</form>
</body>
</html>