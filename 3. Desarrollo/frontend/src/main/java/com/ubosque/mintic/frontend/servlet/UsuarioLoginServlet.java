package com.ubosque.mintic.frontend.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ubosque.mintic.frontend.dto.UsuarioDTO;
import com.ubosque.mintic.frontend.logica.UsuarioLogica;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class UsuarioLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioLoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuarioDigitado = request.getParameter("txtUsuario");
		String contrasenaDigitada = request.getParameter("pwdContrasena");
		
		UsuarioDTO dto = new UsuarioDTO();
		dto.setUsuario(usuarioDigitado);
		dto.setPassword(contrasenaDigitada);
		
		UsuarioLogica logica = new UsuarioLogica();
		boolean existeUsuario = logica.ingresar(dto);
		if(existeUsuario) {
			response.sendRedirect("/frontend/menu/menuPrincipal.html");
		}else {
			response.sendRedirect("/frontend/usuarios/login.html");
		}
	}

}
