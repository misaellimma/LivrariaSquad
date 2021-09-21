package com.squad.livraria.livraria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squad.livraria.livraria.Mensagem;
import com.squad.livraria.livraria.biz.LivroBiz;
import com.squad.livraria.livraria.entities.Livro;
import com.squad.livraria.livraria.repositories.AutorRepository;
import com.squad.livraria.livraria.repositories.GeneroRepository;
import com.squad.livraria.livraria.repositories.LivroRepository;

@RestController
@RequestMapping(name = "livro")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private GeneroRepository generoRepository;
	
	@GetMapping("listar")
	public List<Livro> listarLivro(){
		return livroRepository.findAll();
	}
	
	@PostMapping("incluir")
	public Mensagem createLivro(@Validated @RequestBody Livro livro) {
		LivroBiz livroBiz = new LivroBiz(this.autorRepository, this.generoRepository);
		try {
			if(livroBiz.validar(livro)) {				
				livroRepository.save(livro);
				livroRepository.flush();		
				livroBiz.getMensagem().mensagem.add("Livro adicionado");
				livroBiz.getMensagem().mensagem.add("id: " + livro.getId());
			}
		} catch (Exception e)
		{
			livroBiz.getMensagem().mensagem.add("Erro ao Incluir: " + e.getMessage());
		}
		
		return livroBiz.getMensagem();
	}
	
	@PutMapping(path = "alterar/{id}")
	public Mensagem UpdateCliente(@PathVariable("id") Integer id, @RequestBody Livro livro) {
		LivroBiz livroBiz = new LivroBiz(this.autorRepository, this.generoRepository);
		try {
			if(livroBiz.validar(livro)) {
				Optional<Livro> livroOptional = livroRepository.findById(id);
				if(livroOptional.isPresent()) {
					Livro livroAlterar = livroOptional.get();
					livroAlterar.setTitulo(livro.getTitulo());
					livroAlterar.setIdautor(livro.getIdautor());
					livroAlterar.setIdgenero(livro.getIdgenero());
					livroAlterar.setAno(livro.getAno());
					livroAlterar.setValor(livro.getValor());
					livroRepository.save(livro);
					livroBiz.getMensagem().mensagem.add("Livro alterado");		
				}else {
					livroBiz.getMensagem().mensagem.add("Erro ao alterar: livro inexistente");					
				}
			}
		} catch (Exception e) {
			livroBiz.getMensagem().mensagem.add("Erro ao alterar: " + e.getMessage());
		}
		return livroBiz.getMensagem();
	}
}
