package laboratorio2.exercicio;

import java.util.Arrays;
import java.util.List;

public class Exercicio_1_SuporteFuncionalJDK8 implements Calculator {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(4, 9, 16, 25, 36);

    }

    @Override
    public int calculoSimples(int a, int b){
        return a + b;
    }

}

interface Calculator {

    int calculoSimples(int a, int b);

    default double calculaRaizQuadrada(int numero){
        return Math.sqrt(numero);
    }

    default double elevarAoCubo(int numero){
        return Math.pow(numero, 3);
    }

}