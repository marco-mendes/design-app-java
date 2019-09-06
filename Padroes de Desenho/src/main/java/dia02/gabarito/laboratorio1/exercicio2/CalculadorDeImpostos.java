package dia02.gabarito.laboratorio1.exercicio2;

public class CalculadorDeImpostos {

    public double calcularImposto(double valorNota, Desconto[] descontos) {
        double totalImpostos = 0;

        for (Desconto desconto: descontos) {
            totalImpostos += desconto.calcularDesconto(valorNota);
        }
        return totalImpostos;
    }

}
