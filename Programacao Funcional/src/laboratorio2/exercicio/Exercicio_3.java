package laboratorio2.exercicio;

import java.util.List;
import java.util.Optional;

/*
Com base no código abaixo altere a variável produto do método main() para ser do tipo Optional e receber o Optional que melhor se encaixe no cenário,
lembrando que atualmente o valor recebido por essa variável pode ou não ser nulo.
* */

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