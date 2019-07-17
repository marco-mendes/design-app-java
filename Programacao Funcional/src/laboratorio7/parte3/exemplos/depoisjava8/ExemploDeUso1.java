package laboratorio7.parte3.exemplos.depoisjava8;

import java.util.function.Supplier;

public class ExemploDeUso1 {

    public static void main(String[] args) {
        Supplier<Car> ferrariSupplier = Ferrari::new;
        Supplier<Car> mercedesSupplier = Mercedes::new;

        Car ferrari = ferrariSupplier.get();
        Car mercedes = mercedesSupplier.get();

        ferrari.start();
        mercedes.start();

    }

}
