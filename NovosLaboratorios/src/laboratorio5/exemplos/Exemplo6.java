package laboratorio5.exemplos;

import java.util.Arrays;
import java.util.Stack;

public class Exemplo6 {

    public static void main(String[] args) {
        Stack<Integer> stackDeInteiros = new Stack();
        stackDeInteiros.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        System.out.println(stackDeInteiros.peek());
        System.out.println(stackDeInteiros);

        System.out.println(stackDeInteiros.pop());
        System.out.println(stackDeInteiros);
    }

}
