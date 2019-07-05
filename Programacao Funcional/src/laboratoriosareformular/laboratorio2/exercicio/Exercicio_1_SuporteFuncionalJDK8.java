package laboratoriosareformular.laboratorio2.exercicio;

/*

Com base no código abaixo implemente os seguintes métodos na interface Calculator de forma a não quebrar o código já existente:
 * calculaRaizQuadrada: Este método deve receber um valor do tipo inteiro e retornar a raiz quadrada do mesmo.
 * elevarAoCubo: Este método deve receber um valor do tipo inteiro e retornar esse valor elevado ao cubo.

* */


public class Exercicio_1_SuporteFuncionalJDK8 implements Calculator {

    public static void main(String[] args) {

    }

    @Override
    public int calculoSimples(int a, int b){
        return a + b;
    }

}

interface Calculator {

    int calculoSimples(int a, int b);

}