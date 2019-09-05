package dia01.laboratorio6.exemplos;

import java.util.List;
import java.util.stream.Stream;

public class Exemplo_1 {

    public static void main(String[] args) {

        List<Pessoa> pessoas = Pessoa.obtemListaPessoas();
        Stream<Pessoa> streamPessoas = pessoas.stream();

    }

}
