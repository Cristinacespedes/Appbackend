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
import com.ubosque.mintic.frontend.dto.ClienteDTO;
import com.ubosque.mintic.frontend.dto.UsuarioDTO;



public class ClienteDAO {
	
	public boolean crearCliente(ClienteDTO dto) {
		Gson gson = new Gson();
		String clienteJSON = gson.toJson(dto);
		
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/usuarios/crear");
		Response respuesta = servicioREST.request().post(Entity.entity(clienteJSON, MediaType.APPLICATION_JSON_TYPE));
		if(respuesta.getStatus()==201) {
			return true;
		}else if(respuesta.getStatus()==404) {
			return false;
		}
		return false;
	}
	
	public String listarClientes(){
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/clientes/listar");
		String respuesta = servicioREST.request().get(String.class);
		return respuesta;
	}
	
	public String consultarPorCedula(ClienteDTO dto) {
		String cedula = dto.getCedulaCliente();
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/usuarios/consultar/"+cedula);
		String respuesta = servicioREST.request().get(String.class);
		return respuesta;
				
	}
	
	public boolean actualizarCliente(ClienteDTO dto) {
		Gson gson = new Gson();
		String clienteJSON = gson.toJson(dto);
		
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/clientes");
		Response respuesta = servicioREST.request().put(Entity.entity(clienteJSON, MediaType.APPLICATION_JSON_TYPE));
		if(respuesta.getStatus()==201) {
			return true;
		}else if(respuesta.getStatus()==404) {
			return false;
		}
		return false;
	}
	
	public boolean borrarCliente(ClienteDTO clienteBorrar) {
		String cedula = clienteBorrar.getCedulaCliente();
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/usuarios/borrar/"+cedula);
		Response respuesta = servicioREST.request().delete();
		if(respuesta.getStatus()==200) {
			return true;
		}
		return false;
	}

}
