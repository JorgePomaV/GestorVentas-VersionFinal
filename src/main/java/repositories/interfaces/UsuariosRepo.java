package repositories.interfaces;

import java.util.List;

import models.Usuario;

public interface UsuariosRepo {
	

	public List<Usuario> getAll();
	public Usuario findById(int id);

	public void insert(Usuario usuario);
	public void delete(int idUsuario);
	public void update(Usuario usuario); // agrego esto porque lo necesito para transacciones -K
	Usuario findByNombreUsuario(String nombreUsuario); // también agrego esto pero para auth -K
	void RecargarSaldo(float saldo, int idUsuario);
	
}
