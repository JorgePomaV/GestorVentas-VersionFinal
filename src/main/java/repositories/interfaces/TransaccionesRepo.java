package repositories.interfaces;

import java.util.List;

import models.Transaccion;

public interface TransaccionesRepo {
	
    List<Transaccion> getAll();
    public void registrarTransaccion(Transaccion transaccion); // 1
    List<Transaccion> obtenerTransaccionesPorUsuarioDeudor(int idUsuario); // 2 
    List<Transaccion> obtenerTransaccionesPorUsuarioBeneficiario(int idUsuario); // 3
    Transaccion findById(int id); // 4
    // Los numeros son para que no me olvide -K
}
