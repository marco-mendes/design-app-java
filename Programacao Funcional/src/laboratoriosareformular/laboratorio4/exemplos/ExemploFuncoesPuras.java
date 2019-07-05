package laboratoriosareformular.laboratorio4.exemplos;

import java.util.function.Function;

public class ExemploFuncoesPuras {

    public static void main(String[] args) {

        Function<Double, Double> calculaAreaCirculoPura = (raio) -> Math.PI * (Math.pow(raio, 2));
        System.out.println(calculaAreaCirculoPura.apply(5.0));

        Double valorPi = Math.PI;
        Function<Double, Double> calculaAreaCirculoInpura = (raio) -> valorPi * (Math.pow(raio, 2));
        System.out.println(calculaAreaCirculoInpura.apply(5.0));

    }



}
