<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registros de Transacciones</title>
    <link rel="stylesheet" type="text/css" href="css/estiloCliente.css">
</head>
<body>
    <div class="container">
        <h1>Registros de Transacciones</h1>

        <h2>Transacciones recibidas</h2>
        <table>
            <thead>
                <tr>
                    <th>ID Transacción</th>
                    <th>Monto</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="transaccionb" items="${beneficiario}">
                    <tr>
                        <td><c:out value="${transaccionb.id}"></c:out></td>
                        <td><c:out value="${transaccionb.montoTransaccionado}"></c:out></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <h2>Transacciones hechas</h2>
        <table>
            <thead>
                <tr>
                    <th>ID Transacción</th>
                    <th>Monto</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="transacciond" items="${deudor}">
                    <tr>
                        <td><c:out value="${transacciond.id}"></c:out></td>
                        <td><c:out value="${transacciond.montoTransaccionado}"></c:out></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
