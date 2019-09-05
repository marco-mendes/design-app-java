package dia03.gabarito.laboratorio5.exercicios;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Exercicio4 {

    public static ArrayList<String> obterLista() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Posição 1");
        lista.add("Posição 2");
        lista.add("Posição 3");
        lista.add("Posição 4");
        return lista;
    }

    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.addAll(obterLista());
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        deque.addFirst("Novo elemento posição 1");
        deque.addLast("Novo elemento ultima posição");
    }

}