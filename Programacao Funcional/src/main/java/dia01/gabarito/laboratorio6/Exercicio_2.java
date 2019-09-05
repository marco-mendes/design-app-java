package dia01.gabarito.laboratorio6;

import java.util.Arrays;
import java.util.List;

public class Exercicio_2 {

    public static void main(String[] args) {
        List<String> listaNomes = Arrays.asList("João", "Maria", "Carla", "Roberta", "Jhon", "Sabrina");
        Long elementos = listaNomes.stream().count();
        System.out.println(
                String.format("A lista possui %s elementos!", elementos)
        );
    }

}
