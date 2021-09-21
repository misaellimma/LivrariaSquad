package com.squad.livraria.livraria.biz;

import com.squad.livraria.livraria.Mensagem;
import com.squad.livraria.livraria.entities.VendaLivro;
import com.squad.livraria.livraria.repositories.LivroRepository;
import com.squad.livraria.livraria.repositories.VendaRepository;

public class VendaLivroBiz {
	private VendaRepository vendaRepositorio;
	private LivroRepository livroRepositorio;
	private Mensagem mensagens = new Mensagem();
	public VendaLivroBiz(VendaRepository repositorioVenda, LivroRepository repositorioLivro) {
		this.livroRepositorio = repositorioLivro;
		this.vendaRepositorio = repositorioVenda;
	}
	public boolean validarVendaLivro(VendaLivro vendaLivro) {
		boolean valido = true;
		if(vendaLivro.getIdlivro()==null) {
			mensagens.mensagem.add("O Id do livro não pode ser nulo");
			valido=false;
		}else if(livroRepositorio.findById(vendaLivro.getIdlivro()).isEmpty()) {
			mensagens.mensagem.add("Nenhum livro foi encontrado com o id informado");
			valido=false;
		}
		if(vendaLivro.getIdvenda()==null) {
			mensagens.mensagem.add("O Id da venda não pode ser nulo");
			valido=false;
		}else if(vendaRepositorio.findById(vendaLivro.getIdvenda()).isEmpty()) {
			mensagens.mensagem.add("Nenhuma venda foi encontrada com o id informado");
			valido=false;
		}
		return valido;
	}
	
	public VendaRepository getVendaRepositorio() {
		return vendaRepositorio;
	}
	public void setVendaRepositorio(VendaRepository vendaRepositorio) {
		this.vendaRepositorio = vendaRepositorio;
	}
	public LivroRepository getLivroRepositorio() {
		return livroRepositorio;
	}
	public void setLivroRepositorio(LivroRepository livroRepositorio) {
		this.livroRepositorio = livroRepositorio;
	}
	public Mensagem getMensagens() {
		return mensagens;
	}
	public void setMensagens(Mensagem mensagens) {
		this.mensagens = mensagens;
	}
	
	
	
}
