package laboratorio2.exercicio.exercicio2;

public class ArtigoCientifico {

    private int id;
    private String titulo;
    private String conteudo;

    public ArtigoCientifico(int id, String titulo, String conteudo) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

}
