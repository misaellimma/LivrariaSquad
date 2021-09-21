package com.squad.livraria.livraria.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squad.livraria.livraria.Mensagem;
import com.squad.livraria.livraria.biz.VendaLivroBiz;
import com.squad.livraria.livraria.entities.VendaLivro;
import com.squad.livraria.livraria.repositories.LivroRepository;
import com.squad.livraria.livraria.repositories.VendaLivroRepository;
import com.squad.livraria.livraria.repositories.VendaRepository;

@RestController
@RequestMapping("vendalivro")
public class VendaLivroController {
	@Autowired
	private VendaLivroRepository vendaLivroRepositorio;
	@Autowired
	private VendaRepository vendaRepositorio;
	@Autowired
	private LivroRepository livroRepositorio;

	@GetMapping("listar")
	public List<VendaLivro> listar() {
		return vendaLivroRepositorio.findAll();
	}

	@PostMapping("incluir")
	public List<String> incluir(@Valid @RequestBody VendaLivro novaVendaLivro) {
		Mensagem mensagem = new Mensagem();
		VendaLivroBiz validador = new VendaLivroBiz(vendaRepositorio, livroRepositorio);
		if (validador.validarVendaLivro(novaVendaLivro)) {
			try {
				vendaLivroRepositorio.save(novaVendaLivro);
				vendaLivroRepositorio.flush();
				mensagem.mensagem.add("Sucesso ao incluir nova Venda-Livro");
			} catch (Exception err) {
				mensagem.mensagem.add("Erro ao inserir Venda-Livro:");
				mensagem.mensagem.add(err.getMessage());
			}
			return (mensagem.getMensagem());
		}else
			return validador.getMensagens().getMensagem();
	}

	@PutMapping("alterar")
	public List<String> alterar(@Valid @RequestBody VendaLivro novaVendaLivro) {
		Mensagem mensagem = new Mensagem();
		VendaLivroBiz validador = new VendaLivroBiz(vendaRepositorio, livroRepositorio);
		if (validador.validarVendaLivro(novaVendaLivro)) {
			try {
				Optional<VendaLivro> oldVendaLivro = vendaLivroRepositorio.findById(novaVendaLivro.getId());
				if(oldVendaLivro.isPresent()) {
					VendaLivro finalVendaLivro = oldVendaLivro.get();
					finalVendaLivro.setIdlivro(novaVendaLivro.getIdlivro());
					finalVendaLivro.setIdvenda(novaVendaLivro.getIdvenda());
					vendaLivroRepositorio.save(finalVendaLivro);
					mensagem.mensagem.add("Sucesso ao atualizar venda-livro");
				}else {
					mensagem.mensagem.add("A Venda-Livro informada não foi encontrada");
					return mensagem.getMensagem();
				}
			} catch (Exception err) {
				mensagem.mensagem.add("Erro ao inserir Venda-Livro:");
				mensagem.mensagem.add(err.getMessage());
			}
			return (mensagem.getMensagem());
		}else
			return validador.getMensagens().getMensagem();
		
	}
}
