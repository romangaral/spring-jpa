package com.curso.web.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.curso.web.app.models.dao.IClienteDao;
import com.curso.web.app.models.entity.Cliente;

@Controller
public class ClienteController {

	@Autowired
	@Qualifier("clienteDaoJPA")
	private IClienteDao clienteDao;
	
	@GetMapping(value = "/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteDao.findAll());
		return "listar";
	}
	
	@GetMapping(value = "/form")
	public String crear(Model model) {
		
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Formulario Cliente");
		return "form";
	}
	
	@GetMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id")Long id, Model model) {
		
		Cliente cliente = null;
		
		if(id > 0) {
			cliente = clienteDao.findOne(id);
		}else {
			return "redirect:/listar";
		}
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Formulario Cliente");
		return "form";
	}
	
	@PostMapping(value = "/form")
	public String guardar(Cliente cliente) {
		clienteDao.save(cliente);
		return "redirect:/listar";
	}
	
}
