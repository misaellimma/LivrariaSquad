package com.squad.livraria.livraria.controller;

import com.squad.livraria.livraria.Mensagem;
import com.squad.livraria.livraria.biz.GeneroBiz;
import com.squad.livraria.livraria.entities.Genero;
import com.squad.livraria.livraria.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("genero")
public class GeneroController {

    @Autowired
    GeneroRepository generoRepository;

    @GetMapping("listar")
    public List<Genero> listar()
    {
        return generoRepository.findAll();
    }

    @PostMapping("incluir")
    public Mensagem incluir(@RequestBody Genero novoGenero)
    {
        GeneroBiz generoBiz = new GeneroBiz(generoRepository);

        try{

            if(generoBiz.validar(novoGenero)) {
                generoRepository.save(novoGenero);
                generoRepository.flush();
                generoBiz.getMsg().mensagem.add("Genero cadastrado com sucesso!");
            }

        } catch(Exception e) {
            generoBiz.getMsg().mensagem.add("Erro ao incluir: " + e.getMessage());
        }

        return generoBiz.getMsg();
    }

    @PutMapping("alterar")
    public Mensagem alterar(@RequestBody Genero genero)
    {

        GeneroBiz generoBiz = new GeneroBiz(generoRepository);
        Optional<Genero> dadosGenero = generoRepository.findById(genero.getId());

        try {

            if(dadosGenero.isPresent())
            {
                Genero generoAtualizado = dadosGenero.get();
                generoAtualizado.setNome(genero.getNome());
                generoRepository.save(generoAtualizado);
                generoBiz.getMsg().mensagem.add("Genero atualizado com sucesso!");
            } else {
                generoBiz.getMsg().mensagem.add("Gênero inexistente!");
            }

        } catch(Exception e) {

            generoBiz.getMsg().mensagem.add("Erro ao incluir: " + e.getMessage());

        }

        return generoBiz.getMsg();
    }

}
