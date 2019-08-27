package laboratorio7.parte3.exercicio;

public class LivroFactory {

    public Livro getLivro(GeneroLivro generoLivro){
        switch (generoLivro) {
            case ACAO: return new LivroDeAcao();
            case AVENTURA: return new LivroDeAventura();
            case FICCAO: return new LivroDeFiccao();
            default: return null;
        }
    }

}
