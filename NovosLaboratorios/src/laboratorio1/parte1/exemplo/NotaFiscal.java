package laboratorio1.parte1.exemplo;

import java.util.HashMap;
import java.util.Map;

public class NotaFiscal implements VisitableElement {

    private double valorBruto;
    private double valorLiquido;
    private Map<String, Double> descontos = new HashMap<>();

    public NotaFiscal(double valorNota) {
        this.valorBruto = valorNota;
        this.valorLiquido = valorNota;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public double getValorLiquido() {
        return valorLiquido;
    }

    public Map<String, Double> getDescontos() {
        return descontos;
    }

    public void adicionarDesconto(String nomeDesconto, Double valorDesconto) {
        this.descontos.put(nomeDesconto, valorDesconto);
        this.valorLiquido = this.valorLiquido - valorDesconto;
    }

    @Override
    public void accept(NotaFiscalVisitor visitor) {
        visitor.visit(this);
    }
}
