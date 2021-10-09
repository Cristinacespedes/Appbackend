package com.ubosque.mintic.frontend.logica;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ubosque.mintic.frontend.dao.UsuarioDAO;
import com.ubosque.mintic.frontend.dto.UsuarioDTO;

public class UsuarioLogica {
	
	private UsuarioDAO dao;
	
	public boolean ingresar(UsuarioDTO dto) {
		dao = new UsuarioDAO();
		return dao.consultarPorUsuarioYContrasena(dto);
	}
	
	public UsuarioDTO consultarPorCedula(UsuarioDTO usuarioAConsultar) {
		
		dao= new UsuarioDAO();
		String json = dao.consultarPorCedula(usuarioAConsultar);
		UsuarioDTO usuarioConsultado = new UsuarioDTO();
		if(json !="USUARIO INEXISTENTE") {
            Type tipoUsuario = new TypeToken<UsuarioDTO>(){}.getType();
			Gson gson= new Gson();
			usuarioConsultado =gson.fromJson(json, tipoUsuario);
		}else {
			usuarioConsultado=null;
		}
		return usuarioConsultado;
		//return dao.consultarPorCedula(usuarioAConsultar);
	}
	
	public List<UsuarioDTO> listar(){
		dao = new UsuarioDAO();
		String json = dao.listarUsuarios();
		
		ArrayList<UsuarioDTO> lista;
		if(json  != null) {
            Type listType = new TypeToken<ArrayList<UsuarioDTO>>(){}.getType();
            Gson gson = new Gson();
            lista = gson.fromJson(json, listType);
        }else {
        	lista = new ArrayList<UsuarioDTO>();
        }
		return lista;
	}
	
	public boolean crear(UsuarioDTO dto) {
		dao = new UsuarioDAO();
		return dao.crearUsuario(dto);
	}
	
	public boolean actualizar(UsuarioDTO dto) {
		dao = new UsuarioDAO();
		return dao.crearUsuario(dto);
	}
	
	
	public boolean borrar(UsuarioDTO dto) {
		dao = new UsuarioDAO();
		return dao.borrarUsuario(dto);
	}

}
