package dia03.laboratorio5.exemplos;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Exemplo9 {

    public static ArrayList<String> obterLista() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Primeiro");
        lista.add("Segundo");
        lista.add("Terceiro");
        lista.add("Quarto");
        lista.add("Quinto");
        return lista;
    }

    public static void usandoComoStack() {
        Deque<String> deque = new ArrayDeque<>();
        deque.addAll(obterLista());
        deque.offerFirst("Elemento entrou no lugar do primeiro elemento");
        deque.offerLast("Elemento entrou no lugar do ultimo elemento");
        //Removento primeiro elemento
        deque.pollFirst();
        //Removendo ultimo elemento
        deque.pollLast();
        System.out.println(String.format("Primeiro elemento: %s", deque.peekFirst()));
        System.out.println(String.format("Ultimo elemento: %s", deque.peekLast()));
    }

    public static void usandoComoQueue() {
        Deque<String> deque = new ArrayDeque<>();
        deque.addAll(obterLista());
        deque.addFirst("Elemento entrou no lugar do primeiro");
        deque.addLast("Elemento entrou no lugar do ultimo elemento");
        //Removento primeiro elemento
        deque.removeFirst();
        //Removendo ultimo elemento
        deque.removeLast();
        System.out.println(String.format("Primeiro elemento: %s", deque.getFirst()));
        System.out.println(String.format("Ultimo elemento: %s", deque.getLast()));
    }

    public static void main(String[] args) {
        usandoComoStack();
        usandoComoQueue();
    }

}
