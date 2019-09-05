package dia01.laboratorio3.parte4.exemplos;

import java.util.Date;
import java.util.function.Supplier;

public class Exemplo_1 {

    public static void main(String[] args) {
        Supplier<Date> dateSupplier = () -> new Date();
        Date today = dateSupplier.get();

        System.out.println("Today : "+today);
    }
}