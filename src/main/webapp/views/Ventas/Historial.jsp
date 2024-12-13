<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Historial de Ventas</title>
    <link rel="stylesheet" href="css/estiloHistorial.css"> 
</head>
<body>
    <div>
        <h1>Historial de Ventas</h1>
        <hr/>

        <c:if test="${empty listaVentas}">
            <p>No hay ventas registradas.</p>
        </c:if>

        <c:if test="${not empty listaVentas}">
            <table>
                <thead>
                    <tr>
                        <th>ID Venta</th>
                        <th>Usuario</th>
                        <th>Total</th>
                        <th>Detalles</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="venta" items="${listaVentas}">
                        <tr>
                            <td>${venta.idVenta}</td>
                            <td>${venta.nombreUsuario}</td>
                            <td>${venta.total}</td>
                            <td>
                                <a href="VentasController?accion=detalleVenta&id=${venta.idVenta}">
                                    Ver Detalles
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>

</body>
</html>