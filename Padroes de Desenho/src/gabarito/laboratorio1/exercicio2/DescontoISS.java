package gabarito.laboratorio1.exercicio2;

public class DescontoISS implements Desconto {

    private double percentualImposto = 0.02;

    @Override
    public double calcularDesconto(double valorNota) {
        double desconto = valorNota * percentualImposto;
        return desconto;
    }
}
