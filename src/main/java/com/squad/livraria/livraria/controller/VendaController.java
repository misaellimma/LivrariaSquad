package com.squad.livraria.livraria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.squad.livraria.livraria.biz.VendaBiz;
import com.squad.livraria.livraria.entities.Venda;

public class VendaController {

	
	@GetMapping("listar")
	public List<Venda> listar(){
		return vendaRepositorio.findAll();
	}
	
	@PostMapping("add")
	public ArrayList<String> adicionar(@RequestBody Venda novoVenda) {
		ArrayList<String> mensagens = new ArrayList<>();
		VendaBiz validador = new VendaBiz(boiRepository,vendedorRepository,compradorRepository,leilaoRepository);
		try {
			validador.validarVenda(novoVenda);
			vendaRepositorio.save(novoVenda);
			vendaRepositorio.flush();
			mensagens.add("Sucesso ao adicionar venda");
		}catch(Exception error) {
			mensagens.add("Erro ao adicionar venda");
			mensagens.addAll(validador.getMsg());
			mensagens.add(error.getMessage());
		}
		return mensagens;
	}

}
