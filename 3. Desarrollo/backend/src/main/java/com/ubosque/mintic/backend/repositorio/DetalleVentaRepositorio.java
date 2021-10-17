package com.ubosque.mintic.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubosque.mintic.backend.entidad.DetalleVenta;

public interface DetalleVentaRepositorio extends JpaRepository <DetalleVenta, Long> {

}
