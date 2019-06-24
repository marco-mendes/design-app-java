package laboratorio6.exemplos;

import java.util.Date;
import java.util.function.Supplier;

public class ExemploIFSupplier {

    public static void main(String[] args) {

        Supplier<Date> s = ()->new Date();
        Date today = s.get();

        System.out.println("Today : "+today);

    }
}

