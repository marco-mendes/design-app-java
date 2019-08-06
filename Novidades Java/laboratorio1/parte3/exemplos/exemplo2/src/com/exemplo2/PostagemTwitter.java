package com.exemplo2;

import java.util.ArrayList;
import java.util.List;

public class PostagemTwitter {

    private String conteúdo;
    private List<String> hashTags = new ArrayList<>();

    public PostagemTwitter(String conteúdo) {
        this.conteúdo = conteúdo;
    }

    public PostagemTwitter(String conteúdo, List<String> hashTags) {
        this.conteúdo = conteúdo;
        this.hashTags = hashTags;
    }

    public String getConteúdo() {
        return conteúdo;
    }

    public List<String> getHashTags() {
        return hashTags;
    }

    public void adicionarHashTag(String hashTag) {
        this.hashTags.add(hashTag);
    }

}
