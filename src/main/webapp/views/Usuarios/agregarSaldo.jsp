<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <title>Recargar Saldo</title>
        <link rel="stylesheet" type="text/css" href="css/estiloCliente.css">
</head>
<body>

    <div class="container">
        <c:if test="${not empty error}">
            <div class="error-box mt-3">
                ${error}
            </div>
        </c:if>
        
        <h1>Recargar Saldo</h1>

        <form action="usuarios" method="post">
            <input type="hidden" name="accion" value="agregarSaldo">
            <input type="hidden" name="idUsuario" value="${usuario.id}">

            <div class="mt-3">
                <label for="saldo">Monto a Agregar:</label>
                <input type="number" name="saldo" step="0.01" required>
            </div>

            <button type="submit" class="button">Confirmar</button>
        </form>
    </div>

</body>
</html>
