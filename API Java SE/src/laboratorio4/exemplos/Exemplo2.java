package laboratorio4.exemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exemplo2 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

}
