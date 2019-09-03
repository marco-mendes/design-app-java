package laboratorio2.exemplos.exemplo1;

import java.util.ArrayList;
import java.util.List;

public class Postagem {

    private String titulo;
    private String conteudo;
    private List<String> palavrasChave = new ArrayList<>();

    public Postagem(String titulo, String conteudo, List<String> palavrasChave) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.palavrasChave = palavrasChave;
    }

    public Postagem(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public List<String> getPalavrasChave() {
        return palavrasChave;
    }

    public void adicionarPalavraChave(String novaPalavraChave) {
        palavrasChave.add(novaPalavraChave);
    }

}
