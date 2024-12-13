package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Usuario;
import repositories.interfaces.UsuariosRepo;
import utils.Encryptor;

public class UsuariosRepoSingleton implements UsuariosRepo{
	
	private static UsuariosRepoSingleton singleton;
	
	public static UsuariosRepoSingleton getInstance() {
		if(singleton == null) {
			singleton = new UsuariosRepoSingleton();
		}
		return singleton;
	}
	
	private List<Usuario> listaUsuarios;
	
	private UsuariosRepoSingleton() {
		this.listaUsuarios = new ArrayList<Usuario>();
		
		// Creo usuarios hardcodeados -k
		Usuario admin = new Usuario("admin", Encryptor.encryptMD5("admin"), "empleado", 0);
        Usuario cliente = new Usuario("cliente", Encryptor.encryptMD5("cliente"), "cliente", 1500);
        
        admin.setId(1);
        cliente.setId(2);
        this.listaUsuarios.add(admin);
        this.listaUsuarios.add(cliente);
	}

	@Override
	public List<Usuario> getAll() {
		
		return new ArrayList<Usuario>(this.listaUsuarios);
	}

	@Override
	public Usuario findById(int id) {
		
		return this.listaUsuarios.stream()
		.filter((e)-> e.getId() == id )
		.findAny()
		.orElse(null);
	}

	@Override
	public void insert(Usuario usuario) {
		
		int ultimaId = this.listaUsuarios.stream()
				.map(Usuario::getId)
				.max(Integer::compare)
				.orElse(0);
		
		usuario.setId(ultimaId+1);
		
		this.listaUsuarios.add(usuario);
	}

	@Override
	public void delete(int id) {
		this.listaUsuarios.removeIf((u)-> u.getId() == id);
	}

	// Agrego para actualizar transacciones -K
	@Override
    public void update(Usuario usuarioActualizado) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario usuario = listaUsuarios.get(i);
            if (usuario.getId() == usuarioActualizado.getId()) {
                listaUsuarios.set(i, usuarioActualizado); 
                return; 
            }
        }
    }
	
	// Agrego otro más -K
	@Override
	public Usuario findByNombreUsuario(String nombreUsuario) {
	    return this.listaUsuarios.stream()
	            .filter(u -> u.getNombreUsuario().equals(nombreUsuario))
	            .findFirst()
	            .orElse(null);
	}

	@Override
	public void RecargarSaldo(float saldo, int idUsuario) {
		this.listaUsuarios.stream().filter(a -> a.getId() == idUsuario).forEach(a -> a.setSaldoActual(a.getSaldoActual() + saldo));
	}

}
