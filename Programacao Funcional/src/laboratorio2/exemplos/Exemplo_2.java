package laboratorio2.exemplos;

import java.util.Arrays;
import java.util.List;

public class Exemplo_2 {

    public static void imprimeValorMaiusculo(String value){
        System.out.println(value.toUpperCase());
    }

    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("Marry", "Jhon", "Natasha");
        nomes.forEach(Exemplo_2::imprimeValorMaiusculo);
    }

}