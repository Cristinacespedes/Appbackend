package com.ubosque.mintic.frontend.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.ubosque.mintic.frontend.dto.ProductoDTO;

/**
 * Servlet implementation class SubirArchivoServlet
 */
@WebServlet("/SubirArchivoServlet")
@MultipartConfig
public class SubirArchivoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubirArchivoServlet() {
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
		PrintWriter out = response.getWriter();
		out.println("bienvenido al servlet");
		String nomb = request.getParameter("nombre");
		Part arch = request.getPart("archivo");
		InputStream is = arch.getInputStream();
		File f = new File("C:/Users/DESKTOP/Documents/Archivos/"+nomb);
		FileOutputStream ous = new FileOutputStream(f);
		int dato = is.read();
		while(dato != -1) {
			ous.write(dato);
			dato = is.read();
		}
		ous.close();
		is.close();
		FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String linea = null;
        List<ProductoDTO> lista = new ArrayList<ProductoDTO>();
        while((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            String codProducto = datos[0];
            String nombreProducto = datos[1];
            String nitProveedor = datos[2];
            String precioCompra = datos[3];
            String ivaCompra = datos[4];
            String precioVenta = datos[5];
            
            ProductoDTO p = new ProductoDTO();
            p.setCodigoProducto(Long.parseLong(codProducto));
            p.setNombreProducto(nombreProducto);
            p.setNitProveedor(Long.parseLong(nitProveedor));
            p.setPrecioCompra(Double.parseDouble(precioCompra)); 
            p.setIvacompra(Double.parseDouble(ivaCompra));
            p.setPrecioVenta(Double.parseDouble(precioVenta));
            
            lista.add(p);
        }
        br.close();
        
        Gson g = new Gson();
        String json = g.toJson(lista);
        out.println(json);
        //dao.consumirBack(json);
		
		
	}
}
