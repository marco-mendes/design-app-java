package dia01.laboratorio3.parte1.exemplos;

import java.util.function.Function;

public class Exemplo_6 {

    public static int calcular (int valor, Function<Integer, Integer> operation){
        return operation.apply(valor);
    }

    public static void main(String[] args) {
        // Exemplo passando uma expressão lambda na chamada do método
        System.out.println(calcular(20, (x) -> x * 5));
        //Exemplo passando uma função na chamada do método
        Function<Integer, Integer> funcaoDivisao = (value) -> value / 3;
        System.out.println(calcular(60,  funcaoDivisao));
    }
}