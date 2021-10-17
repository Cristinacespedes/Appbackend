package com.ubosque.mintic.frontend.dao;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.ubosque.mintic.frontend.dto.ProductoDTO;

public class ProductoDAO {
	
	public boolean crearProductos(String lista) {
		
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/productos");
		Response respuesta = servicioREST.request().post(Entity.entity(lista, MediaType.APPLICATION_JSON_TYPE));
		if(respuesta.getStatus()==201) {
			return true;
		}else if(respuesta.getStatus()==406) {
			return false;
		}
		return false;
	}
	
	public String consultarProducto(ProductoDTO productoAConsultar){
		String cod = productoAConsultar.getCodigoProducto();
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/producto/consultar/"+cod);
		String respuesta = servicioREST.request().get(String.class);
		return respuesta;
	}

}
