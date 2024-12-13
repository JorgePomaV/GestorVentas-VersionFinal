<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Transferir Dinero</title>
    <link rel="stylesheet" type="text/css" href="css/estiloCliente.css">
</head>
<body>
    <div class="container">
        <h1>Transferir Dinero</h1>

        <form action="TransaccionesController" method="post">
            <input type="hidden" name="idDeudor" value="${usuario.id}">
            
            <div class="mt-3">
                <label for="idBeneficiario">ID del Beneficiario:</label>
                <input type="text" id="idBeneficiario" name="idBeneficiario" class="form-input">
            </div>
            
            <div class="mt-3">
                <label for="monto">Monto a Transferir:</label>
                <input type="number" id="monto" name="monto" class="form-input">
            </div>

            <div class="mt-5">
                <button type="submit" class="ver-carrito">Realizar Transferencia</button>
            </div>
        </form>

        <div class="mt-3">
        	<a href="${pageContext.request.contextPath}/auth" class="btn btn-link mt-3">Volver a la Tienda</a>
        </div>
    </div>
</body>
</html>

