package gabarito.laboratorio4.exercicio1;

import java.io.FileOutputStream;

public class Exercicio1 {
    public static void main(String args[]){
        // Using try-with-resources
        try(FileOutputStream fileOutputStream = new FileOutputStream("./src/gabarito/laboratorio4/test.txt")) {
            String msg = "Hello try-with-resouce";
            byte byteArray[] = msg.getBytes(); //converting string into byte array
            fileOutputStream.write(byteArray);
            System.out.println("Message written to file successfuly!");
        } catch(Exception exception){
            System.out.println(exception);
        }
    }
}