package laboratorio2.exemplos.exemplo2;

import java.util.Arrays;
import java.util.List;

class Produto {

    private int id;
    private String nome;
    private Double preco;
    private TipoProduto tipoProduto;

    public Produto(int id, String nome, Double preco, TipoProduto tipoProduto) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.tipoProduto = tipoProduto;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public static List<Produto> obterProdutos() {
        List<Produto> produtos = Arrays.asList(
                new Produto(1, "IPhone X", 3999.00, TipoProduto.ELETRONICO),
                new Produto(2, "Geladeira", 899.00, TipoProduto.ELETRODOMESTICO),
                new Produto(3, "MacBook Pro", 3899.00, TipoProduto.ELETRONICO),
                new Produto(4, "Xiaomi Mi 8", 999.00, TipoProduto.ELETRONICO)
        );
        return produtos;
    }

}