package com.exemplos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
public class Exemplo_4 {

    public static void antesJava9() {
        try(FileOutputStream fileStream=new FileOutputStream("javatpoint.txt");){
            String greeting = "Welcome to javaTpoint.";
            byte b[] = greeting.getBytes();
            fileStream.write(b);
            System.out.println("File written");
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void depoisJava9() throws FileNotFoundException {
        FileOutputStream fileStream=new FileOutputStream("javatpoint.txt");
        try(fileStream){
            String greeting = "Welcome to javaTpoint.";
            byte b[] = greeting.getBytes();
            fileStream.write(b);
            System.out.println("File written");
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        antesJava9();
        depoisJava9();
    }

}
