package laboratorio2.exercicio.exercicio2;

import java.util.Arrays;
import java.util.List;

public class Artigo {

    private int id;
    private String titulo;
    private String categoria;
    private String conteudo;

    public Artigo(int id, String titulo, String categoria, String conteudo) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.conteudo = conteudo;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getConteudo() {
        return conteudo;
    }

    public static List<Artigo> obtemArtigos() {
        return Arrays.asList(
                new Artigo(1, "Artigo 1", "Cientifico", "Conteúdo Artigo 1"),
                new Artigo(2, "Artigo 2", "Cientifico", "Conteúdo Artigo 2"),
                new Artigo(3, "Artigo 3", "Cientifico", "Conteúdo Artigo 3"),
                new Artigo(4, "Artigo 4", "Cientifico", "Conteúdo Artigo 4"),
                new Artigo(5, "Artigo 5", "Cientifico", "Conteúdo Artigo 5")
        );
    }

}
