package com.squad.livraria.livraria.biz;

import com.squad.livraria.livraria.Mensagem;
import com.squad.livraria.livraria.entities.Venda;
import com.squad.livraria.livraria.repositories.ClienteRepository;


public class VendaBiz {
	
	private Mensagem msg;
	private ClienteRepository clienteRepository;
	
	public VendaBiz(ClienteRepository clienteRepository) {
		
		this.clienteRepository = clienteRepository;
		this.msg = new Mensagem();
	}
	
	public Boolean validarVenda (Venda novoVenda) {
		Boolean valido = true;
		
	
		if (novoVenda.getValor() < 0) {
			msg.mensagem.add(("O Valor deve ser acima de zero"));
			valido = false;
		}
		
		if (clienteRepository.findById(novoVenda.getId_cliete()).isEmpty()) {
			msg.mensagem.add(("O cliente da venda não existe"));
			valido = false;
		}
		
		if(novoVenda.getData().isEmpty()) {
			msg.mensagem.add(("A campo da data não pode estar vazia"));
			valido = false;
				
		}
		
		return valido;
	}

	public Mensagem getMsg() {
		return msg;
	}

	public void setMsg(Mensagem msg) {
		this.msg = msg;
	}
}
	

