package dia01.laboratorio6.exemplos;

import java.util.List;
import java.util.Optional;

public class Exemplo_4 {

    public static void main(String[] args) {
        List<Pessoa> listaPessoas = Pessoa.obtemListaPessoas();
        Optional<Pessoa> optionalPessoaMaisVelha =  listaPessoas.stream()
                .max((pessoa1, pessoa2) -> pessoa1.getIdade().compareTo(pessoa2.getIdade()));

        Optional<Pessoa> optionalPessoaMaisNova =  listaPessoas.stream()
                .min((pessoa1, pessoa2) -> pessoa1.getIdade().compareTo(pessoa2.getIdade()));

        System.out.println(String.format("Pessoa mais velha: %s", optionalPessoaMaisVelha.get()));
        System.out.println(String.format("Pessoa mais nova: %s", optionalPessoaMaisNova.get()));

    }

}
