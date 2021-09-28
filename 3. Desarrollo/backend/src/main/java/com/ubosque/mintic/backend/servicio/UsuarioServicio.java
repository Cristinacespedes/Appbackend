package com.ubosque.mintic.backend.servicio;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubosque.mintic.backend.entidad.Usuario;
import com.ubosque.mintic.backend.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {
	
	@Autowired
	private UsuarioRepositorio repositorio;
	
	public boolean crearUsuarioServicio(Usuario usuarioNuevo) {
		repositorio.save(usuarioNuevo);
		
		// TO-DO: Una vez insertado el usuario en la BD, podriamos enviar un correo de confirmacion
		return true;
	}
	
	
	public boolean actualizarUsuarioServicio(Usuario usuarioNuevo) {
		repositorio.save(usuarioNuevo);
		
		// TO-DO: Una vez insertado el usuario en la BD, podriamos enviar un correo de confirmacion
		return true;
	}


	public Usuario consultarUsuarioServicio(String cedula) throws EntityNotFoundException {
		Optional<Usuario> usuarioConsultado = repositorio.findById(cedula);
		Usuario usuarioEncontrado = usuarioConsultado.orElse(null);
		return usuarioEncontrado;
	}
	
	public Usuario autenticarUsuarioServicio(String usuario, String password) {
		Usuario usuarioBuscado = repositorio.findByUsuarioAndPassword(usuario, password);
		return usuarioBuscado;
	}
	
	public boolean borrarUsuarioServicio(String cedula) {
		repositorio.deleteById(cedula);		
		return true;
	}
	
	public List<Usuario> consultarUsuariosServicio() {
		
		List<Usuario> lista= (List<Usuario>) repositorio.findAll();        
		
		return lista;
	}

}
