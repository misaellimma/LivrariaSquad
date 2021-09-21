package com.squad.livraria.livraria.biz;

import com.squad.livraria.livraria.Mensagem;
import com.squad.livraria.livraria.entities.Livro;
import com.squad.livraria.livraria.repositories.AutorRepository;
import com.squad.livraria.livraria.repositories.GeneroRepository;

public class LivroBiz {
	private Mensagem mensagem;
	
	private AutorRepository autorRepository;
	private GeneroRepository generoRepository;
	
	public LivroBiz(AutorRepository autorRepository, GeneroRepository generoRepository) {
		this.autorRepository = autorRepository;
		this.generoRepository = generoRepository;
		this.mensagem = new Mensagem();
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}
	
	public Boolean validar(Livro livro) {
		Boolean valido = true;
		if(livro.getTitulo().isEmpty()) {
			getMensagem().mensagem.add("O título não deve estar vazio!");
			valido = false;
		}
		if(livro.getTitulo().length() > 50) {
			getMensagem().mensagem.add("O título não deve ser maior que 50 caracteres!");
			valido = false;
		}
		if(autorRepository.findById(livro.getIdautor()).isEmpty()) {
			getMensagem().mensagem.add("O autor não está cadastrado!");
			valido = false;
		}
		if(livro.getIdautor() == null) {
			getMensagem().mensagem.add("O autor não deve ser vazio!");
			valido = false;
		}
		if(generoRepository.findById(livro.getIdgenero()).isEmpty()) {
			getMensagem().mensagem.add("O genero não está cadastrado!");
			valido = false;
		}
		if(livro.getIdgenero() == null) {
			getMensagem().mensagem.add("O genero não deve ser vazio!");
			valido = false;
		}
		if(livro.getAno() == null) {
			getMensagem().mensagem.add("O ano não deve ser vazio!");
			valido = false;
		}
		if(livro.getValor() == null) {
			getMensagem().mensagem.add("O valor não deve ser vazio!");
			valido = false;
		}
		return valido;
	}

}
