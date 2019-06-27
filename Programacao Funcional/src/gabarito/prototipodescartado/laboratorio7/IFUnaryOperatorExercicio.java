package gabarito.prototipodescartado.laboratorio7;

import java.util.function.UnaryOperator;

public class IFUnaryOperatorExercicio {
    public static void main(String[] args) {

        UnaryOperator<Double> aplicaImposto = (valor) -> valor + (valor * 0.10);
        Double valorMercadoria = 2500.00;
        System.out.println("Valor total mercadoria com imposto: " + aplicaImposto.apply(valorMercadoria));

    }
}