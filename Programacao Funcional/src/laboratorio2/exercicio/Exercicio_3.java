package laboratorio2.exercicio;

import java.util.List;
import java.util.Optional;

public class Exercicio_3 {

    public static Produto buscarProdutoPorId(String id){
        List<Produto> produtos = Produto.obtemProdutos();
        for(Produto produto : produtos){
            if(produto.id.equals(id)){
                return produto;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        //Produto produto = buscarProdutoPorId("5");
        Optional<Produto> produto = Optional.ofNullable(buscarProdutoPorId("5"));
    }

}