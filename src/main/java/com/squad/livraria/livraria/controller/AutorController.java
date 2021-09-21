package com.squad.livraria.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squad.livraria.livraria.entities.Autor;
import com.squad.livraria.livraria.repositories.AutorRepository;

@RestController
@RequestMapping("autor")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@GetMapping("listar")
	public List<Autor> listarAutor(){
		List<Autor> lista = autorRepository.findAll();
		return lista;
	}
	
	  @PostMapping("incluir")
	    public String incluirCliente(@RequestBody Autor autor) {
	        
	        try{
	            autorRepository.save(autor);
	            autorRepository.flush();
	            return autor.toString();
	        }catch(Exception e) {
	            return e.getMessage();
	        }
	        
	    }
	  
	  @PutMapping("alterar/{id}")
	    public String alterarCliente(@PathVariable Integer id, @RequestBody Autor autor) {
	        
	        try{
	            autorRepository.save(autor);
	            autorRepository.flush();
	            return autor.toString();
	        }catch(Exception e) {
	            return e.getMessage();
	        }
	    }
	
	

}
