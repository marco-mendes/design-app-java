package laboratorio6.exemplos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exemplo_5 {

    public static void main(String[] args) {
        List<Pessoa> listaPessoas = Pessoa.obtemListaPessoas();
        Stream<Pessoa> streamPessoasSexoFeminino = listaPessoas.stream().filter(p -> p.getSexo().equals(Sexo.FEMININO));

        List<Pessoa> listaPessoasSexoFeminino = streamPessoasSexoFeminino.collect(Collectors.toList());
        listaPessoasSexoFeminino.forEach(p -> System.out.println(p));
    }

}
