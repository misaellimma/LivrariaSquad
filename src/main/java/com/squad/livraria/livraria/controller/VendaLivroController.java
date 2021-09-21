package com.squad.livraria.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squad.livraria.livraria.entities.VendaLivro;
import com.squad.livraria.livraria.repositories.VendaLivroRepository;

@RestController
@RequestMapping("vendalivro")
public class VendaLivroController {
	@Autowired
	private VendaLivroRepository vendaLivroRepositorio;
	
	@GetMapping("listar")
	public List<VendaLivro> listar(){
		return vendaLivroRepositorio.findAll();
	}
	@PostMapping("incluir")
	public String incluir(@RequestBody VendaLivro novaVendaLivro) {
		vendaLivroRepositorio.save(novaVendaLivro);
		return ("Sucesso!");
	}
}
