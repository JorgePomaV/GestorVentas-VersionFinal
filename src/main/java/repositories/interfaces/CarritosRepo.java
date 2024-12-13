package repositories.interfaces;

import java.util.List;

import models.Articulo;
import models.Carrito;

public interface CarritosRepo {
	
	public boolean add(int idUsuario, Articulo articulo);
	
	public boolean delete(int idUsuario, int codigo);
	
	public boolean edit(int idUsuario, int codigo, int cantidad);
	
	public Articulo findByIdArticulo(int idUsuario, int codigo);
	
	public List<Articulo> getAll(int idUsuario);
	
	public double precioTotal(int idUsuario);
	
	public int totalArticulos(int idUsuario);
	
	public Carrito findByIdCarrito(int idUsuario);
	
	public boolean comprarCarrito(int idUsuario);
}
