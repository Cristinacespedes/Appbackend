package com.ubosque.mintic.frontend.logica;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ubosque.mintic.frontend.dao.ProveedorDAO;
import com.ubosque.mintic.frontend.dto.ProveedorDTO;


public class ProveedorLogica {
	
	private ProveedorDAO dao;
	
	public ProveedorDTO consultarPorNit(ProveedorDTO proveedorConsultar) {
		
		dao= new ProveedorDAO();
		String json = dao.consultarPorNit(proveedorConsultar);
		ProveedorDTO proveedorConsultado = new ProveedorDTO();
		if(json !="PROVEEDOR INEXISTENTE") {
            Type tipoProveedor = new TypeToken<ProveedorDTO>(){}.getType();
			Gson gson= new Gson();
			proveedorConsultado =gson.fromJson(json, tipoProveedor);
		}else {
			proveedorConsultado=null;
		}
		return proveedorConsultado;

	}
	
	public List<ProveedorDTO> listar(){
		dao = new ProveedorDAO();
		String json = dao.listarProvedores();
		
		ArrayList<ProveedorDTO> lista;
		if(json  != null) {
            Type listType = new TypeToken<ArrayList<ProveedorDTO>>(){}.getType();
            Gson gson = new Gson();
            lista = gson.fromJson(json, listType);
        }else {
        	lista = new ArrayList<ProveedorDTO>();
        }
		return lista;
	}
	
	public boolean crear(ProveedorDTO dto) {
		dao = new ProveedorDAO();
		return dao.crearProveedor(dto);
	}
	
	public boolean actualizar(ProveedorDTO dto) {
		dao = new ProveedorDAO();
		return dao.crearProveedor(dto);
	}
	
	
	public boolean borrar(ProveedorDTO dto) {
		dao = new ProveedorDAO();
		return dao.borrarProveedor(dto);
	}

}
