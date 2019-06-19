package laboratorio1.exercicio;


import java.util.Arrays;
import java.util.List;

public class LambdasExercicio {
    public static void main(String[] args) {

        List<String> listaNomes = Arrays.asList("Joao", "Maria", "Dalva", "Vilma", "Carlos", "Roberto");
        // A resolver
        // listaNomes.forEach(parametro -> expressão);
        // Resolvido
         listaNomes.forEach(p -> System.out.println(p));

    }
}