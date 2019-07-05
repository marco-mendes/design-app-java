package gabarito.laboratoriosareformular.laboratorio4;

import java.util.function.Function;

public class ExercicioFuncoesPuras {

    public static void main(String[] args) {

        Function<Integer, Integer> multiplicaNumeroPor2 = (numero) -> numero * 2;
        System.out.println(multiplicaNumeroPor2.apply(5));

    }

}