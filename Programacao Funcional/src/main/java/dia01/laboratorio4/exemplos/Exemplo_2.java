package dia01.laboratorio4.exemplos;

import java.util.function.Function;

public class Exemplo_2 {

    public static Double calcular(Integer valor, Function<Integer, Double> operacao){

        return operacao.apply(valor);

    }

    public static void main(String[] args) {

        Function<Integer, Double> obtemValorAoQuadrado = (value) -> Math.pow(value, 2);
        Function<Integer, Double> obtemValorAoCubo = (value) -> Math.pow(value, 3);

        System.out.println(
                String.format("Valor ao quadrado: %s", calcular(5, obtemValorAoQuadrado))
        );

        System.out.println(
                String.format("Valor ao cubo: %s", calcular(5, obtemValorAoCubo))
        );

    }

}