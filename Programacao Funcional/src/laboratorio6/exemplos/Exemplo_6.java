package laboratorio6.exemplos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exemplo_6 {

    public static void main(String[] args) {
        List<Pessoa> pessoas = Pessoa.obtemListaPessoas();
        Stream<Pessoa> streamPessoas = pessoas.stream();
        Stream<String> streamNomesPessoas = streamPessoas.map(p -> p.getNome());
        List<String> listaNomesPessoas = streamNomesPessoas.collect(Collectors.toList());
        listaNomesPessoas.forEach(nome -> System.out.println(nome));
    }

}
