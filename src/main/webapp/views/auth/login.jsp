<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="css/estiloIndex.css">
</head>
<body>
<div class="login-container">
    <div class="login-box">
        <h1 class="text-center">Iniciar Sesión</h1>

        <c:if test="${not empty error}">
            <div class="error-box">
                ${error}
            </div>
        </c:if>

        <form action="auth" method="post">
            <div class="form-group">
                <label for="nombreUsuario" class="form-label">Nombre de Usuario:</label>
                <input type="text" id="nombreUsuario" name="nombreUsuario" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="contrasenia" class="form-label">Contraseña:</label>
                <input type="password" id="contrasenia" name="contrasenia" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
            
        </form>
            <a href="${pageContext.request.contextPath}/usuarios?accion=create" class="btn-link">Registrarse</a>

        <div class="test-users">
            <p><strong>Usuarios de prueba disponibles:</strong></p>
            <p>ADMIN -> usuario/clave: <em>admin</em></p>
            <p>CLIENTE -> usuario/clave: <em>cliente</em></p>
        </div>
    </div>
</div>
</body>
</html>