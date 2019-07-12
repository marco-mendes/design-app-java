package laboratorio6.exercicio;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Com base no código abaixo transforme a lista em uma Stream e atribua a mesma para a variável listaConvertidaEmStream,
 e logo em seguida reverta a Stream criada para uma lista novamente atribuindo a mesma para a variável streamConvertidaEmLista.
* */

public class Exercicio_1 {

    public static void main(String[] args) {
        List<String> listaNomes = Arrays.asList("João", "Maria", "Carla", "Roberta", "Jhon", "Sabrina");
        Stream<String> listaConvertidaEmStream = listaNomes.stream();

        List<String> streamConvertidaEmLista = listaConvertidaEmStream.collect(Collectors.toList());
        streamConvertidaEmLista.forEach(nome -> System.out.println(nome));
    }

}
