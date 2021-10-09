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
import com.ubosque.mintic.frontend.dto.UsuarioDTO;



public class UsuarioDAO {
	
	public static void main(String[] args) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setCedulaUsuario("999");
		dto.setEmailUsuario("correo@mail.com");
		dto.setNombreUsuario("Nombre Correo");
		dto.setUsuario("correo");
		dto.setPassword("999");
		UsuarioDAO dao = new UsuarioDAO();
		//dao.crearUsuario(dto);
		//dao.listarUsuarios();
		dao.consultarPorUsuarioYContrasena(dto);
	}
	
	public boolean crearUsuario(UsuarioDTO dto) {
		Gson gson = new Gson();
		String usuarioJSON = gson.toJson(dto);
		
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/usuarios/crear");
		Response respuesta = servicioREST.request().post(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE));
		if(respuesta.getStatus()==201) {
			return true;
		}else if(respuesta.getStatus()==404) {
			return false;
		}
		return false;
	}
	
	public String listarUsuarios(){
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/usuarios/listar");
		String respuesta = servicioREST.request().get(String.class);
		return respuesta;
	}
	
	public String consultarPorCedula(UsuarioDTO dto) {
		//Gson gson = new Gson();
		//String usuarioJSON = gson.toJson(dto);
		String cedula = dto.getCedulaUsuario();
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/usuarios/consultar/"+cedula);
		String respuesta = servicioREST.request().get(String.class);
		//Response consulta = servicioREST.request().post(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE));		
		//String respuesta = consulta.readEntity(String.class);
		return respuesta;
				
	}
	
	public boolean consultarPorUsuarioYContrasena(UsuarioDTO dto) {
		Gson gson = new Gson();
		String usuarioJSON = gson.toJson(dto);
		
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/usuarios/login");
		Response respuesta = servicioREST.request().post(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE));

		if(respuesta.getStatus()==200) {
			return true;
		}else if(respuesta.getStatus()==204) {
			return false;
		}
		return false;		
	}
	
	public boolean actualizarUsuario(UsuarioDTO dto) {
		Gson gson = new Gson();
		String usuarioJSON = gson.toJson(dto);
		
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/usuarios");
		Response respuesta = servicioREST.request().put(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE));
		if(respuesta.getStatus()==201) {
			return true;
		}else if(respuesta.getStatus()==404) {
			return false;
		}
		return false;
	}
	
	public boolean borrarUsuario(UsuarioDTO usr) {
		String cedula = usr.getCedulaUsuario();
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/usuarios/borrar/"+cedula);
		Response respuesta = servicioREST.request().delete();
		if(respuesta.getStatus()==200) {
			return true;
		}
		return false;
	}

}
