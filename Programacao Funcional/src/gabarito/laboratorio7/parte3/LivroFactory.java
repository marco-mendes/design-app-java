package gabarito.laboratorio7.parte3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LivroFactory {

    private static final Map<GeneroLivro, Supplier<Livro>> map = new HashMap<>();
    static {
        map.put(GeneroLivro.ACAO, LivroDeAcao::new);
        map.put(GeneroLivro.AVENTURA, LivroDeAventura::new);
        map.put(GeneroLivro.FICCAO, LivroDeFiccao::new);
    }

    public static Livro getLivro(GeneroLivro generoLivro){
        Supplier<Livro> livro = map.get(generoLivro);
        if(livro != null){
            return  livro.get();
        } else {
            throw new IllegalArgumentException(String.format("Gênero %s não cadastrado!", generoLivro));
        }
    }

}
