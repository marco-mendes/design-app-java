package laboratorio4.exemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exemplo1 {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./src/laboratorio4/test.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

}
