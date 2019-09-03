package lab5;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;


public class Exercicio4 {

    public static void main(String[] args) {
        List<String> lista = Arrays.asList("Posição 1", "Posição 2", "Posição 3", "Posição 4");
        Deque<String> deque = new ArrayDeque<>();
        deque.addAll(lista);
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        deque.addFirst("Novo elemento posição 1");
        deque.addLast("Novo elemento ultima posição");
    }

}