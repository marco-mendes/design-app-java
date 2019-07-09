package gabarito.laboratorio3.parte4;

import java.util.function.Supplier;

public class Exercicio_1 {
    public static void main(String[] args) {
        
        Supplier<Double> valorAleatorioSupplier = () -> Math.random();
        System.out.println(valorAleatorioSupplier.get());

    }
}