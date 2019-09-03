package laboratorio5.exemplos;

import java.util.Arrays;
import java.util.LinkedList;

public class Exemplo2 {

    public static void main(String[] args) {

        LinkedList<Integer> lista = new LinkedList<>();
        lista.addAll(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        lista.remove(1);
        lista.removeFirst();
        lista.removeLast();

    }

}
