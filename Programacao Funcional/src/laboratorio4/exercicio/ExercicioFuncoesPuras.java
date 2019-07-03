package laboratorio4.exercicio;

import java.util.function.Function;

public class ExercicioFuncoesPuras {

    public static void main(String[] args) {

        Integer multiplicador = 2;
        Function<Integer, Integer> multiplicaNumeroPor2 = (numero) -> numero * multiplicador;
        System.out.println(multiplicaNumeroPor2.apply(5));

    }

}
