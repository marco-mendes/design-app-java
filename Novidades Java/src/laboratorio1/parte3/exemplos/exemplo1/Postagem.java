package laboratorio1.parte3.exemplos.exemplo1;

import java.util.ArrayList;
import java.util.List;

public class Postagem {

    private String titulo;
    private String conteúdo;
    private List<String> palavrasChave = new ArrayList<>();

    public Postagem(String titulo, String conteúdo, List<String> palavrasChave) {
        this.titulo = titulo;
        this.conteúdo = conteúdo;
        this.palavrasChave = palavrasChave;
    }

    public Postagem(String titulo, String conteúdo) {
        this.titulo = titulo;
        this.conteúdo = conteúdo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteúdo() {
        return conteúdo;
    }

    public List<String> getPalavrasChave() {
        return palavrasChave;
    }

    public void adicionarPalavraChave(String novaPalavraChave) {
        palavrasChave.add(novaPalavraChave);
    }

}
