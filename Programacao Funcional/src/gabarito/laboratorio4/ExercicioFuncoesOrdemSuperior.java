package gabarito.laboratorio4;

import java.util.function.BiFunction;

public class ExercicioFuncoesOrdemSuperior {

    public static void main(String[] args) {
        // Primeira forma de invocar o método.
        BiFunction<Integer, Integer, Integer> multiplicaNumeros = (a,b) -> a * b;
        System.out.println(calcular(2,5, multiplicaNumeros));

        // Segunda forma de invocar o método.
        System.out.println(calcular(5,5, (a,b) -> a * b));
    }

    public static Integer calcular(Integer valor1, Integer valor2, BiFunction<Integer, Integer, Integer> operacao){

        return operacao.apply(valor1, valor2);

    }

}