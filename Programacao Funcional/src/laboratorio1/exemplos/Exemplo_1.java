package laboratorio1.exemplos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Exemplo_1 {

    public static List<Produto> ordenaListaProdutosSemLambdas(){
        List<Produto> produtos = obtemListaProdutos();
        produtos.sort(new Comparator<Produto>() {
            @Override
            public int compare(Produto o1, Produto o2) {
                return o1.getPreco().compareTo(o2.getPreco());
            }
        });
        return produtos;
    }

    public static List<Produto> ordenaListaProdutosComLambdas(){
        List<Produto> produtos = obtemListaProdutos();
        produtos.sort((c1, c2) -> c1.getPreco().compareTo(c2.getPreco()));
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

    public static void main(String[] args) {
        System.out.println(ordenaListaProdutosSemLambdas());
        System.out.println(ordenaListaProdutosComLambdas());
    }

}

class Produto {

    String nome;
    Double preco;

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