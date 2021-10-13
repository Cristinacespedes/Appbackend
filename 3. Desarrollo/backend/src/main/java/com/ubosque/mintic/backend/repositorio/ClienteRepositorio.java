package com.ubosque.mintic.backend.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ubosque.mintic.backend.entidad.Cliente;

@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente, String>{

}
