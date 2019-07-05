package gabarito.laboratorio2;

import java.util.Arrays;
import java.util.List;

public class Exercicio_1 {

    public static void main(String[] args) {
        List<Integer> listaNotas = Arrays.asList(10, 8 ,6, 9, 7);

        Calculadora calculadora = new Calculadora();
        String resultado = String.format("Média das notas: %d", calculadora.calculaMedia(listaNotas));
        System.out.println(resultado);

        System.out.println(calculadora.calculaRaizQuadrada(25));
        System.out.println(calculadora.elevarAoCubo(5));

    }

}

class Calculadora implements Calculator {
    @Override
    public int calculoSimples(int a, int b){
        return a + b;
    }

}

interface Calculator {

    int calculoSimples(int a, int b);

    default int calculaMedia(List<Integer> valores){
        int totalElementos = valores.size();
        int soma = 0;
        for(int valor : valores){
            soma += valor;
        }
        return soma / totalElementos;
    }

    default double calculaRaizQuadrada(int numero){
        return Math.sqrt(numero);
    }

    default double elevarAoCubo(int numero){
        return Math.pow(numero, 3);
    }

}