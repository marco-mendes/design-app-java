package laboratorio1.parte1.exemplo;

public class AplicarImpostoCOFINSVisitor implements NotaFiscalVisitor {

    private double percentualDesconto = 0.03;

    @Override
    public void visit(NotaFiscal notaFiscal) {
        double valorDesconto = notaFiscal.getValorBruto() * percentualDesconto;
        notaFiscal.adicionarDesconto("COFINS", valorDesconto);
        System.out.println(String.format("Adicionando desconto CONFIS no valor de %s", valorDesconto));
    }
}
