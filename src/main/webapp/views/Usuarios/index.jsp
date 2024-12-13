<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios</title>
</head>
<body>
<h1>Usuarios</h1>

<a href="usuarios?accion=create">Agregar Usuario</a>

<table border="1">
<thead>
	<tr>
		<th>ID</th>
		<th>NombreUsuario</th>
		<th>Contraseña</th>
		<th>Saldo</th>
		<th>Tipo</th>
	</tr>
</thead>
<tbody>
	<c:forEach var="usuario" items="${listarda}">
		<tr>
			<td> <c:out value="${usuario.id}"></c:out> </td>
			<td> <c:out value="${usuario.nombreUsuario}"></c:out> </td>
			<td> <c:out value="${usuario.contrasenia}"></c:out> </td>
			<td> <c:out value="${usuario.saldoActual}"></c:out> </td>
			<td> <c:out value="${usuario.tipo}"></c:out> </td>
			<td> <a href="usuarios?accion=show&id=${usuario.id}">Ver</a> </td>
	</c:forEach>

</tbody>

</table>

</body>
</html>