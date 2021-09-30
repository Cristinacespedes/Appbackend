package com.ubosque.mintic.backend.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@PostMapping
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
			respuesta = new ResponseEntity("Datos del Usuario Actualizados",HttpStatus.OK);
		}else {
			respuesta = new ResponseEntity("Datos faltantes", HttpStatus.NOT_ACCEPTABLE);
		}
		
		return respuesta;
	}
	
	@GetMapping("/consultar")
	public @ResponseBody ResponseEntity consultarUsuario(@RequestBody Usuario usuarioNuevo) {
		
		Usuario usuarioConsultado = servicio.consultarUsuarioServicio(usuarioNuevo.getCedulaUsuario());
		
		ResponseEntity respuesta = null;
		if(usuarioConsultado != null) {
			respuesta = new ResponseEntity(usuarioConsultado,HttpStatus.OK);
		}else {
			respuesta = new ResponseEntity("USUARIO INEXISTENTE",HttpStatus.OK);
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

	@GetMapping("/borrar")
	public @ResponseBody ResponseEntity borrarUsuario(@RequestBody Usuario usuarioNuevo) {
		
		boolean usuarioBorrar = servicio.borrarUsuarioServicio(usuarioNuevo.getCedulaUsuario());
		
		ResponseEntity respuesta = null;
		if(usuarioBorrar == true) {
			respuesta = new ResponseEntity("Datos del Usuario Borrados",HttpStatus.OK);
		}else {
			respuesta = new ResponseEntity("Cédula Errada",HttpStatus.OK);
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
