package dia02.laboratorio2.parte1.exercicio;

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
        private String autor;
        private String titulo;
        private String idioma;
        private int anoLancamento;
        private int numeroDePaginas;
        private String paisDeOrirgem;
        private String codigoDeBarras;
        private String isbn;

        public Builder() {

        }

        public Builder autor(String autor) {
            this.autor = autor;
            return this;
        }

        public Builder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder idioma(String idioma) {
            this.idioma = idioma;
            return this;
        }

        public Builder anoLancamento(int anoLancamento) {
            this.anoLancamento = anoLancamento;
            return this;
        }

        public Builder numeroDePaginas(int numeroDePaginas) {
            this.numeroDePaginas = numeroDePaginas;
            return this;
        }

        public Builder paisDeOrirgem(String paisDeOrirgem) {
            this.paisDeOrirgem = paisDeOrirgem;
            return this;
        }

        public Builder codigoDeBarras(String codigoDeBarras) {
            this.codigoDeBarras = codigoDeBarras;
            return this;
        }

        public Builder isbn(String isbn) {
            this.isbn = isbn;
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

