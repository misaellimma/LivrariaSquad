package com.squad.livraria.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squad.livraria.livraria.Mensagem;
import com.squad.livraria.livraria.biz.VendaBiz;
import com.squad.livraria.livraria.entities.Venda;
import com.squad.livraria.livraria.repositories.ClienteRepository;
import com.squad.livraria.livraria.repositories.VendaRepository;

@RestController
@RequestMapping("venda")
public class VendaController {
	@Autowired
	private VendaRepository vendaRepositorio;
	@Autowired
	private ClienteRepository clienteRepositorio;
	
	@GetMapping("listar")
	public List<Venda> listar(){
		return vendaRepositorio.findAll();
	}
	
	@PostMapping("incluir")
	public Mensagem incluir(@RequestBody Venda novoVenda) {
		
		VendaBiz validador = new VendaBiz(clienteRepositorio);
		
		try {
			if (validador.validarVenda(novoVenda)) {
				vendaRepositorio.save(novoVenda);
				clienteRepositorio.flush();
				validador.getMsg().mensagem.add("Incluido com sucesso");    
			}
		}catch(Exception e) {
			validador.getMsg().mensagem.add("Erro ao Incluir:" + e.getMessage());
		}
		
		return validador.getMsg();
	}
	
}


