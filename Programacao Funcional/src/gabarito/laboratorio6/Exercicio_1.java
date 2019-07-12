package gabarito.laboratorio6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercicio_1 {

    public static void main(String[] args) {
        List<String> listaNomes = Arrays.asList("João", "Maria", "Carla", "Roberta", "Jhon", "Sabrina");
        Stream<String> listaConvertidaEmStream = listaNomes.stream();

        List<String> streamConvertidaEmLista = listaConvertidaEmStream.collect(Collectors.toList());
        streamConvertidaEmLista.forEach(nome -> System.out.println(nome));
    }

}
