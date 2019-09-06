package dia02.gabarito.laboratorio1.exercicio2;

public class DescontoCOFINS implements Desconto {

    private double percentualImposto = 0.03;

    @Override
    public double calcularDesconto(double valorNota) {
        double desconto = valorNota * percentualImposto;
        return desconto;
    }

}