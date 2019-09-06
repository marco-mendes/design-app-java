package dia02.gabarito.laboratorio2.parte2;

public class LivroFactoryMain {

    public static void main(String[] args) {
        Livro livroDeAcao = LivroFactory.getLivro(GeneroLivro.ACAO);
        livroDeAcao.describe();

        Livro livroDeAventura = LivroFactory.getLivro(GeneroLivro.AVENTURA);
        livroDeAventura.describe();

        Livro livroDeFiccao = LivroFactory.getLivro(GeneroLivro.FICCAO);
        livroDeFiccao.describe();
    }

}
