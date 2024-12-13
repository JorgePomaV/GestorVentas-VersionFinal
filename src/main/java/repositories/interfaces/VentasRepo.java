package repositories.interfaces;

import java.util.List;
import models.Venta;

public interface VentasRepo {

    // OBTENER VENTAS
    public List<Venta> getAll();

    // ENCONTRAR VENTA POR ID
    public Venta findById(int id);

    // INSERTAR VENTA
    public void insert(Venta venta);

    // ELIMINAR VENTA
    public void delete(int id);
}
