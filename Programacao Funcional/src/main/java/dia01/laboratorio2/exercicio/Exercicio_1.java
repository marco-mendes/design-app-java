package dia01.laboratorio2.exercicio;

import java.util.Arrays;
import java.util.List;

/*

  Com base no código acima implemente os seguintes métodos na interface **Calculator** de forma a não quebrar o código já existente:
    * calculaRaizQuadrada: Este método deve receber um valor do tipo inteiro e retornar a raiz quadrada do mesmo.
    * elevarAoCubo: Este método deve receber um valor do tipo inteiro e retornar esse valor elevado ao cubo.
  Após a criação desses métodos invoque cada um deles na classe Exercicio_1 para validar o funcionamento.

* */

public class Exercicio_1 {

    public static void main(String[] args) {
        List<Integer> listaNotas = Arrays.asList(10, 8 ,6, 9, 7);

        Calculadora calculadora = new Calculadora();
        String resultado = String.format("Média das notas: %d", calculadora.calculaMedia(listaNotas));
        System.out.println(resultado);

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

}