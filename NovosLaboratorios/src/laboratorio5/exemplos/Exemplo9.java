package laboratorio5.exemplos;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Exemplo9 {

    public static void usandoComoStack() {
        Deque<String> deque = new ArrayDeque<>();
        deque.addAll(Arrays.asList("Primeiro, Segundo, Terceiro, Quarto, Ultimo"));
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
        deque.addAll(Arrays.asList("Primeiro, Segundo, Terceiro, Quarto, Ultimo"));
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
