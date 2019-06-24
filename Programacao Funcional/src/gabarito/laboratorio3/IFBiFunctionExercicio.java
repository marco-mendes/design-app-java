package gabarito.laboratorio3;

import java.util.function.BiFunction;

public class IFBiFunctionExercicio {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> areaRetangulo = (value1, value2) -> value1 * value2;
        BiFunction<Integer, Integer, Boolean> areaRetanguloMaiorQue100 = areaRetangulo.andThen(v -> (v > 100) ? true : false);
        System.out.println("Área do retângulo maior que 100? " + areaRetanguloMaiorQue100.apply(21, 5));

    }

}
