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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ubosque.mintic.backend.entidad.Cliente;
import com.ubosque.mintic.backend.entidad.Usuario;
import com.ubosque.mintic.backend.servicio.ClienteServicio;

@RestController
@RequestMapping(path = "clientes")
public class ClienteControlador {
	
	@Autowired
	private ClienteServicio servicio;
	
	@PostMapping
	public @ResponseBody ResponseEntity crearCliente(@RequestBody Cliente clienteNuevo) {
		
		boolean respuestaServicio = servicio.crearClienteServicio(clienteNuevo);
		
		ResponseEntity respuesta = null;
		if(respuestaServicio) {
			respuesta = new ResponseEntity("Cliente Creado",HttpStatus.CREATED);
		}else {
			respuesta = new ResponseEntity("Faltan datos del cliente", HttpStatus.NOT_ACCEPTABLE);
		}
		
		return respuesta;
	}

	@PutMapping
	public @ResponseBody ResponseEntity actualizarCliente(@RequestBody Cliente clienteActualizar) {
		
		boolean respuestaServicio = servicio.actualizarClienteServicio(clienteActualizar);
		
		ResponseEntity respuesta = null;
		if(respuestaServicio) {
			respuesta = new ResponseEntity("Datos del cliente Actualizados",HttpStatus.CREATED);
		}else {
			respuesta = new ResponseEntity("Datos faltantes", HttpStatus.NOT_ACCEPTABLE);
		}
		
		return respuesta;
	}
	
	@GetMapping("/consultar/{cedula}")
	public @ResponseBody ResponseEntity consultarCliente(@PathVariable String cedula) {
		
		Cliente clienteConsultado = servicio.consultarClienteServicio(cedula);
		
		ResponseEntity respuesta = null;
		if(clienteConsultado != null) {
			respuesta = new ResponseEntity(clienteConsultado,HttpStatus.OK);
		}else {
			respuesta = new ResponseEntity("CLIENTE INEXISTENTE",HttpStatus.NO_CONTENT);
		}
		
		return respuesta;
	}


	@DeleteMapping("/borrar/{cedula}")
	public @ResponseBody ResponseEntity borrarCliente(@PathVariable String cedula) {
		
		boolean clienteBorrar = servicio.borrarClienteServicio(cedula);
		
		ResponseEntity respuesta = null;
		if(clienteBorrar == true) {
			respuesta = new ResponseEntity("Datos del Cliente Borrados",HttpStatus.OK);
		}else {
			respuesta = new ResponseEntity("Cédula Errada",HttpStatus.NO_CONTENT);
		}
		
		return respuesta;
	}
	
	@GetMapping("/listar")
	public @ResponseBody ResponseEntity listarClientes() {
		
		List<Cliente> lista = servicio.consultarClientesServicio();
		ResponseEntity respuesta = new ResponseEntity(lista,HttpStatus.OK);
				
		return respuesta;
	}


}

