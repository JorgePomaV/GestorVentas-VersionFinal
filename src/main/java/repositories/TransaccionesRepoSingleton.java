package repositories;

import repositories.interfaces.TransaccionesRepo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import models.Transaccion;
import models.Usuario;
import repositories.interfaces.UsuariosRepo;


public class TransaccionesRepoSingleton implements TransaccionesRepo{
	
	private static TransaccionesRepoSingleton singleton;
    private List<Transaccion> transacciones;
    
    // CONSTRUCTOR
    private TransaccionesRepoSingleton() {
        this.transacciones = new ArrayList<>();
    }
    
    // Obtener unica instancia 
    public static TransaccionesRepoSingleton getInstance() {
        if (singleton == null) {
            singleton = new TransaccionesRepoSingleton();
        }
        return singleton;
    }

	public Transaccion findById(int id) {
    	return this.transacciones.stream()
    			.filter((t)-> t.getId() == id )
    			.findAny()
    			.orElse(null);
    }
    
    
    // Ver todas las transacciones
    @Override
    public List<Transaccion> getAll() {
        return new ArrayList<>(transacciones);
    }
    
    
    // METODOS -K
    
    // 1. Registrar transaccion
    @Override
    public void registrarTransaccion(Transaccion transaccion) {
    	
    	// Usuarios:
    	 UsuariosRepo usuariosRepo = UsuariosRepoSingleton.getInstance();
         Usuario deudor = usuariosRepo.findById(transaccion.getIdUsuarioDeudor());
         Usuario beneficiario = usuariosRepo.findById(transaccion.getIdUsuarioBeneficiario());
         
         // IF hay dinero...
         if (deudor.getSaldoActual() < transaccion.getMontoTransaccionado()) {
             throw new RuntimeException("Saldo insuficiente"); 
         }
    	
         deudor.setSaldoActual(deudor.getSaldoActual() - transaccion.getMontoTransaccionado());
         beneficiario.setSaldoActual(beneficiario.getSaldoActual() + transaccion.getMontoTransaccionado());
         
         // tengo que chequear que haya un metodo update en usuario
         usuariosRepo.update(deudor);
         usuariosRepo.update(beneficiario);
         
         // Le registro la transaccion y le aumento el id
         int ultimoId = transacciones.stream()
        	        .max(Comparator.comparingInt(Transaccion::getId)) 
        	        .map(Transaccion::getId) 
        	        .orElse(0);
         transaccion.setId(ultimoId + 1);
         transacciones.add(transaccion);
    }
    
    
    // Ver transaccion por idUsuario (realizadas y recibidas, separadas) -K
    
    
    // 2. Transacciones deudor (o sea, el dinero enviado)
    @Override
    public List<Transaccion> obtenerTransaccionesPorUsuarioDeudor(int idUsuario) {
        return transacciones.stream()
                .filter(t -> t.getIdUsuarioDeudor() == idUsuario)
                .toList();
    }

    // 3. Transacciones Beneficiario (o sea, el dinero recibido)
    @Override
    public List<Transaccion> obtenerTransaccionesPorUsuarioBeneficiario(int idUsuario) {
        return transacciones.stream()
                .filter(t -> t.getIdUsuarioBeneficiario() == idUsuario)
                .toList();
    }
    
    
}
