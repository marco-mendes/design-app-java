package laboratorio2.exercicio;

import java.util.Optional;

/*
Com base no código abaixo utilize map() e flatMap() para transformar e atribuir os valores das propriedades
 nome, tipo e descricao do objeto Produto para seus respectivos Optionals.
* */

public class Exercicio_6 {

    public static void main(String[] args) {

        Produto produto = new Produto("1", "Sorvete", TipoProduto.Congelados, "Sorvete de Morango");

        Optional<Produto> optionalProduto = Optional.of(produto);

        Optional<String> nomeProdutoOptional = optionalProduto.map(Produto::getNome);
        Optional<TipoProduto> tipoProdutoOptional = optionalProduto.map(Produto::getTipo);
        Optional<String> descricaoProtudoOptional = optionalProduto.flatMap(Produto::getDescricao);

        System.out.println(
                String.format("Nome Produto: %s | Tipo Produto: %s | Descrição produto: %s",
                        nomeProdutoOptional.get(), tipoProdutoOptional.get(), descricaoProtudoOptional.get())
        );

    }

}
