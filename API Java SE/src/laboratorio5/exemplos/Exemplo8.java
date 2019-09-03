package laboratorio5.exemplos;

import java.util.ArrayDeque;
import java.util.Deque;

public class Exemplo8 {

    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.push("Primeiro item");
        deque.push("Segundo item");

        System.out.println(deque.getFirst());
        System.out.println(deque.pop());
    }

}
