package com.ubosque.mintic.backend.servicio;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubosque.mintic.backend.entidad.Producto;
import com.ubosque.mintic.backend.repositorio.ProductoRepositorio;

@Service
public class ProductoServicio {
	
	@Autowired
	private ProductoRepositorio repositorio;
	
	public boolean cargarProductosServicio(List<Producto> listaProductos) {
		repositorio.saveAll(listaProductos);
		
		return true;
		}
	
	public List<Producto> consultarProductosServicio() {
		
		List<Producto> lista= (List<Producto>) repositorio.findAll();        
		
		return lista;
	}
	
	public Producto consultarProductoServicio(String cod) throws EntityNotFoundException {
		Optional<Producto> productoConsultado = repositorio.findById(cod);
		Producto productoEncontrado = productoConsultado.orElse(null);
		return productoEncontrado;
	}

}
