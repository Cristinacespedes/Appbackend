package com.ubosque.mintic.frontend.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.ubosque.mintic.frontend.dto.ProveedorDTO;



public class ProveedorDAO {
	
	public boolean crearProveedor(ProveedorDTO dto) {
		Gson gson = new Gson();
		String proveedorJSON = gson.toJson(dto);
		
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/proveedores");
		Response respuesta = servicioREST.request().post(Entity.entity(proveedorJSON, MediaType.APPLICATION_JSON_TYPE));
		if(respuesta.getStatus()==201) {
			return true;
		}else if(respuesta.getStatus()==406) {
			return false;
		}
		return false;
	}
	
	public String listarProvedores(){
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/proveedores/listar");
		String respuesta = servicioREST.request().get(String.class);
		return respuesta;
	}
	
	public String consultarPorNit(ProveedorDTO dto) {
		String nit = dto.getNitProveedor();
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/proveedores/consultar/"+nit);
		String respuesta = servicioREST.request().get(String.class);
		return respuesta;
				
	}
	
	public boolean actualizarProveedor(ProveedorDTO dto) {
		Gson gson = new Gson();
		String proveedorJSON = gson.toJson(dto);
		
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/proveedores");
		Response respuesta = servicioREST.request().put(Entity.entity(proveedorJSON, MediaType.APPLICATION_JSON_TYPE));
		if(respuesta.getStatus()==201) {
			return true;
		}else if(respuesta.getStatus()==406) {
			return false;
		}
		return false;
	}
	
	public boolean borrarProveedor(ProveedorDTO proveedorBorrar) {
		String nit = proveedorBorrar.getNitProveedor();
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/proveedores/borrar/"+nit);
		Response respuesta = servicioREST.request().delete();
		if(respuesta.getStatus()==200) {
			return true;
		}
		return false;
	}

}
