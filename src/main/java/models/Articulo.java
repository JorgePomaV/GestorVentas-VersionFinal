package models;

public class Articulo {
	
	// Debe contener como mínimo: código, nombre, desc, precio
	
	// ATRIBUTOS
	private int codigo;
	private String nombre;
	private String descripcion;
	private double precio;
	private int stock; // si tengo tiempo lo pongo aparte -K
	
	// CONSTRUCTOR
	public Articulo(int codigo, String nombre, String descripcion, double precio, int stock) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}
	
	// Constructor vacío = para después ?
	public Articulo() {

	}
	

	// SETTERS & GETTERS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	// Importante para que no me imprima el espacio en memoria -K
	@Override
    public String toString() {
        return "Articulo [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock + "]";
    }
}
