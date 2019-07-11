package gabarito.laboratorio2;

import java.util.Optional;

public class Exercicio_7 {

    public static void main(String[] args) {

        Produto produtoSemDescricao = new Produto("1", "Celular", TipoProduto.Eletronicos, "Samsung Galaxy S9");
        Optional<Produto> produtoSemDescricaoOptional = Optional.of(produtoSemDescricao);

        String descricaoProduto = produtoSemDescricaoOptional.flatMap(Produto::getDescricao).orElse("Produto não possui descrição cadastrada");
        System.out.println(descricaoProduto);

    }

}
