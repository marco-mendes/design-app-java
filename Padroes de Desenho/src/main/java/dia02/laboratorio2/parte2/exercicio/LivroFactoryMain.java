package dia02.laboratorio2.parte2.exercicio;

public class LivroFactoryMain {

    public static void main(String[] args) {
        LivroFactory livroFactory = new LivroFactory();

        Livro livroDeAcao = livroFactory.getLivro(GeneroLivro.ACAO);
        livroDeAcao.describe();

        Livro livroDeAventura = livroFactory.getLivro(GeneroLivro.AVENTURA);
        livroDeAventura.describe();

        Livro livroDeFiccao = livroFactory.getLivro(GeneroLivro.FICCAO);
        livroDeFiccao.describe();
    }

}
