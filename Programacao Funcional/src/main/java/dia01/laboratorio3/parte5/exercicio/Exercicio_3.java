package dia01.laboratorio3.parte5.exercicio;

import java.util.function.BinaryOperator;

/*
Com base no código abaixo siga os seguintes passos:
 * Crie um BinaryOperator chamado produtoMaisBarato, o mesmo deve verificar qual dos dois produtos é o mais barato.<br/>
 * Crie um BinaryOperator chamado produtoMaisCaro, o mesmo deve verificar qual dos dois produtos é o mais caro.<br/>
 * Utilize os métodos estáticos maxBy e minBy para criar esses 2 BinaryOperator.
 * Invoque cada um dos BinaryOperator utilizando os 2 objetos do tipo produto já criados e imprima no console o resultado.

 Dica: O Diamond Operator do BinaryOperator deve utilizar um objeto do tipo Produto.

* */

public class Exercicio_3 {

    public static void main(String[] args) {

        Produto produto1 = new Produto("Celular Galaxy J5 Prime", 899.00);
        Produto protudo2 = new Produto("Xiaomi Mi 8", 1999.00);

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