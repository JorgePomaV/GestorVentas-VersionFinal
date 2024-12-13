<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Usuario</title>
    <link rel="stylesheet" href="css/estiloIndex.css">
</head>
<body>


<div class="form-container">
    <div class="form-box">
        <h1 class="text-center">Registrar Nuevo Usuario</h1>

        <form action="usuarios?accion=registrar" method="post">
            <input type="hidden" name="accion" value="insert">
            
            <div class="form-group">
                <label for="nombreUsuario" class="form-label">Nombre de Usuario:</label>
                <input type="text" id="nombreUsuario" name="nombreUsuario" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="contrasenia" class="form-label">Contraseña:</label>
                <input type="password" id="contrasenia" name="contrasenia" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="saldoActual" class="form-label">Saldo Inicial:</label>
                <input type="number" id="saldoActual" name="saldoActual" class="form-control" required>
            </div>
          
             <c:if test="${error != null}">
	             <div class="form-group">
				    <p>${error}</p>
				 </div>
			</c:if>
            
	        <div class="form-group">
	                <label for="tipo" class="form-label">Tipo de Usuario:</label>
	                <select name="tipo" id="tipo" class="form-control" required>
	                    <option value="">Seleccione...</option>
	                    <option value="cliente">Cliente</option>
	                    <option value="empleado">Empleado</option>
	                </select>
	            </div>

            <button type="submit" class="btn btn-primary">Registrar</button>
        </form>
    </div>
</div>

</body>
</html>
