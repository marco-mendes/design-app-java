package dia03.laboratorio1.parte1.exercicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarrinhoDeCompras {

    private List<Produto> produtosCarrinho = new ArrayList<>();
    private Double valorTodosProdutos;
    private Double valorASerPago;
    private Map<String, Double> descontos = new HashMap<>();

    public CarrinhoDeCompras(Produto... produtos) {
        this.valorTodosProdutos = 0.0;
        this.valorASerPago = 0.0;

        for(Produto produto : produtos) {
            this.produtosCarrinho.add(produto);
            this.valorTodosProdutos += produto.getValor();
        }
        this.valorASerPago = this.valorTodosProdutos;
    }

    public List<Produto> getProdutosCarrinho() {
        return produtosCarrinho;
    }

    public Double getValorTodosProdutos() {
        return valorTodosProdutos;
    }

    public Double getValorASerPago() {
        return valorASerPago;
    }

    public Map<String, Double> getDescontos() {
        return descontos;
    }

    public void adicionarDesconto(String nomeDesconto, Double valorDesconto) {
        this.descontos.put(nomeDesconto, valorDesconto);
        this.valorASerPago = this.valorASerPago - valorDesconto;
    }

}
