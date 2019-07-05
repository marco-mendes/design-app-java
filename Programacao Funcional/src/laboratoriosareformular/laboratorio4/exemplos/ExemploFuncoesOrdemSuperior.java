package laboratoriosareformular.laboratorio4.exemplos;

import java.util.function.Function;

public class ExemploFuncoesOrdemSuperior {

    public static void main(String[] args) {

        Function<Integer, Double> obtemValorAoQuadrado = (value) -> Math.pow(value, 2);
        System.out.println("Valor ao quadrado: " + calcular(5, obtemValorAoQuadrado));

        System.out.println("Valor ao cubo: " + calcular(5, (value) -> Math.pow(value, 3)));

    }

    public static Double calcular(Integer valor, Function<Integer, Double> operacao){

        return operacao.apply(valor);

    }

}
