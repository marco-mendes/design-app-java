package gabarito.laboratorio2.parte1;

import java.util.function.Consumer;

public class Livro {

    private String autor;
    private String titulo;
    private String idioma;
    private int anoLancamento;
    private int numeroDePaginas;
    private String paisDeOrirgem;
    private String codigoDeBarras;
    private String isbn;

    private Livro() {

    }

    public static class Builder {
        public String autor;
        public String titulo;
        public String idioma;
        public int anoLancamento;
        public int numeroDePaginas;
        public String paisDeOrirgem;
        public String codigoDeBarras;
        public String isbn;

        public Builder() {}

        public Builder set(Consumer<Builder> builderConsumer) {
            builderConsumer.accept(this);
            return this;
        }

        public Livro build() {
            Livro livro = new Livro();
            livro.autor = this.autor;
            livro.titulo = this.titulo;
            livro.idioma = this.idioma;
            livro.anoLancamento = this.anoLancamento;
            livro.numeroDePaginas = this.numeroDePaginas;
            livro.paisDeOrirgem = this.paisDeOrirgem;
            livro.codigoDeBarras = this.codigoDeBarras;
            livro.isbn = this.isbn;
            return livro;
        }
    }

    // Getters e Setters


    @Override
    public String toString() {
        return "Livro{" +
                "autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", idioma='" + idioma + '\'' +
                ", anoLancamento=" + anoLancamento +
                ", numeroDePaginas=" + numeroDePaginas +
                ", paisDeOrirgem='" + paisDeOrirgem + '\'' +
                ", codigoDeBarras='" + codigoDeBarras + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}

