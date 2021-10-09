package com.ubosque.mintic.frontend.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ubosque.mintic.frontend.dto.ClienteDTO;
import com.ubosque.mintic.frontend.logica.ClienteLogica;


/**
 * Servlet implementation class MenuClienteServlet
 */
@WebServlet("/MenuClienteServlet")
public class MenuClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String consultar = request.getParameter("Consultar");
		String crear = request.getParameter("Crear");
		String actualizar = request.getParameter("Actualizar");
		String borrar = request.getParameter("Borrar");
		
		String cedulaDigitada = request.getParameter("txtCedula");
		String direccionDigitada = request.getParameter("txtDireccion");
		String correoDigitado = request.getParameter("emCorreo");
		String nombreDigitado = request.getParameter("txtNombre");
		String telefonoDigitado = request.getParameter("txtTelefono");
		
		if (consultar !=null) {
			ClienteDTO dto = new ClienteDTO();
			dto.setCedulaCliente(cedulaDigitada);
			ClienteLogica logica = new ClienteLogica();
			ClienteDTO clienteConsultado = logica.consultarPorCedula(dto);
			if(clienteConsultado !=null) {
				response.sendRedirect("/frontend/menu/menuPrincipal.html");
			}else {
				response.sendRedirect("/frontend/usuarios/login.html");
			};
		}else if(crear != null){
			
			ClienteDTO dto = new ClienteDTO();
			dto.setCedulaCliente(cedulaDigitada);
			dto.setDireccionCliente(direccionDigitada);
			dto.setEmailCliente(correoDigitado);
			dto.setNombreCliente(nombreDigitado);
			dto.setTelefonoCliente(telefonoDigitado);
			
			ClienteLogica logica = new ClienteLogica();
			boolean existeCliente = logica.crear(dto);
			if(existeCliente) {
				response.sendRedirect("/frontend/menuUsuarios/menuUsuarios.html");
			}else {
				response.sendError(0);
			}
		}else if(actualizar != null){
			
			ClienteDTO dto = new ClienteDTO();
			dto.setCedulaCliente(cedulaDigitada);
			dto.setDireccionCliente(direccionDigitada);
			dto.setEmailCliente(correoDigitado);
			dto.setNombreCliente(nombreDigitado);
			dto.setTelefonoCliente(telefonoDigitado);
			
			ClienteLogica logica = new ClienteLogica();
			boolean existeCliente = logica.actualizar(dto);
			if(existeCliente) {
				response.sendRedirect("/frontend/menuUsuarios/menuUsuarios.html");
			}else {
				response.sendError(0);
			}
			
		}	else if (borrar !=null) {
			ClienteDTO dto = new ClienteDTO();
			dto.setCedulaCliente(cedulaDigitada);
			ClienteLogica logica = new ClienteLogica();
			boolean clienteBorrado = logica.borrar(dto);
			if(clienteBorrado !=false) {
				response.sendRedirect("/frontend/menu/menuPrincipal.html");
			}else {
				response.sendRedirect("/frontend/usuarios/login.html");
			};
		}
	}

}
