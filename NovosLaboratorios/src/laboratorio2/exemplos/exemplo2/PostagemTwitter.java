package laboratorio2.exemplos.exemplo2;

import java.util.ArrayList;
import java.util.List;

public class PostagemTwitter {

    private String conteudo;
    private List<String> hashTags = new ArrayList<>();

    public PostagemTwitter(String conteudo) {
        this.conteudo = conteudo;
    }

    public PostagemTwitter(String conteudo, List<String> hashTags) {
        this.conteudo = conteudo;
        this.hashTags = hashTags;
    }

    public String getConteudo() {
        return conteudo;
    }

    public List<String> getHashTags() {
        return hashTags;
    }

    public void adicionarHashTag(String hashTag) {
        this.hashTags.add(hashTag);
    }

}
