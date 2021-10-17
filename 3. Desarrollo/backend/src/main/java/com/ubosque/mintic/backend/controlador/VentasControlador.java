package com.ubosque.mintic.backend.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubosque.mintic.backend.entidad.Venta;
import com.ubosque.mintic.backend.repositorio.VentasRepositorio;

@RestController
@RequestMapping("ventas")
public class VentasControlador {

	@Autowired
	private VentasRepositorio ventasDao;
	
	@PostMapping ("/guardar")
	public void guardar(@RequestBody Venta ventas) {
		ventasDao.save(ventas);
	}
}
