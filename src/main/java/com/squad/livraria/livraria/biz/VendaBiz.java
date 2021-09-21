package com.squad.livraria.livraria.biz;

import com.squad.livraria.livraria.entities.Cliente;
import com.squad.livraria.livraria.repositories.ClienteRepository;
import com.test6.mark6.Mensagem;

public class VendaBiz {
	
	private Mensagem msg;
	private ClienteRepository clienteRepository;
	
	public VendaBiz(ClienteRepository clienteRepository) {
		
		this.clienteRepository = clienteRepository;
		this.msg = new Mensagem();
	}
	
	public Boolean validar (Cliente novoCliente) {
		
		
	}
	
}
