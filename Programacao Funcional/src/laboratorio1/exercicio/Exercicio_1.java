package laboratorio1.exercicio;

import java.util.Arrays;
import java.util.List;

/*
Com base no código de exemplo crie um método chamado ordenaListaProdutosPorNome para ordenar os produtos por nome e retornar a lista de produtos ordenada.
Após isso invoque este método e imprima a lista retornada no console.
* */


public class Exercicio_1 {

    public static void main(String[] args) {

        List<Produto> produtos = obtemListaProdutos();
        produtos.sort((p1, p2) -> p1.getNome().compareTo(p2.getNome()));
        produtos.forEach((p) -> System.out.println(p));

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