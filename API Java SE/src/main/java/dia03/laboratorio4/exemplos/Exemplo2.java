package dia03.laboratorio4.exemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exemplo2 {

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        try (Scanner scanner = new Scanner(new File("./src/main/resources/test.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

}
