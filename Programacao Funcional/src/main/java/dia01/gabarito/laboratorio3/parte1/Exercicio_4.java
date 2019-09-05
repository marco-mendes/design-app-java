package dia01.gabarito.laboratorio3.parte1;

import java.util.function.BiFunction;

public class Exercicio_4 {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> areaRetangulo = (base, altura) -> base * altura;
        BiFunction<Integer, Integer, Boolean> areaRetanguloMaiorQue100 = areaRetangulo.andThen(area -> (area > 100) ? true : false);
        System.out.println("Área do retângulo maior que 100? " + areaRetanguloMaiorQue100.apply(21, 5));

    }

}