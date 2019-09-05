package dia01.gabarito.laboratorio4;

import java.util.function.BiFunction;

public class Exercicio_2 {

    public static Integer calcular(Integer valor1, Integer valor2, BiFunction<Integer, Integer, Integer> operacao){
        return operacao.apply(valor1, valor2);
    }

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> multiplicaValores = (v1, v2) -> v1 * v2;
        System.out.println(calcular(10, 20, multiplicaValores));

    }

}
