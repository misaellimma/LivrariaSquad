package com.squad.livraria.livraria.biz;

import com.squad.livraria.livraria.entities.Genero;
import com.squad.livraria.livraria.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GeneroBiz {

    @Autowired
    private GeneroRepository generoRepository;

    public GeneroBiz(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public Boolean validar(Genero genero)
    {
        Boolean valid = true;

        if(genero.getNome() == null || genero.getNome().isEmpty())
        {
            valid = false;
        } else if(genero.getNome().length() > 50) {

            valid = false;
        }

        return valid;
    }
}
