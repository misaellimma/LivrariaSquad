package com.squad.livraria.livraria;

import java.util.ArrayList;
import java.util.List;

public class Mensagem {

    public List<String> mensagem;

    public Mensagem() {
        this.mensagem = new ArrayList<>();
    }

    public List<String> getMensagem() {
        return mensagem;
    }

    public void setMensagem(List<String> mensagem) {
        this.mensagem = mensagem;
    }

}
