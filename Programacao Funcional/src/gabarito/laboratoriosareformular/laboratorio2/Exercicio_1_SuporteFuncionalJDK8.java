package gabarito.laboratoriosareformular.laboratorio2;

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

    default double calculaRaizQuadrada(int numero){
        return Math.sqrt(numero);
    }

    default double elevarAoCubo(int numero){
        return Math.pow(numero, 3);
    }

}