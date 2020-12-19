package com.curso.web.app.models.dao;

import java.util.List;

import com.curso.web.app.models.entity.Cliente;

public interface IClienteDao {
	
	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);

}
