package gabarito.laboratorio2;

import java.util.List;
import java.util.Optional;


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
        if(produto.isPresent()){
            System.out.println(produto.get());
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    public static void main(String[] args) {

        Optional<Produto> produtoId1 = Optional.ofNullable(buscarProdutoPorId("1"));
        Optional<Produto> produtoId50 = Optional.ofNullable(buscarProdutoPorId("50"));

        imprimeSeEstiverPresente(produtoId1);
        imprimeSeEstiverPresente(produtoId50);

    }

}
