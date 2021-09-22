package com.squad.livraria.livraria.biz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.squad.livraria.livraria.Mensagem;
import com.squad.livraria.livraria.entities.Cliente;
import com.squad.livraria.livraria.repositories.ClienteRepository;

public class ClienteBiz {
	
	private Mensagem mensagens;
	private ClienteRepository clienteRepository;
	
	public ClienteBiz() {}
	
	public ClienteBiz(ClienteRepository clienteRepository) {
		super();
		this.mensagens = new Mensagem();
		this.clienteRepository = clienteRepository;
	}
		
	public Mensagem getMensagens() {
		return mensagens;
	}

	public void setMensagens(Mensagem mensagens) {
		this.mensagens = mensagens;
	}

	public ClienteRepository getClienteRepository() {
		return clienteRepository;
	}

	public void setClienteRepository(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Boolean validar(Cliente cliente) {
		
		Boolean valido = true;
		
		if(cliente.getNome().isEmpty()) {
			mensagens.mensagem.add("O nome do cliente não pode estar vazio");
			valido = false;
		}else if(cliente.getNome().length() > 50) {
			mensagens.mensagem.add("O nome é muito grande, ele deve ter até 50 caracteres");
			valido = false;
		}
		
		if (cliente.getEmail() != null && cliente.getEmail().length() > 0) {
	        String validacao = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	        Pattern pattern = Pattern.compile(validacao, Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(cliente.getEmail());
	        if (matcher.matches()) {
	            valido = true;
	        }else if(cliente.getEmail().isEmpty()) {
	        	mensagens.mensagem.add("O nome do cliente não pode estar vazio");
	        	valido = false;
	        }else {
	        	valido = false;
	        	mensagens.mensagem.add("O formato de email informado não é válido");
	        }
	    }
		
		if(cliente.getTelefone().isEmpty()) {
			mensagens.mensagem.add("O número de celular não pode estar vazio");
			valido = false;
		}else if(cliente.getTelefone().length() > 20) {
			mensagens.mensagem.add("O nome é muito grande, ele deve ter até 20 caracteres");
			valido = false;
		}

		return valido;
	}
}

