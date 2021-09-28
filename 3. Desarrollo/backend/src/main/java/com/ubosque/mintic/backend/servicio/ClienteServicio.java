package com.ubosque.mintic.backend.servicio;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubosque.mintic.backend.entidad.Cliente;
import com.ubosque.mintic.backend.entidad.Usuario;
import com.ubosque.mintic.backend.repositorio.ClienteRepositorio;

@Service
public class ClienteServicio {
	@Autowired
	private ClienteRepositorio repositorio;
	
	public boolean crearClienteServicio(Cliente clienteNuevo) {
		repositorio.save(clienteNuevo);
		
		// TO-DO: Una vez insertado el cliente en la BD, podriamos enviar un correo de confirmacion
		return true;
	}
	
	
	public boolean actualizarClienteServicio(Cliente clienteNuevo) {
		repositorio.save(clienteNuevo);
		
		// TO-DO: Una vez insertado el cliente en la BD, podriamos enviar un correo de confirmacion
		return true;
	}


	public Cliente consultarClienteServicio(String cedula) throws EntityNotFoundException {
		Optional<Cliente> clienteConsultado = repositorio.findById(cedula);
		Cliente clienteEncontrado = clienteConsultado.orElse(null);
		return clienteEncontrado;
	}
	

	public boolean borrarClienteServicio(String cedula) {
		repositorio.deleteById(cedula);		
		return true;
	}
	
	public List<Cliente> consultarClientesServicio() {
		
		List<Cliente> lista= (List<Cliente>) repositorio.findAll();        
		
		return lista;
	}

}