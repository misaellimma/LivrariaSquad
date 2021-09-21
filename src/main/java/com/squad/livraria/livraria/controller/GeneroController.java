package com.squad.livraria.livraria.controller;

import com.squad.livraria.livraria.entities.Genero;
import com.squad.livraria.livraria.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Genero incluir(@RequestBody Genero novoGenero)
    {
        return generoRepository.save(novoGenero);
    }

    @PutMapping("alterar")
    public Genero alterar(@RequestBody Genero genero)
    {

    }




}
