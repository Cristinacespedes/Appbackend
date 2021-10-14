package com.ubosque.mintic.backend.servicio;

import org.springframework.stereotype.Service;

import com.ubosque.mintic.backend.entidad.Proveedore;
import com.ubosque.mintic.backend.repositorio.ProveedoreRepositorio;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProveedorServicio {

	@Autowired
	private ProveedoreRepositorio repositorio;
	
	public boolean crearProveedorServicio(Proveedore proveedorNuevo) {
		repositorio.save(proveedorNuevo);
		
		return true;
		}
	
		public boolean actualizarProveedorServicio(Proveedore proveedorNuevo) {
			repositorio.save(proveedorNuevo);
			
			return true;
		}


		public Proveedore consultarProveedorServicio(String nit) throws EntityNotFoundException {
			Optional<Proveedore> proveedorConsultado = repositorio.findById(nit);
			Proveedore proveedorEncontrado = proveedorConsultado.orElse(null);
			return proveedorEncontrado;
		}
		

		public boolean borrarProveedorServicio(String nit) {
			repositorio.deleteById(nit);		
			return true;
		}
		
		public List<Proveedore> consultarProveedoresServicio() {
			
			List<Proveedore> lista= (List<Proveedore>) repositorio.findAll();        
			
			return lista;
		}

}
