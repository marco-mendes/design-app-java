package laboratorio5.exemplos;

import java.util.Arrays;
import java.util.Stack;

public class Exemplo7 {

    public static void main(String[] args) {
        Stack<String> stack1 = new Stack<>();
        stack1.push("Elemento 1");
        stack1.push("Elemento 2");
        stack1.push("Elemento 3");

        stack1.removeElement("Elemento 2");
        System.out.println(stack1);

        Stack<String> stack2 = new Stack<>();
        stack2.push("Elemento 1");
        stack2.push("Elemento 2");
        stack2.push("Elemento 3");

        stack2.removeElementAt(0);
        System.out.println(stack2);

        Stack<Integer> stack3 = new Stack<>();
        stack3.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        stack3.removeIf(element -> element > 5);
        System.out.println(stack3);
    }

}
