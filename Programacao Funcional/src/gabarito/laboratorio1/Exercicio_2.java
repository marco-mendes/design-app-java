package gabarito.laboratorio1;

import java.util.List;

/*
Altere a interface TestarAlgo para receber como parâmetro um número inteiro.
Utilize a interface TestarAlgo para verificar se um número é um número par, caso seja a expressão lambda deve retornar true caso contrário deve retornar false.
Imprima o resultado do teste no console.
* */

public class Exercicio_2 {

    public static void main(String[] args) {
        TestarAlgo teste = (n) -> (n%2 == 0) ? true : false;
        System.out.println("É um número par? " + teste.test(4));
        System.out.println("É um número par? " + teste.test(7));
    }

}

interface TestarAlgo {
    boolean test(Integer numero);
}