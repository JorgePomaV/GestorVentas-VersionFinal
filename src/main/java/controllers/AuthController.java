package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Articulo;
import models.Usuario;
import models.Venta;
import repositories.ArticulosRepoSingleton;
import repositories.UsuariosRepoSingleton;
import repositories.VentasRepoSingleton;
import repositories.interfaces.ArticulosRepo;
import repositories.interfaces.UsuariosRepo;
import repositories.interfaces.VentasRepo;
import utils.Encryptor;

@WebServlet("/auth")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuariosRepo usuariosRepo;
	private ArticulosRepo articulosRepo;
	private VentasRepo ventasRepo;

    public AuthController() {
        this.usuariosRepo = UsuariosRepoSingleton.getInstance();
        this.articulosRepo = ArticulosRepoSingleton.getInstance();
        this.ventasRepo = VentasRepoSingleton.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        String accion = request.getParameter("accion");

    	if (accion != null && accion.equals("logout")) {
            cerrarSesion(request, response);
        } else {
            request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
        }
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombreUsuario = request.getParameter("nombreUsuario");
        String contrasenia = request.getParameter("contrasenia");

        // Manejo de errores
        if (nombreUsuario == null || nombreUsuario.isEmpty() || contrasenia == null || contrasenia.isEmpty()) {
            request.setAttribute("error", "Nombre de usuario y contraseña son obligatorios.");
            request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
            return;
        }
        
        String contraseniaHasheada = Encryptor.encryptMD5(contrasenia);
        
        if (contraseniaHasheada == null) {
            request.setAttribute("error", "Error interno del servidor.");
            request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
            return; 
        }
        
        Usuario usuario = usuariosRepo.findByNombreUsuario(nombreUsuario);
        
        // Iniciar sesión:
        if (usuario != null && usuario.getContrasenia().equals(contraseniaHasheada)) { 
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);

            // Redirigir al usuario según rol 
            if (usuario.getTipo().equals("empleado")) {
            	
            	List<Usuario> listaUsuario = usuariosRepo.getAll();
            	request.setAttribute("listarda", listaUsuario);
            	
            	List<Venta> listaVenta = ventasRepo.getAll();
            	request.setAttribute("listaVentas", listaVenta);
            	
            	List<Articulo> listaArticulos = articulosRepo.getAll();
            	request.setAttribute("listaArticulos", listaArticulos);
            	
                request.getRequestDispatcher("/views/home/adminIndex.jsp").forward(request, response); 
            } else if (usuario.getTipo().equals("cliente")) {
            	List<Articulo> listaArticulos = articulosRepo.getAll();
            	
            	request.setAttribute("idUsuario", usuario.getId());
            	request.setAttribute("listaArticulos", listaArticulos);
                request.getRequestDispatcher("/views/home/clienteIndex.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/views/home/clienteIndex.jsp").forward(request, response);
            }

        } else {
            request.setAttribute("error", "Nombre de usuario o contraseña incorrectos.");
            request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
        }
    }
    
    public static Usuario obtenerUsuarioActual(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return (Usuario) session.getAttribute("usuario"); 
        }
        return null;
    }
    
    private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); 
        }
        response.sendRedirect(request.getContextPath() + "/auth");  
    }

}