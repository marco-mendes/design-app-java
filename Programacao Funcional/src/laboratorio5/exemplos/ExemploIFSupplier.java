package laboratorio5.exemplos;

import java.util.function.Supplier;

public class ExemploIFSupplier {

    public static void main(String[] args) {
        Supplier<Double> valorAleatorio = () -> Math.random();
        System.out.println(valorAleatorio.get());
    }
}
