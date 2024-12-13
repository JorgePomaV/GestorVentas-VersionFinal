package models;


import java.util.ArrayList;
import java.util.List;

public class Carrito {
	// ATRIBUTOS
	private int idUsuario;
    private List<Articulo> listaArticulos;

    // CONSTRUCTOR
    public Carrito(int idusuario) {
        this.listaArticulos = new ArrayList<Articulo>();
        this.idUsuario = idusuario;
    } 
    
    /*public Carrito(int idUsuario, ArrayList<Articulo> articulos) {
    	this.idUsuario = idUsuario;
    	this.listaArticulos = articulos;
	}*/
    
    public List<Articulo> getArticulos() {
		return new ArrayList<Articulo>(listaArticulos);
	}

	public boolean addArticulo(Articulo articulo) {
		boolean resultado = this.listaArticulos.add(articulo);
		return resultado;
	}
	
	public Articulo findByCodigo(int codigo) {
		return this.listaArticulos.stream().filter(a -> a.getCodigo() == codigo).findFirst().orElse(null);
	}
	
	public boolean deleteArticulo(int id) {
		return listaArticulos.removeIf(a -> a.getCodigo() == id);
	}
	
	public boolean editArticulo(int codigo, int cantidad) {
		Articulo articulo = this.findByCodigo(codigo);
		if(articulo != null) {
			articulo.setStock(cantidad);
			return true;
		}else {
			return false;
		}
	}
	
	public double precioTotal() {
		return this.listaArticulos.stream().mapToDouble(a -> a.getStock()* a.getPrecio()).sum();
	}
	
	public int cantArticulos() {
		return this.listaArticulos.stream().mapToInt(Articulo::getStock).sum();
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idCarrtio) {
		this.idUsuario = idCarrtio;
	}
	
	@Override
	public String toString() {
		return "Carrito [idUsuario=" + idUsuario + ", listaArticulos=" + listaArticulos + "]";
	}
}
