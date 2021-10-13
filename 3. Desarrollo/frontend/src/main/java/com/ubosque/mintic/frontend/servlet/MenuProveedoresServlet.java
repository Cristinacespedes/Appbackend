package com.ubosque.mintic.frontend.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ubosque.mintic.frontend.dto.ProveedorDTO;
import com.ubosque.mintic.frontend.logica.ProveedorLogica;

/**
 * Servlet implementation class MenuProveedores
 */
@WebServlet("/MenuProveedoresServlet")
public class MenuProveedoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuProveedoresServlet() {
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
		
		String nitDigitado = request.getParameter("txtNit");
		String telefonoDigitado = request.getParameter("txtTelefono"); 
		String nombreDigitado = request.getParameter("txtNombre");
		String ciudadDigitada = request.getParameter("txtCiudad");
		String direccionDigitada = request.getParameter("txtDireccion");
		
		if (consultar !=null) {
			ProveedorDTO dto = new ProveedorDTO();
			dto.setNitProveedor(nitDigitado);
			ProveedorLogica logica = new ProveedorLogica();
			ProveedorDTO proveedorConsultado = new ProveedorDTO();
			proveedorConsultado = logica.consultarPorNit(dto);
			if (proveedorConsultado !=null) {
				response.sendRedirect("/frontend/menuProveedores/menuProveedores.html");
			}else {
				response.sendRedirect("/frontend/usuarios/login.html");
			}
		}else if (crear!=null) {
			ProveedorDTO dto = new ProveedorDTO();
			dto.setNitProveedor(nitDigitado);
			dto.setCiudadProveedor(ciudadDigitada);
			dto.setDireccionProveedor(direccionDigitada);
			dto.setNombreProveedor(nombreDigitado);
			dto.setTelefonoProveedor(telefonoDigitado);
			
			ProveedorLogica logica =new ProveedorLogica();
			boolean existeProveedor = logica.crear(dto);
			if (existeProveedor) {
				response.sendRedirect("/frontend/menuProveedores/menuProveedores.html");
			}else {
				response.sendRedirect("/frontend/usuarios/login.html");
			}
			
		}else if (actualizar!=null) {
			ProveedorDTO dto = new ProveedorDTO();
			dto.setNitProveedor(nitDigitado);
			dto.setCiudadProveedor(ciudadDigitada);
			dto.setDireccionProveedor(direccionDigitada);
			dto.setNombreProveedor(nombreDigitado);
			dto.setTelefonoProveedor(telefonoDigitado);
			
			ProveedorLogica logica =new ProveedorLogica();
			boolean existeProveedor = logica.actualizar(dto);
			if (existeProveedor) {
				response.sendRedirect("/frontend/menuProveedores/menuProveedores.html");
			}else {
				response.sendRedirect("/frontend/usuarios/login.html");
			}
			
		}else if (borrar!=null) {
			ProveedorDTO dto = new ProveedorDTO();
			dto.setNitProveedor(nitDigitado);
			
			ProveedorLogica logica =new ProveedorLogica();
			boolean proveedorBorrado = logica.borrar(dto);
			if (proveedorBorrado) {
				response.sendRedirect("/frontend/menuProveedores/menuProveedores.html");
			}else {
				response.sendRedirect("/frontend/usuarios/login.html");
			}
		}
	}

}
