package dia01.gabarito.laboratorio1;

import java.util.Arrays;
import java.util.List;

public class Exercicio_1 {

    public static void main(String[] args) {

        System.out.println(ordenaListaProdutosPorNome());

    }

    public static List<Produto> ordenaListaProdutosPorNome(){
        List<Produto> produtos = obtemListaProdutos();
        produtos.sort((p1, p2) -> p1.getNome().compareTo(p2.getNome()));
        return produtos;
    }

    public static List<Produto> obtemListaProdutos(){
        List<Produto> listaProdutos = Arrays.asList(
                new Produto("Samsung J5 Prime", 899.00),
                new Produto("Xiaomi Mi 9", 2299.00),
                new Produto("Notebook Dell Inspiron 5566 A50P", 2999.00),
                new Produto("Impressora LexMark XXJ25", 799.00),
                new Produto("TV LG 42 Polegadas" , 1899.00),
                new Produto("Kindle 10A", 349.00)
        );
        return listaProdutos;
    }

}

class Produto {

    private String nome;
    private Double preco;

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}