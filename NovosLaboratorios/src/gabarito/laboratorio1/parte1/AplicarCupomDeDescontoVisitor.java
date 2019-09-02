package gabarito.laboratorio1.parte1;

public class AplicarCupomDeDescontoVisitor implements CarrinhoDeComprasVisitor {

    private double porcentagemDesconto = 0;
    private String nomeCupom;

    public AplicarCupomDeDescontoVisitor(double porcentagemDesconto, String nomeCupom) {
        this.porcentagemDesconto = porcentagemDesconto;
        this.nomeCupom = nomeCupom;
    }

    @Override
    public void visit(CarrinhoDeCompras carrinhoDeCompras) {
        double desconto = carrinhoDeCompras.getValorTodosProdutos() * this.porcentagemDesconto;
        carrinhoDeCompras.adicionarDesconto(String.format("Desconto Cupom %s", this.nomeCupom), desconto);
        System.out.println(String.format("Adicionando desconto do cupom %s no valor de %s", this.nomeCupom, desconto));
    }
}
