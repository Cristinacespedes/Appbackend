package com.ubosque.mintic.backend.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ubosque.mintic.backend.entidad.Proveedore;
import com.ubosque.mintic.backend.servicio.ProveedorServicio;

@RestController
@RequestMapping(path = "proveedores")
public class ProveedorControlador {
	
	@Autowired
	private ProveedorServicio servicio;
	
	@PostMapping
	public @ResponseBody ResponseEntity crearProveedor(@RequestBody Proveedore proveedorNuevo) {
		
		boolean respuestaServicio = servicio.crearProveedorServicio(proveedorNuevo);
		
		ResponseEntity respuesta = null;
		if(respuestaServicio) {
			respuesta = new ResponseEntity("Proveedor Creado",HttpStatus.CREATED);
		}else {
			respuesta = new ResponseEntity("Faltan datos del proveedor", HttpStatus.NOT_ACCEPTABLE);
		}
		
		return respuesta;
	}

	@PutMapping
	public @ResponseBody ResponseEntity actualizarProveedor(@RequestBody Proveedore proveedorActualizar) {
		
		boolean respuestaServicio = servicio.actualizarProveedorServicio(proveedorActualizar);
		
		ResponseEntity respuesta = null;
		if(respuestaServicio) {
			respuesta = new ResponseEntity("Datos del proveedor Actualizados",HttpStatus.CREATED);
		}else {
			respuesta = new ResponseEntity("Datos faltantes", HttpStatus.NOT_ACCEPTABLE);
		}
		
		return respuesta;
	}
	
	@GetMapping("/consultar/{nit}")
	public @ResponseBody ResponseEntity consultarProveedor(@PathVariable String nit) {
		
		Proveedore proveedorConsultado = servicio.consultarProveedorServicio(nit);
		
		ResponseEntity respuesta = null;
		if(proveedorConsultado != null) {
			respuesta = new ResponseEntity(proveedorConsultado,HttpStatus.OK);
		}else {
			respuesta = new ResponseEntity("PROVEEDOR INEXISTENTE",HttpStatus.NO_CONTENT);
		}
		
		return respuesta;
	}


	@DeleteMapping("/borrar/{nit}")
	public @ResponseBody ResponseEntity borrarProveedor(@PathVariable String nit) {
		
		boolean proveedorBorrar = servicio.borrarProveedorServicio(nit);
		
		ResponseEntity respuesta = null;
		if(proveedorBorrar == true) {
			respuesta = new ResponseEntity("Datos del Proveedor Borrados",HttpStatus.OK);
		}else {
			respuesta = new ResponseEntity("NIT Errado",HttpStatus.NO_CONTENT);
		}
		
		return respuesta;
	}
	
	@GetMapping("/listar")
	public @ResponseBody ResponseEntity listarProveedores() {
		
		List<Proveedore> lista = servicio.consultarProveedoresServicio();
		ResponseEntity respuesta = new ResponseEntity(lista,HttpStatus.OK);
				
		return respuesta;
	}


}
