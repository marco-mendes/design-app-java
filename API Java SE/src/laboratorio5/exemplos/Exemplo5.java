package laboratorio5.exemplos;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Exemplo5 {

    public static void main(String[] args) {
        Stack<Integer> stackDeInteiros = new Stack();
        stackDeInteiros.push(1);
        System.out.println(stackDeInteiros);

        List<Integer> listaDeInteiros = Arrays.asList(2, 3, 4, 5, 6, 7, 8);
        stackDeInteiros.addAll(listaDeInteiros);
        System.out.println(stackDeInteiros);
    }

}
