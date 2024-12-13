package models;

public class Transaccion {
	
	// ATRIBUTOS
	public int id;
	public int idUsuarioDeudor;
	public int idUsuarioBeneficiario;
	public double montoTransaccionado; 

	// CONSTRUCTOR
	public Transaccion(int id, int idUsuarioDeudor, int idUsuarioBeneficiario, double montoTransaccionado) {
		super();
		this.id = id;
		this.idUsuarioDeudor = idUsuarioDeudor;
		this.idUsuarioBeneficiario = idUsuarioBeneficiario;
		this.montoTransaccionado = montoTransaccionado;
	}

	// SETTERS & GETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuarioDeudor() {
		return idUsuarioDeudor;
	}

	public void setIdUsuarioDeudor(int idUsuarioDeudor) {
		this.idUsuarioDeudor = idUsuarioDeudor;
	}

	public int getIdUsuarioBeneficiario() {
		return idUsuarioBeneficiario;
	}

	public void setIdUsuarioBeneficiario(int idUsuarioBeneficiario) {
		this.idUsuarioBeneficiario = idUsuarioBeneficiario;
	}

	public double getMontoTransaccionado() {
		return montoTransaccionado;
	}

	public void setMontoTransaccionado(double montoTransaccionado) {
		this.montoTransaccionado = montoTransaccionado;
	}
	
}
