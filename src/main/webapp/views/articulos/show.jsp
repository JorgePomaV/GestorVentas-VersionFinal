<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalles del Artículo</title>
<link rel="stylesheet" href="css/estiloAdmin.css"> 
</head>
<body>
	<div class="container mt-5">
    <h1 class="text-center mb-4">Detalles del Artículo</h1>
    <table class="table table-striped table-bordered">
        <tbody>
            <tr>
                <th>Código</th>
                <td><c:out value="${articulo.codigo}" /></td>
            </tr>
            <tr>
                <th>Nombre</th>
                <td><c:out value="${articulo.nombre}" /></td>
            </tr>
            <tr>
                <th>Descripción</th>
                <td><c:out value="${articulo.descripcion}" /></td>
            </tr>
            <tr>
                <th>Precio</th>
                <td>$<c:out value="${articulo.precio}" /></td>
            </tr>
            <tr>
                <th>Stock</th>
                <td><c:out value="${articulo.stock}" /></td>
            </tr>
        </tbody>
    </table>
	<a href="${pageContext.request.contextPath}/articulos?accion=volverAIndexAdmin" class="btn btn-link mt-3">Volver a la lista</a></div>
</body>
</html>