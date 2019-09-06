package dia02.gabarito.laboratorio1.exercicio2;

public class DescontoICMS_MinasGerais implements Desconto {

    private double percentualImposto = 0.18;

    @Override
    public double calcularDesconto(double valorNota) {
        double desconto = valorNota * percentualImposto;
        return desconto;
    }

}