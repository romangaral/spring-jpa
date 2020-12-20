package com.curso.web.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.curso.web.app.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
