package gabarito.prototipodescartado.laboratorio6;

import java.util.function.Supplier;

public class IFSupplierExercicio {

    public static void main(String[] args) {
        // Resolvido
        Supplier<Double> valorAleatorio = () -> Math.random();
        System.out.println(valorAleatorio.get());

    }

}
