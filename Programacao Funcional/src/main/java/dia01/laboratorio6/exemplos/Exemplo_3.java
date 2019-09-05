package dia01.laboratorio6.exemplos;

import java.util.Arrays;
import java.util.List;

public class Exemplo_3 {

    public static void main(String[] args) {
        List<Pessoa> pessoas = Arrays.asList(
            new Pessoa("João", Sexo.MASCULINO, 30),
            new Pessoa("Maria", Sexo.FEMININO, 31)
        );

        Long totalPessoas = pessoas.stream().count();
        System.out.println(
                String.format("A lista possui %s elementos!",totalPessoas)
        );
    }

}
