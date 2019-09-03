package laboratorio5.exemplos;

import java.util.Arrays;
import java.util.LinkedList;

public class Exemplo1 {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Add interface List");

        linkedList.addAll(Arrays.asList("valor 1", "valor 2", "valor 3"));

        linkedList.addFirst("Primeiro da lista");
        linkedList.addLast("Ultimo da lista");

        linkedList.forEach(v -> System.out.println(v));

    }

}
