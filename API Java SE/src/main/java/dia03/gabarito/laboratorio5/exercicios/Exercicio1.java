package dia03.gabarito.laboratorio5.exercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Exercicio1 {

    public static void main(String[] args) {
        List<String> valores = new ArrayList<>();
        valores.addAll(Arrays.asList("Primeiro valor", "Segundo valor", "Terceiro valor", "Quarto valor", "Ultimo valor"));

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addAll(valores);
        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.addFirst("Novo primeiro elemento");
        linkedList.addLast("Novo ultimo elemento");
        System.out.println(linkedList);
    }

}