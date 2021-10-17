package com.ubosque.mintic.backend.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ubosque.mintic.backend.entidad.Producto;
import com.ubosque.mintic.backend.entidad.Usuario;
import com.ubosque.mintic.backend.repositorio.ProductoRepositorio;
import com.ubosque.mintic.backend.repositorio.UsuarioRepositorio;
import com.ubosque.mintic.backend.servicio.ProductoServicio;

@RestController
@RequestMapping(path = "productos")
public class ProductoControlador {
	
	@Autowired
	private ProductoServicio servicio;
	
	
	@PostMapping
	public @ResponseBody ResponseEntity cargarProductos(@RequestBody List<Producto> listaProductos) {
		
		boolean respuestaServicio = servicio.cargarProductosServicio(listaProductos);
		
		ResponseEntity respuesta = null;
		if(respuestaServicio) {
			respuesta = new ResponseEntity("Archivo Cargado Exitosamente",HttpStatus.CREATED);
		}else {
			respuesta = new ResponseEntity("Error: formato de archivo inválido", HttpStatus.NOT_ACCEPTABLE);
		}
		
		return respuesta;
	}
	
	@GetMapping("/listar")
	public @ResponseBody ResponseEntity consultarProductos() {
		
		List<Producto> lista = servicio.consultarProductosServicio();
		ResponseEntity respuesta = new ResponseEntity(lista,HttpStatus.OK);
				
		return respuesta;
	}

	
	
	@GetMapping("/consultar/{cod}")
	public @ResponseBody ResponseEntity consultarProducto(@PathVariable String cod) {
		
		Producto productoConsultado = servicio.consultarProductoServicio(cod);
		
		ResponseEntity respuesta = null;
		if(productoConsultado != null) {
			respuesta = new ResponseEntity(productoConsultado,HttpStatus.OK);
		}else {
			respuesta = new ResponseEntity("PRODUCTO INEXISTENTE",HttpStatus.NO_CONTENT);
		}
		
		return respuesta;
	}

}
