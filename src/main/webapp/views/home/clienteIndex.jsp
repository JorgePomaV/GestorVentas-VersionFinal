<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bienvenido Cliente</title>
    <link rel="stylesheet" href="css/estiloCliente.css">
</head>
<body class="container mt-5">
    <h1 class="mb-4">Bienvenido, <c:out value="${usuario.nombreUsuario}" /></h1>
    <a href="${pageContext.request.contextPath}/auth?accion=logout" class="ver-carrito">Cerrar Sesión</a>
    
    <div class="">
        <div class="">
            <p><strong>Nombre de usuario:</strong> <c:out value="${usuario.nombreUsuario}" /></p>
            <p><strong>Saldo:</strong> $<c:out value="${usuario.saldoActual}" /></p>
            <p><strong>Tipo de usuario:</strong> <c:out value="${usuario.tipo}" /></p>
            <form action="usuarios" method="post" class="mt-2">
                <input type="hidden" name="id" value="${usuario.id}">
                <input type="hidden" name="accion" value="delete">
                <button type="submit" class="btn btn-danger">Eliminar cuenta</button>
            </form>
             <div class="carrito-container">
		        <a href="TransaccionesController?accion=index&idUsuario=${usuario.id}" class="ver-carrito">Transacciones</a>
		    </div>
		       <div class="recarga-container">
                <a href="usuarios?accion=Saldo&idUsuario=${usuario.id}" class="ver-carrito">Recargar Saldo</a>
             </div>
        </div>
    </div>

    <!-- Sección de artículos -->
    <h2 class="">Artículos Disponibles</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Código</th>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Precio</th>
                <th>Stock</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="articulo" items="${listaArticulos}">
                <tr>
                    <td><c:out value="${articulo.codigo}" /></td>
                    <td><c:out value="${articulo.nombre}" /></td>
                    <td><c:out value="${articulo.descripcion}" /></td>
                    <td>$<c:out value="${articulo.precio}" /></td>
                    <td><c:out value="${articulo.stock}"/></td>
                    <td> 
						<a href="Carritos?accion=add&idUsuario=${usuario.id}&codigo=${articulo.codigo}">Comprar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="carrito-container">
	    <a href="Carritos?accion=carrito&idUsuario=${idUsuario}" class="ver-carrito">Ver Carrito</a>
	</div>
   
</body>
</html>