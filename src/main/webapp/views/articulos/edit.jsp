<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Artículo</title>
<link rel="stylesheet" href="css/estiloAdmin.css">

</head>
<body>
	<div class="container mt-5">
    <h1 class="text-center mb-4">Editar Artículo</h1>

    <form action="articulos" method="post" class="form-group">
        <input type="hidden" name="accion" value="update">
        <input type="hidden" name="codigo" value="${articulo.codigo}"> 
        
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre:</label>
            <input type="text" id="nombre" name="nombre" class="form-control" value="${articulo.nombre}" required>
        </div>
        <div class="mb-3">
            <label for="descripcion" class="form-label">Descripción:</label>
            <input type="text" id="descripcion" name="descripcion" class="form-control" value="${articulo.descripcion}" required>
        </div>
        <div class="mb-3">
            <label for="precio" class="form-label">Precio:</label>
            <input type="number" id="precio" step="0.01" name="precio" class="form-control" value="${articulo.precio}" required>
        </div>
        <div class="mb-3">
            <label for="stock" class="form-label">Stock:</label>
            <input type="number" id="stock" name="stock" class="form-control" value="${articulo.stock}" required>
        </div>

        <button type="submit" class="btn btn-danger">Guardar Cambios</button>
		<a href="${pageContext.request.contextPath}/articulos?accion=volverAIndexAdmin" class="btn btn-link mt-3">Volver a la lista</a>
    </form>
</div>
</body>
</html>