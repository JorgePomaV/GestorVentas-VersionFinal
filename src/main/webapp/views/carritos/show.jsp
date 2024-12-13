<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalles del Artículo</title>
<link rel="stylesheet" href="css/estiloCliente.css">
</head>
<body>
	<div class="container">
        <h1>Detalles del Artículo</h1>
        <form action="Carritos" method="post">
            <input type="hidden" name="accion" value="insert">
            
            <div class="form-group">
                <label>Código:</label>
                <span><c:out value="${articulo.codigo}" /></span>
            </div>

            <div class="form-group">
                <label>Nombre:</label>
                <span><c:out value="${articulo.nombre}" /></span>
            </div>

            <div class="form-group">
                <label>Descripción:</label>
                <span><c:out value="${articulo.descripcion}" /></span>
            </div>

            <div class="form-group">
                <label>Precio:</label>
                <span><c:out value="${articulo.precio}" /></span>
            </div>

            <button type="submit" class="button">Agregar al Carrito</button>
        </form>
    </div>
</body>
</html>