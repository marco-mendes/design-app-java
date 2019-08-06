package com.exemplo2;

import java.util.List;

public class PostagemAdministrador extends Postagem {

    private String nomeAdministrador;

    public String getNomeAdministrador() {
        return nomeAdministrador;
    }

    public PostagemAdministrador(String titulo, String conteúdo, List<String> palavrasChave, String nomeAdministrador) {
        super(titulo, conteúdo, palavrasChave);
        this.nomeAdministrador = nomeAdministrador;
        this.nomeAdministrador = nomeAdministrador;
    }

    public PostagemAdministrador(String titulo, String conteúdo, String nomeAdministrador) {
        super(titulo, conteúdo);
        this.nomeAdministrador = nomeAdministrador;
        this.nomeAdministrador = nomeAdministrador;
    }

    @Override
    public String toString() {
        return "PostagemAdministrador{" +
                "nomeAdministrador='" + nomeAdministrador + '\'' +
                '}';
    }
}
