package dia01.gabarito.laboratorio3.parte1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Exercicio_2 {

    public static void main(String[] args) {

        Function<List<Integer>, Integer> calcularMedia = (lista) -> {
            int soma = 0;
            for(int valor : lista){
                soma += valor;
            }
            int media = soma / lista.size();
            System.out.println(String.format("Media: %d", media));
            return media;
        };
        Function<List<Integer>, Boolean> verificarAlunoAprovado = calcularMedia.andThen(m -> (m > 6) ? true : false);

        List<Integer> notas = Arrays.asList(10, 5, 8, 1, 9);
        System.out.println(String.format("Aluno aprovado? %b", verificarAlunoAprovado.apply(notas)));

    }

}
