package gabarito.prototipodescartado.laboratorio1;

import java.util.Arrays;
import java.util.List;

public class LambdasExercicio {
    public static void main(String[] args) {

        List<String> listaNomes = Arrays.asList("Joao", "Maria", "Dalva", "Vilma", "Carlos", "Roberto");
        // Resolvido
        listaNomes.forEach(p -> System.out.println(p));

    }
}