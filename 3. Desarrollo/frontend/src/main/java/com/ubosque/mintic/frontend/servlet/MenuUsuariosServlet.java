package com.ubosque.mintic.frontend.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ubosque.mintic.frontend.dao.UsuarioDAO;
import com.ubosque.mintic.frontend.dto.UsuarioDTO;
import com.ubosque.mintic.frontend.logica.UsuarioLogica;

/**
 * Servlet implementation class MenuUsuariosServlet
 */
@WebServlet("/MenuUsuariosServlet")
public class MenuUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuUsuariosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
		String correoDigitado = request.getParameter("emCorreo");
		String nombreDigitado = request.getParameter("txtNombre");
		String contrasenaDigitada = request.getParameter("pwdContrasena");
		String usuarioDigitado = request.getParameter("txtUsuario");
		
		if (consultar !=null) {
			UsuarioDTO dto = new UsuarioDTO();
			dto.setCedulaUsuario(cedulaDigitada);
			UsuarioLogica logica = new UsuarioLogica();
			UsuarioDTO usuarioConsultado = logica.consultarPorCedula(dto);
			if(usuarioConsultado !=null) {
				response.sendRedirect("/frontend/menu/menuPrincipal.html");
			}else {
				response.sendRedirect("/frontend/usuarios/login.html");
			};
		}else if(crear != null){
			
			UsuarioDTO dto = new UsuarioDTO();
			dto.setCedulaUsuario(cedulaDigitada);
			dto.setEmailUsuario(correoDigitado);
			dto.setNombreUsuario(nombreDigitado);
			dto.setPassword(contrasenaDigitada);
			dto.setUsuario(usuarioDigitado);
			
			UsuarioLogica logica = new UsuarioLogica();
			boolean existeUsuario = logica.crear(dto);
			if(existeUsuario) {
				response.sendRedirect("/frontend/menuUsuarios/menuUsuarios.html");
			}else {
				response.sendError(0);
			}
		}else if(actualizar != null){
			
			UsuarioDTO dto = new UsuarioDTO();
			dto.setCedulaUsuario(cedulaDigitada);
			dto.setEmailUsuario(correoDigitado);
			dto.setNombreUsuario(nombreDigitado);
			dto.setPassword(contrasenaDigitada);
			dto.setUsuario(usuarioDigitado);
			
			UsuarioLogica logica = new UsuarioLogica();
			boolean existeUsuario = logica.actualizar(dto);
			if(existeUsuario) {
				response.sendRedirect("/frontend/menuUsuarios/menuUsuarios.html");
			}else {
				response.sendError(0);
			}
			
		}	else if (borrar !=null) {
			UsuarioDTO dto = new UsuarioDTO();
			dto.setCedulaUsuario(cedulaDigitada);
			UsuarioLogica logica = new UsuarioLogica();
			boolean usuarioBorrado = logica.borrar(dto);
			if(usuarioBorrado !=false) {
				response.sendRedirect("/frontend/menu/menuPrincipal.html");
			}else {
				response.sendRedirect("/frontend/usuarios/login.html");
			};
		}
		
		
	}


}
