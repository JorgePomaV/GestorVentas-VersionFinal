<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Detalles de Venta</title>
    <link rel="stylesheet" href="css/estiloDetalleVenta.css"> 
</head>
<body>
    <div>
        <h1>Detalles de la Venta</h1>
        <hr/>

        <div>
            <p><strong>ID Venta:</strong> ${venta.idVenta}</p>
            <p><strong>Usuario:</strong> ${venta.nombreUsuario}</p>
            <p><strong>Total:</strong> ${venta.total}</p>
            <p><strong>Fecha de Venta:</strong> ${venta.fechaVenta}</p>
        </div>

        <h2>Artículos Comprados</h2>
        <c:if test="${empty venta.articulos}">
            <p>No hay artículos en esta venta.</p>
        </c:if>

        <c:if test="${not empty venta.articulos}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Código de Artículo</th>
                        <th>Nombre</th>
                        <th>Cantidad</th>
                        <th>Precio Unitario</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="articulo" items="${venta.articulos}">
                        <tr>
                            <td>${articulo.codigo}</td>
                            <td>${articulo.nombre}</td>
                            <td>${articulo.stock}</td> 
                            <td>${articulo.precio}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <div>
    		<a href="${pageContext.request.contextPath}/VentasController?accion=volverAdmin">Volver a la lista</a>
        </div>
    </div>
</body>
</html>