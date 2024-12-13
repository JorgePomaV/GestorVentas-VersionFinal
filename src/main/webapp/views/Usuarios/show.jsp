<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mostrar Usuario</title>
    <link rel="stylesheet" href="css/estiloAdmin.css">
</head>
<body>

<div class="container mt-5">
    <h1 class="text-center">Detalles del Usuario</h1>

    <div class="user-details">
        <p><strong>Nombre de Usuario:</strong> <c:out value="${usuario.nombreUsuario}"></c:out></p>
        <p><strong>Contraseña:</strong> <c:out value="${usuario.contrasenia}"></c:out></p>
        <p><strong>Saldo:</strong> <c:out value="${usuario.saldoActual}"></c:out></p>
        <p><strong>Tipo:</strong> <c:out value="${usuario.tipo}"></c:out></p>
    </div>

    <form action="usuarios" method="post" class="d-inline">
        <input type="hidden" name="id" value="${usuario.id}">
        <input type="hidden" name="accion" value="delete">
        <button type="submit" class="btn btn-danger btn-sm">Eliminar Usuario</button>
    </form>
    <a href="${pageContext.request.contextPath}/articulos?accion=volverAIndexAdmin" class="btn btn-link mt-3">Volver a la lista</a>
   
</div>

</body>
</html>
