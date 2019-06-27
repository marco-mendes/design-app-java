package prototipodescartado.laboratorio1.exemplos;

import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {

        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);

        int multiplicador = 3;

        // Função Lambda pura
        lista.forEach((v) -> System.out.print(v * 2) );
        // Função Lambda não pura
        lista.forEach((v) -> System.out.print(v * multiplicador));

        TestaAlgo teste = () -> 5 > 0;
        System.out.println("Resultado do teste: " + teste.test());

    }


}

interface TestaAlgo {
    boolean test();
}


class Calculadora {

    public static void main(String[] args) {

        System.out.println(calcular((a, b) -> a + b,5,20));
        // Outra forma de usar a interface Operator
        Operator<Integer> calculador = (a, b) -> a * b;
        System.out.println(calculador.apply(5, 10));

        OperatorComplexo<Double> calculaRaizQuadrada = (n) -> Math.sqrt(n);
        System.out.println(calculaRaizQuadrada.apply(25.0));

    }

    public static <T> T calcular(Operator<T> operacao, T value1, T value2){
        return operacao.apply(value1,value2);
    }

}

interface Operator<T> {

    T apply(T a, T b);

}

interface OperatorComplexo<T>{
    T apply(T a);
}