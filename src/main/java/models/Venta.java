package models;

import java.time.LocalDate;
import java.util.List;

public class Venta {

    private int idVenta;
    private String nombreUsuario;
    private double total;
    private List<Articulo> articulos;
    private LocalDate fechaVenta;
    

    public Venta() {
        super();
    }

    public Venta(int id, String nombreUsuario, double total, List<Articulo> articulos, LocalDate fechaVenta) {
        this.idVenta = id;
        this.nombreUsuario = nombreUsuario;
        this.total = total;
        this.articulos = articulos;
        this.fechaVenta = fechaVenta;
    }

    public double calcularTotal() {
        double total = 0;
        if (articulos != null) {
            for (Articulo articulo : articulos) {
                total += articulo.getPrecio() * articulo.getStock();
            }
        }
        return total;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }
    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
        this.total = calcularTotal();
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }
    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", nombreUsuario=" + nombreUsuario + ", total=" + total + ", articulos="
				+ articulos + ", fechaVenta=" + fechaVenta + "]";
	}
}
