package com.ubosque.mintic.backend.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ubosque.mintic.backend.entidad.Proveedore;

@Repository
public interface ProveedoreRepositorio extends CrudRepository<Proveedore, String>{

}
