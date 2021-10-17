package com.ubosque.mintic.frontend.logica;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ubosque.mintic.frontend.dao.ProductoDAO;
import com.ubosque.mintic.frontend.dao.ProveedorDAO;
import com.ubosque.mintic.frontend.dto.ProductoDTO;
import com.ubosque.mintic.frontend.dto.ProveedorDTO;


public class ProductoLogica {
	
	private ProductoDAO dao;
	
	public ProductoDTO consultarProducto(ProductoDTO productoAConsultar) {
		dao= new ProductoDAO();
		String json = dao.consultarProducto(productoAConsultar);
		ProductoDTO productoConsultado = new ProductoDTO();
		if(json !="PRODUCTO INEXISTENTE") {
            Type tipoProducto = new TypeToken<ProductoDTO>(){}.getType();
			Gson gson= new Gson();
			productoConsultado =gson.fromJson(json, tipoProducto);
		}else {
			productoConsultado=null;
		}
		return productoConsultado;

	}
	
}
