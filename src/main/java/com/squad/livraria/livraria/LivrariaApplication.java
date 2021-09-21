package com.squad.livraria.livraria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivrariaApplication {

	public static void main(String[] args) {
		System.out.println("Iniciando processo...");
		SpringApplication.run(LivrariaApplication.class, args);
		System.out.println("Inicialização feita com sucesso. Acesso permitido");
	}
}
