package com.ubosque.mintic.backend.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ubosque.mintic.backend.entidad.Producto;

@Repository
public interface ProductoRepositorio extends CrudRepository<Producto, String>{

}
