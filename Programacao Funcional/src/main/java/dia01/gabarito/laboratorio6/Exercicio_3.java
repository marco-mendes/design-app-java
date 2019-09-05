package dia01.gabarito.laboratorio6;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Exercicio_3 {

    public static void main(String[] args) {
        List<Integer> listaValores = Arrays.asList(10, 5, 8, 20, 2, 19, 31, 50);
        Optional<Integer> maior = listaValores.stream().max((a, b) -> a.compareTo(b));
        Optional<Integer> menor = listaValores.stream().min((a, b) -> a.compareTo(b));

        System.out.println(String.format("Maior valor: %s", maior.get()));
        System.out.println(String.format("Menor valor: %s", menor.get()));

    }

}
