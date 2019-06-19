package laboratorio4.exemplos;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class IFConsumer {

    public static void main(String[] args) {

        List<Integer> minhaLista = Arrays.asList(1,2,3,4,5);

        Consumer<List<Integer>> consumerTriplicaValoresDaLista = lista -> {
            for (int i = 0; i < lista.size(); i++) {
                lista.set(i, 3 * lista.get(i));
            }
        };
        consumerTriplicaValoresDaLista.accept(minhaLista);
        System.out.println(minhaLista);
    }

}
