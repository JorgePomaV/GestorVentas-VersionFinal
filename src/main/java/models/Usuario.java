package models;

public class Usuario {
	
	// ATRIBUTOS
	public int id;
	private String nombreUsuario; 
	private String contrasenia;
	private String tipo; // Cliente o empleado
	private double saldoActual; // me evito entidad billetera

	public Usuario() {
		super();
	}

	// CONSTRUCTOR
	public Usuario(String nombreUsuario, String contrasenia, String tipo, double saldoActual) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.tipo = tipo;
		this.saldoActual = saldoActual;
	}

	// SETTERS & GETTERS
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}
}
