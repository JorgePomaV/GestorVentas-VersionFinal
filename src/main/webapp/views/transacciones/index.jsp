<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Transacciones</title>
    <link rel="stylesheet" type="text/css" href="css/estiloCliente.css">
</head>
<body>
    <div class="container">
        <h1>Detalles del usuario</h1>

        <p><strong>ID:</strong> <c:out value="${usuario.id}"></c:out></p>
        <p><strong>Nombre:</strong> <c:out value="${usuario.nombreUsuario}"></c:out></p>

        <div class="mt-3">
            <a href="TransaccionesController?accion=transferir&idDeudor=${usuario.id}" class="ver-carrito">Transferir Dinero</a>
            <a href="TransaccionesController?accion=registros&idUsuario=${usuario.id}" class="ver-carrito">Ver Registros de Transacciones</a>
        </div>
    </div>
</body>
</html>
