package laboratorio2.exercicio;

import java.util.Optional;

/*
Com base no código abaixo atribua o valor da descrição do produto para a variável descricaoProduto utilizando o método orElse(),
 o valor retornado caso o Optional esteja vazio deve ser a seguinte mensagem: "Produto não possui descrição cadastrada".
* */

public class Exercicio_7 {

    public static void main(String[] args) {

        Produto produtoSemDescricao = new Produto("1", "Celular", TipoProduto.Eletronicos, "Celular");
        Optional<Produto> produtoSemDescricaoOptional = Optional.of(produtoSemDescricao);

        String descricaoProduto = produtoSemDescricaoOptional.flatMap(Produto::getDescricao).orElse("Produto não possui descrição cadastrada");
        System.out.println(descricaoProduto);

    }

}
