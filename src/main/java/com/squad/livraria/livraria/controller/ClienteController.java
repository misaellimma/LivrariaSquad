package com.squad.livraria.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squad.livraria.livraria.entities.Cliente;
import com.squad.livraria.livraria.repositories.ClienteRepository;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("listar")
	public List<Cliente> listarCliente(){
		return clienteRepository.findAll();
	}
	
	@PostMapping("incluir")
	public String incluirCliente(@RequestBody Cliente cliente) {
		
		try{
			clienteRepository.save(cliente);
			clienteRepository.flush();
			return cliente.toString();
		}catch(Exception e) {
			return e.getMessage();
		}
	}
}
