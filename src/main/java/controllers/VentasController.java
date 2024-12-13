package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Articulo;
import models.Transaccion;
import models.Usuario;
import models.Venta;
import repositories.interfaces.ArticulosRepo;
import repositories.interfaces.TransaccionesRepo;
import repositories.interfaces.UsuariosRepo;
import repositories.interfaces.VentasRepo;
import repositories.ArticulosRepoSingleton;
import repositories.TransaccionesRepoSingleton;
import repositories.UsuariosRepoSingleton;
import repositories.VentasRepoSingleton;

@WebServlet("/VentasController")
public class VentasController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private VentasRepo ventasRepo;
    private ArticulosRepo articulosRepo;
    private TransaccionesRepo transaccionesRepo;
    private UsuariosRepo usuariosRepo; 
    
    public VentasController() {
        this.ventasRepo = VentasRepoSingleton.getInstance();
        this.articulosRepo = ArticulosRepoSingleton.getInstance();
        this.transaccionesRepo = TransaccionesRepoSingleton.getInstance();
        this.usuariosRepo = UsuariosRepoSingleton.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = Optional.ofNullable(request.getParameter("accion")).orElse("historial"); 

        switch (accion) {
            case "historial" -> getHistorial(request, response); 
            case "detalleVenta" -> getDetalle(request, response);
            case "volverAdmin" -> volverAdmin(request, response);
            default -> response.sendError(404);
        }
    }

    private void getHistorial(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Venta> ventas = ventasRepo.getAll();
        request.setAttribute("listaVentas", ventas);
        request.getRequestDispatcher("/views/Ventas/Historial.jsp").forward(request, response);
    }

    private void getDetalle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idVenta = Integer.parseInt(request.getParameter("id"));
        VentasRepoSingleton ventasRepo = VentasRepoSingleton.getInstance();
        Venta venta = ventasRepo.findById(idVenta);
        
        if (venta != null) {
        	request.setAttribute("venta", venta);
            request.getRequestDispatcher("/views/Ventas/DetalleVenta.jsp").forward(request, response);
        } else {
            response.sendError(404, "Venta no encontrada");
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null) {
        	response.sendError(404, "Accion no encontrada");
            return;
        }

        switch (accion) {
            case "insert" -> postInsert(request, response);
            case "delete" -> postDelete(request, response);
            default -> response.sendError(404);
        }
    }

    private void postInsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cliente = request.getParameter("cliente");
        String[] codigosArticulos = request.getParameterValues("articulosSeleccionados"); // Array de códigos de artículos

        if (cliente == null || cliente.isEmpty() || codigosArticulos == null || codigosArticulos.length == 0) {
            response.sendError(404, "Datos incompletos");
            return;
        }

        try {
            List<Articulo> articulosSeleccionados = new ArrayList<>();
            for (String codigoStr : codigosArticulos) {
                int codigo = Integer.parseInt(codigoStr);
                Articulo articulo = articulosRepo.findByCodigo(codigo);
                if (articulo != null) {
                    articulosSeleccionados.add(articulo);
                }
            }

            if (articulosSeleccionados.isEmpty()) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "No se encontraron artículos válidos");
                return;
            }

            double total = articulosSeleccionados.stream().mapToDouble(Articulo::getPrecio).sum();
            
            // Modulo saldo --- inicio
            HttpSession session = request.getSession(false);
            
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            
            if (usuario == null || session == null) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Debes iniciar sesión para realizar una compra.");
                return; 
            }

            if (usuario.getSaldoActual() < total) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Saldo insuficiente.");
                return;
            }
            
            Usuario admin = usuariosRepo.findByNombreUsuario("admin"); // "admin" sería la empresa en este caso, recibe la plata
            
            if (admin == null) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error: no se pudo encontrar al administrador.");
                return;
            }
            
            Transaccion transaccion = new Transaccion(0, usuario.getId(), admin.getId(), total);
            transaccionesRepo.registrarTransaccion(transaccion);
            
            // Modulo saldo --- fin
            
            LocalDate fechaVenta = LocalDate.now();
            Venta nuevaVenta = new Venta(ventasRepo.getAll().size() + 1, cliente, total, articulosSeleccionados, fechaVenta);
            
            ventasRepo.insert(nuevaVenta);
            response.sendRedirect("VentasController?accion=historial");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Código de artículo inválido");
        }
    }

    private void postDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sId = request.getParameter("id");
        try {
            int id = Integer.parseInt(sId);
            ventasRepo.delete(id);
            response.sendRedirect("VentasController?accion=historial");
        } catch (NumberFormatException e) {
            response.sendError(404, "ID inválido para eliminación");
        }
    }
    
    private void volverAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Usuario> listaUsuario = usuariosRepo.getAll();
        List<Venta> listaVenta = ventasRepo.getAll();
        List<Articulo> listaArticulos = articulosRepo.getAll();

        request.setAttribute("listarda", listaUsuario);
        request.setAttribute("listaVentas", listaVenta);
        request.setAttribute("listaArticulos", listaArticulos);

        request.getRequestDispatcher("/views/home/adminIndex.jsp").forward(request, response);
    }
}
