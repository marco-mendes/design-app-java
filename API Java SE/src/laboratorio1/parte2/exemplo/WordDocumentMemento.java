package laboratorio1.parte2.exemplo;

public final class WordDocumentMemento {

    private final String criador;
    private final String titulo;
    private final String conteudo;

    public WordDocumentMemento(String criador, String titulo, String conteudo) {
        super();
        this.criador = criador;
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public String getCriador() {
        return criador;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

}
