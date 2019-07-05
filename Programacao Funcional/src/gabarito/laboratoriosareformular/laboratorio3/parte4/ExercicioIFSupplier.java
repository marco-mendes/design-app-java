package gabarito.laboratoriosareformular.laboratorio3.parte4;

import java.util.function.Supplier;

public class ExercicioIFSupplier {

    public static void main(String[] args) {
        // Resolvido
        Supplier<Double> valorAleatorio = () -> Math.random();
        System.out.println(valorAleatorio.get());

    }

}