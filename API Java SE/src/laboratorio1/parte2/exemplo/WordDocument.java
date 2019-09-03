package laboratorio1.parte2.exemplo;

public class WordDocument {

    private String criador;
    private String titulo;
    private String conteudo;

    public WordDocument(String criador, String titulo, String conteudo) {
        super();
        this.criador = criador;
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public String getCriador() {
        return criador;
    }

    public void setCriador(String criador) {
        this.criador = criador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public WordDocumentMemento createMemento() {
        WordDocumentMemento memento = new WordDocumentMemento(criador, titulo, conteudo);
        return memento;
    }

    public void restoreMemento(WordDocumentMemento memento) {
        this.criador = memento.getCriador();
        this.titulo = memento.getTitulo();
        this.conteudo = memento.getConteudo();
    }

    @Override
    public String toString() {
        return "WordDocument{" +
                "criador='" + criador + '\'' +
                ", titulo='" + titulo + '\'' +
                ", conteudo='" + conteudo + '\'' +
                '}';
    }
}
