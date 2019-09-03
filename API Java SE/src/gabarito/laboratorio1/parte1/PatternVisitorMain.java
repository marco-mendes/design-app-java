package gabarito.laboratorio1.parte1;

public class PatternVisitorMain {

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras(
                new Produto("Celular", 1200.00),
                new Produto("Notebook", 2199.00),
                new Produto("Geladeira", 899.00),
                new Produto("XBox One", 1399.00),
                new Produto("PlayStation 4", 1899.00)
        );

        carrinhoDeCompras.accept(new AplicarCupomDeDescontoVisitor(0.1, "Aniversario da Loja"));

        System.out.println("Descontos aplicados ao carrinho de compras");
        carrinhoDeCompras.getDescontos()
                .forEach((key, value) -> {
                    System.out.println(
                            String.format("Desconto: %s | Valor: %s", key, value)
                    );
                });

        System.out.println(String.format("Valor carrinho com o cumpom de desconto aplicado ao carrinho: %s", carrinhoDeCompras.getValorASerPago()));


    }

}
