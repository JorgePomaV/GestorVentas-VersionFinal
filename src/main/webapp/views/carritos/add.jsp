<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Añadir Articulo</title>
  	<link rel="stylesheet" href="css/estiloCliente.css">
</head>
<body class="container">
    <c:if test="${not empty error}">
        <div class="error-box mt-3">
            ${error}
        </div>
    </c:if>
    <form action="Carritos" method="post" class="mt-3">
        <input type="hidden" name="accion" value="insert">
        <input type="hidden" name="idUsuario" value="${idUsuario}">
        <p class="mt-3">
            Código: <span>${articulo.codigo}</span>
            <input type="hidden" name="codigo" value="${articulo.codigo}">
        </p>
        <p class="mt-3">
            Nombre: <span>${articulo.nombre}</span>
            <input type="hidden" name="nombre" value="${articulo.nombre}">
        </p>
        <p class="mt-3">
            Descripción: <span>${articulo.descripcion}</span>
            <input type="hidden" name="descripcion" value="${articulo.descripcion}">
        </p>
        <p class="mt-3">
            Precio: <span>${articulo.precio}</span>
            <input type="hidden" name="precio" value="${articulo.precio}">
        </p>
        <p class="mt-3">
            Cantidad:
            <input type="number" name="cantidad" value="1">
        </p>
        <button type="submit" class="ver-carrito">Agregar al carrito</button>
    </form>
</body>
</html>
