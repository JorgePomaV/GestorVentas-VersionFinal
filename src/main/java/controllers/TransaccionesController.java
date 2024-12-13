package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Transaccion;
import models.Usuario;
import repositories.TransaccionesRepoSingleton;
import repositories.UsuariosRepoSingleton;
import repositories.interfaces.TransaccionesRepo;
import repositories.interfaces.UsuariosRepo;

@WebServlet("/TransaccionesController")
public class TransaccionesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TransaccionesRepo transaccionesRepo;
	private UsuariosRepo usuariosRepo;
       
    public TransaccionesController() {
	      this.transaccionesRepo = TransaccionesRepoSingleton.getInstance();
	      this.usuariosRepo = UsuariosRepoSingleton.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String accion = request.getParameter("accion");
		accion = Optional.ofNullable(accion).orElse("index");
		
		switch (accion) {
		case "index" -> getIndex(request,response);
		case "transferir" -> getTransferir(request,response);
		case "registros" -> getRegistros(request,response);
		case "show" -> getShow(request,response);
		default ->response.sendError(404);
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	private void getShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int idTransaccion = Integer.parseInt(request.getParameter("idTransaccion"));
        
        Transaccion transaccion = transaccionesRepo.findById(idTransaccion);
        
        request.setAttribute("transaccion", transaccion);
        
 
        request.getRequestDispatcher("/views/transacciones/show.jsp").forward(request, response);
	}

	//Manda los datos de Registro de las transacciones (realizadas, recibidas) de un usuario particular.
	private void getRegistros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idDeudor = Integer.parseInt(request.getParameter("idUsuario"));
		
		transaccionesRepo.obtenerTransaccionesPorUsuarioDeudor(idDeudor);
		List<Transaccion> beneficiario = transaccionesRepo.obtenerTransaccionesPorUsuarioBeneficiario(idDeudor);
		List<Transaccion> deudor = transaccionesRepo.obtenerTransaccionesPorUsuarioDeudor(idDeudor);
		
		beneficiario = beneficiario != null ? beneficiario : new ArrayList<Transaccion>();
		deudor = deudor != null ? deudor : new ArrayList<Transaccion>();
		
		request.setAttribute("beneficiario", beneficiario);
		request.setAttribute("deudor", deudor);
		
		request.getRequestDispatcher("/views/transacciones/registros.jsp").forward(request, response);
	}

	//Manda los datos del usuario a la vista donde se transfiere.
	private void getTransferir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int idDeudor = Integer.parseInt(request.getParameter("idDeudor"));
		
		Usuario usuario = usuariosRepo.findById(idDeudor);
		
		if(usuario == null) {
			response.sendError(404, "Usuario no encontrado"); 
			return;
		}
		request.setAttribute("usuario", usuario);
		request.getRequestDispatcher("/views/transacciones/transferir.jsp").forward(request, response);
	}

	//Manda los datos del usuario a la vista.
	private void getIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		
		Usuario usuario = usuariosRepo.findById(idUsuario);
		if(usuario == null) {
			response.sendError(404, "Usuario no encontrado"); 
			return;
		}
		request.setAttribute("usuario", usuario);
		
		request.getRequestDispatcher("/views/transacciones/index.jsp").forward(request, response);
	}

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
	        int idDeudor = Integer.parseInt(request.getParameter("idDeudor"));
	        int idBeneficiario = Integer.parseInt(request.getParameter("idBeneficiario"));
	        double monto = Double.parseDouble(request.getParameter("monto"));
	        
	        // Verificación del monto
	        if (monto <= 0) {
	            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	            response.getWriter().write("El monto debe ser mayor a cero.");
	            return;
	        }

	        Transaccion nuevaTransaccion = new Transaccion(0, idDeudor, idBeneficiario, monto);
	        transaccionesRepo.registrarTransaccion(nuevaTransaccion);

	        response.getWriter().write("Transacción registrada exitosamente");
	    } catch (Exception e) {
	        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	        response.getWriter().write("Error al registrar transacción: " + e.getMessage());
	    }
    }

}
