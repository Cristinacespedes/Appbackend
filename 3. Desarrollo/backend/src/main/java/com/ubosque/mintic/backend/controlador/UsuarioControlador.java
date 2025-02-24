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


import com.ubosque.mintic.backend.entidad.Usuario;
import com.ubosque.mintic.backend.servicio.UsuarioServicio;

@RestController
@RequestMapping(path = "usuarios")
public class UsuarioControlador {
	
	@Autowired
	private UsuarioServicio servicio;
	
	@PostMapping (path = "/crear")
	public @ResponseBody ResponseEntity crearUsuario(@RequestBody Usuario usuarioNuevo) {
		
		boolean respuestaServicio = servicio.crearUsuarioServicio(usuarioNuevo);
		
		ResponseEntity respuesta = null;
		if(respuestaServicio) {
			respuesta = new ResponseEntity("Usuario Creado",HttpStatus.CREATED);
		}else {
			respuesta = new ResponseEntity("Faltan datos del usuario", HttpStatus.NOT_ACCEPTABLE);
		}
		
		return respuesta;
	}
	
	
	@PutMapping
	public @ResponseBody ResponseEntity actualizarUsuario(@RequestBody Usuario usuarioActualizar) {
		
		boolean respuestaServicio = servicio.actualizarUsuarioServicio(usuarioActualizar);
		
		ResponseEntity respuesta = null;
		if(respuestaServicio) {
			respuesta = new ResponseEntity("Datos del Usuario Actualizados",HttpStatus.CREATED);
		}else {
			respuesta = new ResponseEntity("Datos faltantes", HttpStatus.NOT_ACCEPTABLE);
		}
		
		return respuesta;
	}
	
	@GetMapping("/consultar/{cedula}")
	public @ResponseBody ResponseEntity consultarUsuario(@PathVariable String cedula) {
		
		Usuario usuarioConsultado = servicio.consultarUsuarioServicio(cedula);
		
		ResponseEntity respuesta = null;
		if(usuarioConsultado != null) {
			respuesta = new ResponseEntity(usuarioConsultado,HttpStatus.OK);
		}else {
			respuesta = new ResponseEntity("USUARIO INEXISTENTE",HttpStatus.NO_CONTENT);
		}
		
		return respuesta;
	}
	@PostMapping("/login")
	public @ResponseBody ResponseEntity autenticarUsuario(@RequestBody Usuario usuarioNuevo) {
		
		Usuario usuarioAutenticado = servicio.autenticarUsuarioServicio(usuarioNuevo.getUsuario(), usuarioNuevo.getPassword());
		
		ResponseEntity respuesta = null;
		if(usuarioAutenticado != null) {
			respuesta = new ResponseEntity("AUTENTICADO",HttpStatus.OK);
		}else {
			respuesta = new ResponseEntity("CREDENCIALES INCONRRECTAS",HttpStatus.NO_CONTENT);
		}
		
		return respuesta;
	}

	@DeleteMapping("/borrar/{cedula}")
	public @ResponseBody ResponseEntity borrarUsuario(@PathVariable String cedula) {
		
		boolean usuarioBorrar = servicio.borrarUsuarioServicio(cedula);
		
		ResponseEntity respuesta = null;
		if(usuarioBorrar == true) {
			respuesta = new ResponseEntity("Datos del Usuario Borrados",HttpStatus.OK);
		}else {
			respuesta = new ResponseEntity("Cédula Errada",HttpStatus.NO_CONTENT);
		}
		
		return respuesta;
	}
	@GetMapping("/listar")
	public @ResponseBody ResponseEntity listarUsuarios() {
		
		List<Usuario> lista = servicio.consultarUsuariosServicio();
		
		ResponseEntity respuesta = new ResponseEntity(lista,HttpStatus.OK);
				
		return respuesta;
	}

}
