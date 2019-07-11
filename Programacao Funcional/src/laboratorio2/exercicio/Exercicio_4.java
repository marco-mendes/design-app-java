package laboratorio2.exercicio;

import java.util.List;
import java.util.Optional;

/*
Com base no código abaixo implemente o seguinte comportamento no método imprimeSeEstiverPresente:
Verifique se o valor do Optional está presente, se estiver imprima o valor do mesmo no console, caso contrário imprima a seguinte mensagem: "Produto não encontrado!"
* */

public class Exercicio_4 {

    public static Produto buscarProdutoPorId(String id){
        List<Produto> produtos = Produto.obtemProdutos();
        for(Produto produto : produtos){
            if(produto.id.equals(id)){
                return produto;
            }
        }
        return null;
    }

    public static void imprimeSeEstiverPresente(Optional<Produto> produto){

        // Insira a implementação aqui

    }

    public static void main(String[] args) {

        Optional<Produto> produtoId1 = Optional.ofNullable(buscarProdutoPorId("1"));
        Optional<Produto> produtoId50 = Optional.ofNullable(buscarProdutoPorId("50"));

        imprimeSeEstiverPresente(produtoId1);
        imprimeSeEstiverPresente(produtoId50);

    }

}
