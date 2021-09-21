package com.squad.livraria.livraria.biz;

import com.squad.livraria.livraria.Mensagem;
import com.squad.livraria.livraria.entities.Genero;
import com.squad.livraria.livraria.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GeneroBiz {

    private GeneroRepository generoRepository;

    private Mensagem msg;

    public GeneroBiz(GeneroRepository generoRepository) {
        super();
        this.msg = new Mensagem();
        this.generoRepository = generoRepository;
    }

    public Boolean validar(Genero genero)
    {
        Boolean valid = true;

        if(genero.getNome() == null || genero.getNome().isEmpty())
        {
            msg.mensagem.add("O nome não pode ser vazio");
            valid = false;
        } else if(genero.getNome().length() > 50) {
            msg.mensagem.add("O nome não pode conter mais que 50 caracteres");
            valid = false;
        }

        return valid;
    }

    public Mensagem getMsg() {
        return msg;
    }

    public void setMsg(Mensagem msg) {
        this.msg = msg;
    }

    public GeneroRepository getGeneroRepository() {
        return generoRepository;
    }

    public void setGeneroRepository(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }
}
