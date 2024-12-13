package repositories.interfaces;

import java.util.List;
import models.Articulo;

public interface ArticulosRepo {
	
	// Aca id es código de art -K
	
	List<Articulo> getAll();
    Articulo findByCodigo(int codigo); 

	// CRUD:
	public void insert(Articulo articulo);
	public void update(Articulo articulo);
	public void delete(int codigo);
	public void descontarStock(List<Articulo> carritoArticulos);
}
