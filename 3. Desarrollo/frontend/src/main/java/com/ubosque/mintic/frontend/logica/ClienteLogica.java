package com.ubosque.mintic.frontend.logica;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ubosque.mintic.frontend.dao.ClienteDAO;
import com.ubosque.mintic.frontend.dto.ClienteDTO;


public class ClienteLogica {
	
	private ClienteDAO dao;
	
	public ClienteDTO consultarPorCedula(ClienteDTO ClienteAConsultar) {
		
		dao= new ClienteDAO();
		String json = dao.consultarPorCedula(ClienteAConsultar);
		ClienteDTO clienteConsultado = new ClienteDTO();
		if(json !="CLIENTE INEXISTENTE") {
            Type tipoCliente = new TypeToken<ClienteDTO>(){}.getType();
			Gson gson= new Gson();
			clienteConsultado =gson.fromJson(json, tipoCliente);
		}else {
			clienteConsultado=null;
		}
		return clienteConsultado;

	}
	
	public List<ClienteDTO> listar(){
		dao = new ClienteDAO();
		String json = dao.listarClientes();
		
		ArrayList<ClienteDTO> lista;
		if(json  != null) {
            Type listType = new TypeToken<ArrayList<ClienteDTO>>(){}.getType();
            Gson gson = new Gson();
            lista = gson.fromJson(json, listType);
        }else {
        	lista = new ArrayList<ClienteDTO>();
        }
		return lista;
	}
	
	public boolean crear(ClienteDTO dto) {
		dao = new ClienteDAO();
		return dao.crearCliente(dto);
	}
	
	public boolean actualizar(ClienteDTO dto) {
		dao = new ClienteDAO();
		return dao.crearCliente(dto);
	}
	
	
	public boolean borrar(ClienteDTO dto) {
		dao = new ClienteDAO();
		return dao.borrarCliente(dto);
	}

}
