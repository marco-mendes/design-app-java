package gabarito.laboratorio2.parte1;

public class PatternBuilderMain {

    public static void main(String[] args) {
        Livro livro = new Livro.Builder()
                .set(L -> {
                    L.autor = "Richard Warburton";
                    L.titulo = "Java 8 Lambdas";
                    L.idioma = "Inglês";
                    L.anoLancamento = 2014;
                    L.numeroDePaginas = 167;
                    L.paisDeOrirgem = "Estados Unidos";
                    L.codigoDeBarras = "1449370772";
                    L.isbn = "978-1449370770";
                }).build();
        System.out.println(livro);
    }

}
