package com.ubosque.mintic.backend.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubosque.mintic.backend.entidad.DetalleVenta;
import com.ubosque.mintic.backend.repositorio.DetalleVentaRepositorio;

@RestController
@RequestMapping ("detalle_venta")
public class DetalleVentaControlador {

	@Autowired
	private DetalleVentaRepositorio detalleVentaDao;
	
	@PostMapping ("/guardar")
	public void guardar(@RequestBody DetalleVenta detalleVenta) {
		
	}
}
