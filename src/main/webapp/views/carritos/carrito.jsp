<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Carrito</title>
  	<link rel="stylesheet" href="css/estiloCliente.css">
</head>
<body class="container">
	<h1>Carrito</h1>
	<table>
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Descripción</th>
				<th>Precio</th>
				<th>Cantidad</th>
				<th>Código</th>
				<th></th>
				<th></th>
				<th></th>
			</tr> 
		</thead>
		<tbody>
	    	<c:forEach var="articulo" items="${articulos}">
				<tr>
					<td><c:out value="${articulo.nombre }" /></td>
					<td><c:out value="${articulo.descripcion }" /></td>
					<td><c:out value="${articulo.precio }" /></td>
					<td><c:out value="${articulo.stock }" /></td>
					<td><c:out value="${articulo.codigo }" /></td>
					<td><a href="Carritos?accion=show&codigo=${articulo.codigo}&idUsuario=${idUsuario}" class="ver-carrito">Detalle</a></td>
					<td><a href="Carritos?accion=edit&codigo=${articulo.codigo}&idUsuario=${idUsuario}" class="ver-carrito">Editar</a></td>
					<td>
						<form action="Carritos" method="post">
							<input type="hidden" name="codigo" value="${articulo.codigo}">
							<input type="hidden" name="idUsuario" value="${idUsuario}">
							<input type="hidden" name="accion" value="delete">
							<button type="submit" class="ver-carrito">Eliminar</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p class="mt-3">Precio Total: <c:out value="${precioTotal}" /></p>
	<form action="Carritos" method="post" class="mt-3">
		<input type="hidden" name="idUsuario" value="${idUsuario}">
		<input type="hidden" name="accion" value="comprar">
		<button type="submit" class="ver-carrito">Comprar Carrito</button>
	</form>
</body>
</html>
