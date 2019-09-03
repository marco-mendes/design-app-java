package laboratorio5.exemplos;

import java.util.Arrays;
import java.util.LinkedList;

public class Exemplo3 {

    public static void main(String[] args) {
        LinkedList<String> lista = new LinkedList<>();
        lista.addAll(Arrays.asList("Valor 1", "Valor 2", "Valor 3", "Valor 4"));
        System.out.println(lista.poll());
        System.out.println(lista.pop());
        System.out.println(lista);
    }

}
