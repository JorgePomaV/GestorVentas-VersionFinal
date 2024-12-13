<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Panel de Administración</title>
    <link rel="stylesheet" href="css/estiloAdmin.css"> 
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">BIENVENIDO ADMIN</h1>
    <a href="${pageContext.request.contextPath}/auth?accion=logout" class="btn-link">Cerrar Sesión</a>

    <!-- Sección de Usuarios -->
    <h2 class="mb-3">Gestión de Usuarios</h2>
    <table class="table table-striped table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre de Usuario</th>
                <th>Contraseña</th>
                <th>Saldo</th>
                <th>Tipo</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="usuario" items="${listarda}">
                <tr>
                    <td><c:out value="${usuario.id}"/></td>
                    <td><c:out value="${usuario.nombreUsuario}"/></td>
                    <td><c:out value="${usuario.contrasenia}"/></td>
                    <td><c:out value="${usuario.saldoActual}"/></td>
                    <td><c:out value="${usuario.tipo}"/></td>
                    <td>
                        <a href="usuarios?accion=show&id=${usuario.id}" class="btn-link">Ver</a>
                        <form action="usuarios" method="post" class="d-inline">
                            <input type="hidden" name="id" value="${usuario.id}">
                            <input type="hidden" name="accion" value="delete">
                            <button type="submit" class="btn btn-danger btn-sm">Eliminar</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Sección de Ventas -->
    <h2 class="mt-5 mb-3">Historial de Ventas</h2>
    <c:if test="${empty listaVentas}">
        <p class="text">No hay ventas registradas.</p>
    </c:if>
    <c:if test="${not empty listaVentas}">
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>ID Venta</th>
                    <th>Usuario</th>
                    <th>Total</th>
                    <th>Fecha</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="venta" items="${listaVentas}">
                    <tr>
                        <td>${venta.idVenta}</td>
                        <td>${venta.nombreUsuario}</td>
                        <td>${venta.total}</td>
                        <td>${venta.fechaVenta}</td>
                        <td>
                            <a href="VentasController?accion=detalleVenta&id=${venta.idVenta}" class="btn-link">Detalles</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <!-- Sección de Artículos -->
    <h2 class="mt-5 mb-3">Gestión de Artículos</h2>
    <a href="articulos?accion=create" class="btn-link">Agregar Artículo</a>
    <c:if test="${empty listaArticulos}">
        <p class="text">No hay artículos registrados.</p>
    </c:if>
    <c:if test="${not empty listaArticulos}">
        <table class="table table-striped table-bordered">
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
                        <td><c:out value="${articulo.stock}" /></td>
                        <td>
                        	<a href="articulos?accion=show&codigo=${articulo.codigo}" class="btn-link">Ver</a>
                        	<a href="articulos?accion=edit&codigo=${articulo.codigo}" class="btn-link">Editar</a>
                        	<form action="articulos" method="post" class="d-inline">
                                <input type="hidden" name="codigo" value="${articulo.codigo}">
                                <input type="hidden" name="accion" value="delete">
                                <button type="submit" class="btn btn-danger btn-sm">Eliminar</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>

</body>
</html>