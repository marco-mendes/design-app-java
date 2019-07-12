package laboratorio6.exemplos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exemplo_2 {

    public static void main(String[] args) {
        List<Pessoa> pessoas = Pessoa.obtemListaPessoas();
        Stream<Pessoa> pessoasStream = pessoas.stream();
        List<Pessoa> streamRevertidoParaLista = pessoasStream.collect(Collectors.toList());
        streamRevertidoParaLista.forEach(p -> System.out.println(p));
    }

}
