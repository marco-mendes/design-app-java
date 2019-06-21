package laboratorio4.exemplos;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class IFConsumer {

    public static void main(String[] args) {

        Consumer<Integer> display = n -> System.out.println("Imprimindo número: " + n);
        display.accept(5);

        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        integerList.forEach(n -> System.out.println(n));

    }

    public static void talvezUse(){
        List<Integer> minhaLista = Arrays.asList(1,2,3,4,5);

        Consumer<List<Integer>> consumerTriplicaValoresDaLista = lista -> {
            for (int i = 0; i < lista.size(); i++) {
                lista.set(i, 3 * lista.get(i));
            }
        };
        System.out.println("Lista antes do consumer: ");
        System.out.println(minhaLista);
        consumerTriplicaValoresDaLista.accept(minhaLista);
        System.out.println("Lista após o consumer: ");
        System.out.println(minhaLista);
    }

}
