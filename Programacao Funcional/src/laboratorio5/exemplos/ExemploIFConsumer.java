package laboratorio5.exemplos;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExemploIFConsumer {

    public static void main(String[] args) {

        usoBasicoConsumer();
        exemploUsoMetodoAndThen();

    }

    public static void usoBasicoConsumer(){
        Consumer<Integer> display = n -> System.out.println("Imprimindo número: " + n);
        display.accept(5);

        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        integerList.forEach(n -> System.out.println(n));
    }

    public static void exemploUsoMetodoAndThen(){
        Consumer<Integer> imprime = n -> System.out.println("Imprimindo número: " + n);
        Consumer<Integer> verificaNumeroPar = imprime.andThen(i -> {
            if(i % 2 == 0){
                System.out.println("O número " + i + " é um número par");
            } else {
                System.out.println("O número " + i + " não é um número par");
            }
        });
        verificaNumeroPar.accept(4);
        verificaNumeroPar.accept(7);
    }

}
