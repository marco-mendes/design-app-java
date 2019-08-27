package laboratorio2.parte1.exercicio;

public class PatternBuilderMain {

    public static void main(String[] args) {
        Livro livro = new Livro.Builder()
                .autor("Richard Warburton")
                .titulo("Java 8 Lambdas")
                .idioma("Inglês")
                .anoLancamento(2014)
                .numeroDePaginas(167)
                .paisDeOrirgem("Estados Unidos")
                .codigoDeBarras("1449370772")
                .isbn("978-1449370770")
                .build();
        System.out.println(livro);
    }

}
