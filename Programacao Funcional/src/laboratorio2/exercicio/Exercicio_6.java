package laboratorio2.exercicio;

import java.util.Optional;

public class Exercicio_6 {

    public static void main(String[] args) {

        Produto produto = new Produto("1", "Sorvete", TipoProduto.Congelados, "Sorvete de Morango");

        Optional<Produto> optionalProduto = Optional.of(produto);

        String nomeProduto = optionalProduto.map(Produto::getNome).get();
        TipoProduto tipoProduto = optionalProduto.map(Produto::getTipo).get();
        String descricaoProduto = optionalProduto.flatMap(Produto::getDescricao).get();

        System.out.println(
                String.format("Nome Produto: %s | Tipo Produto: %s | Descrição produto: %s", nomeProduto, tipoProduto, descricaoProduto)
        );

    }

}
