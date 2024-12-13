package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Articulo;
import models.Carrito;
import repositories.interfaces.CarritosRepo;

public class CarritosRepoSingleton implements CarritosRepo{

private static CarritosRepoSingleton singleton;
	
	public static CarritosRepoSingleton getInstance() {
		if(singleton == null) {
			singleton = new CarritosRepoSingleton();
		}
		return singleton;
	}
	
	private List<Carrito> listaCarritos;
	
	private CarritosRepoSingleton() {
		this.listaCarritos = new ArrayList<Carrito>();	
	}

	@Override
	public Carrito findByIdCarrito(int idUsuario) {
		Carrito carrito = listaCarritos.stream()
	            .filter(a -> a.getIdUsuario() == idUsuario)
	            .findFirst()
	            .orElseGet(() -> {
	                Carrito nuevoCarrito = new Carrito(idUsuario);
	                listaCarritos.add(nuevoCarrito);
	                return nuevoCarrito;
	            });
	return carrito;
	}

	@Override
	public boolean comprarCarrito(int idUsuario) {
		return this.listaCarritos.removeIf(a -> a.getIdUsuario() == idUsuario);
		
	}

	@Override
	public boolean add(int idUsuario, Articulo articulo) {
		Carrito carrito = this.findByIdCarrito(idUsuario);
		return carrito.addArticulo(articulo);
	}

	@Override
	public boolean delete(int idUsuario, int codigo) {
		Carrito carrito = this.findByIdCarrito(idUsuario);
		return carrito.deleteArticulo(codigo);
	}

	@Override
	public Articulo findByIdArticulo(int idUsuario, int codigo) {
		Carrito carrito = this.findByIdCarrito(idUsuario);
		Articulo articulo = carrito.findByCodigo(codigo);
		return articulo;
	}

	@Override
	public List<Articulo> getAll(int idUsuario) {
		Carrito carrito = this.findByIdCarrito(idUsuario);
		return carrito.getArticulos();
	}

	@Override
	public double precioTotal(int idUsuario) {
		Carrito carrito = this.findByIdCarrito(idUsuario);
		return carrito.precioTotal();
	}

	@Override
	public int totalArticulos(int idUsuario) {
		Carrito carrito = this.findByIdCarrito(idUsuario);
		return carrito.cantArticulos();
	}

	@Override
	public boolean edit(int idUsuario, int codigo, int cantidad) {
		Carrito carrito = this.findByIdCarrito(idUsuario);
		return carrito.editArticulo(codigo, cantidad);
	}
	
	
	
}
