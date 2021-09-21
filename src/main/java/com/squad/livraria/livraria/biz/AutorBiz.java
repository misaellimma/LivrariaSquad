package com.squad.livraria.livraria.biz;

import com.squad.livraria.livraria.Mensagem;
import com.squad.livraria.livraria.entities.Autor;
import com.squad.livraria.livraria.repositories.AutorRepository;

public class AutorBiz {
	
	private AutorRepository autorReposytory;
	
	private Mensagem msg;
	
	public AutorBiz(AutorRepository autorRepository) {
		this.msg = new Mensagem();
		this.autorReposytory = autorRepository;
	}
	
	public Boolean validar(Autor autor) {
		Boolean valido = true;
		
		if(autor.getNome().length() > 50 ) {
			msg.mensagem.add("Nao pode conter mais que 50 letras");
			valido = false;
		} else if(autor.getNome() == null || autor.getNome().isEmpty()) {
		msg.mensagem.add("O nome nao pode estar vazio");
			valido = false;
		}
		
		if(autor.getEmail().length() > 50) {
			msg.mensagem.add("Nao pode conter mais que 50 caracteres");
			valido = false;
		} else if (autor.getEmail() == null || autor.getEmail().isEmpty()) {
			msg.mensagem.add("O nome nao pode estar vazio");
			valido = false;
		}
		
		if(autor.getAlcunha().length() > 50) {
			msg.mensagem.add("Nao pode conter mais que 50 caracteres");
			valido = false;
		} else if (autor.getAlcunha() == null || autor.getAlcunha().isEmpty()){
			msg.mensagem.add("O nome nao pode estar vazio");
			valido = false;
		}
		
		return valido;
	
	}

	public AutorRepository getAutorReposytory() {
		return autorReposytory;
	}

	public void setAutorReposytory(AutorRepository autorReposytory) {
		this.autorReposytory = autorReposytory;
	}

	public Mensagem getMsg() {
		return msg;
	}

	public void setMsg(Mensagem msg) {
		this.msg = msg;
	}
	
	

}
