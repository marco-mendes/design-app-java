package laboratorio1.parte1.exercicio;

public class PatternVisitorMain {

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras(
                new Produto("Celular", 1200.00),
                new Produto("Notebook", 2199.00),
                new Produto("Geladeira", 899.00),
                new Produto("XBox One", 1399.00),
                new Produto("PlayStation 4", 1899.00)
        );

        System.out.println(carrinhoDeCompras.getValorTodosProdutos());
        System.out.println(carrinhoDeCompras.getValorASerPago());

    }

}
