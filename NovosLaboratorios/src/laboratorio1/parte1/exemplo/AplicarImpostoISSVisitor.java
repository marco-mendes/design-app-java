package laboratorio1.parte1.exemplo;

public class AplicarImpostoISSVisitor implements NotaFiscalVisitor {

    private double percentualDesconto = 0.02;

    @Override
    public void visit(NotaFiscal notaFiscal) {
        double valorDesconto = notaFiscal.getValorBruto() * percentualDesconto;
        notaFiscal.adicionarDesconto("ISS", valorDesconto);
        System.out.println(String.format("Adicionando desconto ISS no valor de %s", valorDesconto));
    }
}
