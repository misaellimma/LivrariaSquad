package com.squad.livraria.livraria.controller;

import java.util.List;

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
import com.squad.livraria.livraria.biz.ClienteBiz;
import com.squad.livraria.livraria.entities.Cliente;
import com.squad.livraria.livraria.repositories.ClienteRepository;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("listar")
	public List<Cliente> listarCliente(){
		return clienteRepository.findAll();
	}
	
	@PostMapping("incluir")
	public Mensagem incluirCliente(@RequestBody @Validated Cliente cliente) {
		
		ClienteBiz clienteBiz = new ClienteBiz(clienteRepository);
		
		try{
			if(clienteBiz.validar(cliente)) {
				clienteRepository.save(cliente);
				clienteRepository.flush();
				clienteBiz.getMensagens().mensagem.add("Cliente criado com sucesso");
			}
			
		}catch(Exception e) {
			clienteBiz.getMensagens().mensagem.add("Erro ao Incluir: " + e.getMessage());
		}
		return clienteBiz.getMensagens();
	}
	
    @PutMapping(path="alterar/{id}")
    public Mensagem alterarCliente(@PathVariable Integer id, @RequestBody @Validated Cliente cliente) {
        
    	ClienteBiz clienteBiz = new ClienteBiz(clienteRepository);
    	
        try{
            if(clienteBiz.validar(cliente)) {
            	clienteRepository.save(cliente);
                clienteRepository.flush();
                clienteBiz.getMensagens().mensagem.add("Cliente alterado com sucesso");
            }else {
            	clienteBiz.getMensagens().mensagem.add("Erro ao alterar");
            }
        	
        }catch(Exception e) {
            clienteBiz.getMensagens().mensagem.add("Erro ao alterar: " + e.getMessage());
        }
        return clienteBiz.getMensagens();
    }
}
