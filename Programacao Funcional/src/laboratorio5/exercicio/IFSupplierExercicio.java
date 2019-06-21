package laboratorio5.exercicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class IFSupplierExercicio {

    public static void main(String[] args) {

        Supplier<String> generateString = () ->
        {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter a string:");
            return scan.nextLine();
        };
        System.out.println(generateString.get());

        Supplier<List<String>> listaSupplier = () -> new ArrayList<>();


    }

}


