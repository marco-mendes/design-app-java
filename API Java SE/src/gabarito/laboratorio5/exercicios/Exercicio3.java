package gabarito.laboratorio5.exercicios;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Exercicio3 {

    public static void main(String[] args) {
        List<Integer> listaInteiros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Stack<Integer> stack = new Stack<>();
        stack.addAll(listaInteiros);
        stack.removeIf(v -> v % 2 != 0);
        System.out.println(stack.peek());
    }

}
