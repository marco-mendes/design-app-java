package dia01.laboratorio3.parte3.exemplos;

import java.util.function.Consumer;

public class Exemplo_3 {

    public static void main(String[] args) {
        Consumer<Integer> imprime = n -> System.out.println(String.format("Imprimindo número: %d", n));
        Consumer<Integer> verificaNumeroPar = imprime.andThen(i -> {
            if(i % 2 == 0){
                System.out.println(String.format("O número %d é um número par", i));
            } else {
                System.out.println(String.format("O número %d não é um número par", i));
            }
        });
        verificaNumeroPar.accept(4);
        verificaNumeroPar.accept(7);
    }

}
