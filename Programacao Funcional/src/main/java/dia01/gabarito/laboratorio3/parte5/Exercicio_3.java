package dia01.gabarito.laboratorio3.parte5;

import java.util.function.BinaryOperator;

public class Exercicio_3 {

    public static void main(String[] args) {

        Produto produto1 = new Produto("Celular Galaxy J5 Prime", 899.00);
        Produto protudo2 = new Produto("Xiaomi Mi 8", 1999.00);

        BinaryOperator<Produto> produtoMaisBarato = BinaryOperator.minBy((p1, p2) -> p1.getPreco().compareTo(p2.getPreco()));
        BinaryOperator<Produto> produtoMaisCaro = BinaryOperator.maxBy((p1, p2) -> p1.getPreco().compareTo(p2.getPreco()));

        System.out.println(String.format("Produto mais barato: %s", produtoMaisBarato.apply(produto1, protudo2)));
        System.out.println(String.format("Produto mais caro: %s", produtoMaisCaro.apply(produto1, protudo2)));

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