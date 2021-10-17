package com.ubosque.mintic.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubosque.mintic.backend.entidad.Venta;

public interface VentasRepositorio extends JpaRepository <Venta, Long> {

}
