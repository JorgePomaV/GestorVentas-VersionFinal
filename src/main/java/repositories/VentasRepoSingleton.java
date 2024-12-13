package repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.Articulo;
import models.Venta;
import repositories.interfaces.VentasRepo;

public class VentasRepoSingleton implements VentasRepo {

    private static VentasRepoSingleton instancia;
    private List<Venta> ventas;
    
    private VentasRepoSingleton() {
        ventas = new ArrayList<>();

        ventas.add(new Venta(1, "cliente1", 150.0, Arrays.asList(
            new Articulo(101, "Articulo A", "Descripción A", 50.0, 2)
        ), LocalDate.now()));

        ventas.add(new Venta(2, "cliente2", 300.0, Arrays.asList(
            new Articulo(102, "Articulo B", "Descripción B", 75.0, 4)
        ), LocalDate.now()));
    }

    public static synchronized VentasRepoSingleton getInstance() {
        if (instancia == null) {
            instancia = new VentasRepoSingleton();
        }
        return instancia;
    }

    @Override
    public List<Venta> getAll() {
        return new ArrayList<>(ventas);
    }

    @Override
    public Venta findById(int id) {
        return ventas.stream()
                     .filter(venta -> venta.getIdVenta() == id)
                     .findFirst()
                     .orElse(null);
    }

    @Override
    public synchronized void insert(Venta venta) {
        ventas.add(venta);
    }

    @Override
    public synchronized void delete(int id) {
        ventas.removeIf(venta -> venta.getIdVenta() == id);
    }
}
