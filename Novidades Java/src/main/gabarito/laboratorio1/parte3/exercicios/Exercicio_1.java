package gabarito.laboratorio1.parte3.exercicios;

import java.util.Arrays;
import java.util.List;

/*
Crie um método privado na Interface Calculator chamado imprimeResultado, este método deve receber como parâmetro um valor inteiro e deve
imprimir uma mensagem informando o resultado da operação, exemplo: "Resultado da operação: 15".<br/>
O método imprimeResultado deve ser invocado dentro do método calculaMedia recebendo como parâmetro a média calculada.
* */


public class Exercicio_1 {

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        int media = calculadora.calculaMedia(Arrays.asList(1,2,3,4,5));
    }

}

class Calculadora implements Calculator {

    @Override
    public int calculoSimples(int a, int b) {
        return a + b;
    }

}

interface Calculator {

    int calculoSimples(int a, int b);

    default int calculaMedia(List<Integer> valores){
        int totalElementos = valores.size();
        int media = somaValores(valores) / totalElementos;
        imprimeResultado(media);
        return media;
    }

    private int somaValores(List<Integer> valores) {
        int soma = valores.stream()
                .reduce(0, (a, b) -> a + b);
        return soma;
    }

    private void imprimeResultado(int resultado) {
        System.out.println(String.format("Resultado da operação: %s", resultado));
    }

}