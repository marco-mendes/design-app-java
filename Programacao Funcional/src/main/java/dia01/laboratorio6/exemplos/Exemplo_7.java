package dia01.laboratorio6.exemplos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exemplo_7 {

    public static void main(String[] args) {

        List<Pessoa> listaPessoasSexoMasculino = Pessoa.obtemListaPessoas()
                .stream()
                .filter(p -> p.getSexo().equals(Sexo.MASCULINO))
                .collect(Collectors.toList());

        List<Pessoa> listaPessoasSexoFeminino = Pessoa.obtemListaPessoas()
                .stream()
                .filter(p -> p.getSexo().equals(Sexo.FEMININO))
                .collect(Collectors.toList());

        List<List<Pessoa>> listaTiposPessoas = Arrays.asList(listaPessoasSexoMasculino, listaPessoasSexoFeminino);
        List<Pessoa> listaTodasAsPessoas = listaTiposPessoas.stream().flatMap(tipo -> tipo.stream()).collect(Collectors.toList());
        listaTodasAsPessoas.forEach(p -> System.out.println(p));

    }

}
