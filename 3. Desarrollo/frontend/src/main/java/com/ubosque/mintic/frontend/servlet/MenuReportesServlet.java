package com.ubosque.mintic.frontend.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ubosque.mintic.frontend.dto.ClienteDTO;
import com.ubosque.mintic.frontend.dto.UsuarioDTO;
import com.ubosque.mintic.frontend.logica.ClienteLogica;
import com.ubosque.mintic.frontend.logica.UsuarioLogica;

/**
 * Servlet implementation class MenuReportesServlet
 */
@WebServlet("/MenuReportesServlet")
public class MenuReportesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuReportesServlet() {
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
		String listaUsuarios = request.getParameter("ListaUsuarios");
		String listaClientes = request.getParameter("ListaClientes");
		String ventas = request.getParameter("Ventas");
		
		String titulo ="";
		
		if (listaUsuarios !=null) {
			titulo ="Listado de Usuarios";
		}
		if (listaClientes !=null) {
			titulo ="Listado de Clientes";
		}
		if (ventas !=null) {
			titulo ="Total ventas por cliente";
		}
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("  <head>"+"<meta charset=\"UTF-8\">");
		pw.println("    <title> Tienda Genérica | "+ titulo+"</title>");
		pw.println("    <link rel='stylesheet' type='text/css' href='cssReportes/style.css'>");
		pw.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		pw.println("   </head><body>");
		pw.println("   <div class='content'>");
		pw.println("      <form action=''>");
		pw.println("       <div class='containerb'>");
		pw.println("        <div class='button'>");
		pw.println("          <input type='submit' formnovalidate='formnovalidate' formaction='/frontend/menuUsuarios/menuUsuarios.jsp' value='Usuarios'>");
		pw.println("          <input type='submit' formnovalidate='formnovalidate' formaction='/frontend/menuClientes/menuClientes.jsp' value='Clientes'>");
		pw.println("          <input type='submit' formnovalidate='formnovalidate' formaction='/frontend/menuProveedores/menuProveedores.jsp' value='Proveedores'");
		pw.println("          <input type='submit' formnovalidate='formnovalidate' formaction='/frontend/menuProductos/menuProductos.html' value='Productos'>");
		pw.println("          <input type='submit' formnovalidate='formnovalidate' formaction='/frontend/menuVentas/menuVentas.html' value='Ventas'>");
		pw.println("          <input type='submit' formnovalidate='formnovalidate' formaction='/frontend/menuReportes/menuReportes.html' value='Reportes'>");
		pw.println("        </div>");
		pw.println("       </div>");
		pw.println("   <div class='container'>");
		pw.println("    <div class='title'>"+ titulo+ "</div>");
		pw.println("    <div class='content'>");
		pw.println("      <form action=''>");
		pw.println("        <div class='user-details'>");
		pw.println("         <table>");
		
		if (listaUsuarios !=null) {
			pw.println("          <tr>");
			pw.println("           <th>Cédula</th>");
			pw.println("           <th>Nombre</th>");
			pw.println("           <th>Correo electrónico</th>");
			pw.println("           <th>Usuario</th>");
			pw.println("           <th>Contraseña</th>");
			pw.println("          </tr>");
				UsuarioLogica logica = new UsuarioLogica();
				List<UsuarioDTO> lista = logica.listar();
				for (int i=0;i<lista.size();i++) {
					UsuarioDTO usuario = lista.get(i);
					pw.println("         <tr><td>"+usuario.getCedulaUsuario()+"</td><td>"+usuario.getNombreUsuario()+"</td><td>"+usuario.getEmailUsuario()+"</td><td>"+usuario.getUsuario()+"</td><td>"+usuario.getPassword()+"</td></td>");
				}
				pw.println("        </table></form></div></div>");
				pw.println("</body>");
				pw.println("</html>");
				//pw.println("");
		}else if (listaClientes !=null) {
			pw.println("<tr><th>Cédula</th><th>Nombre</th><th>Correo electrónico</th><th>Dirección</th><th>Teléfono</th></tr>");
			ClienteLogica logica = new ClienteLogica();
			List<ClienteDTO> lista = logica.listar();
			for (int i=0;i<lista.size();i++) {
				ClienteDTO cliente = lista.get(i);
				pw.println("         <tr><td>"+cliente.getCedulaCliente()+"</td><td>"+cliente.getNombreCliente()+"</td><td>"+cliente.getEmailCliente()+"</td><td>"+cliente.getDireccionCliente()+"</td><td>"+cliente.getTelefonoCliente()+"</td></td>");
			}
			pw.println("        </table></form></div></div>");
			pw.println("</body>");
			pw.println("</html>");
		}else if (ventas !=null) {
			pw.println("Tabla ventas");
		}
		//pw.println("</table></form></div></div>");
		//pw.println("</body>");
		//pw.println("</html>");
		//pw.println("");
		
		
	}

}
