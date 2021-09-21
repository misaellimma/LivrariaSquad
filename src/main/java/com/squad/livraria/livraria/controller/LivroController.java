package com.squad.livraria.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squad.livraria.livraria.repositories.LivroRepository;

@RestController
@RequestMapping(name = "livro")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	
	
	
}
