package gabarito.laboratorio2;

import java.util.Optional;


public class Exercicio_5 {

    public static void filtraEImprimeSeHouverDescricao(Optional<Produto> produto){

        Optional<Produto> filtrado = produto.filter(p -> p.getDescricao().isPresent());
        if(filtrado.isPresent()){
            System.out.println(filtrado.get().getDescricao());
        } else {
            System.out.println("Descrição está vazia");
        }

    }

    public static void main(String[] args) {

        Produto p1 = new Produto("1", "Geladeira", TipoProduto.Eletrodomesticos);
        Produto p2 = new Produto("2", "Galaxy J5 Prime", TipoProduto.Eletronicos, "Celular Samgung Galaxy J5 Prime");

        Optional<Produto> p1Optional = Optional.of(p1);
        Optional<Produto> p2Optional = Optional.of(p2);

        filtraEImprimeSeHouverDescricao(p1Optional);
        filtraEImprimeSeHouverDescricao(p2Optional);

    }

}
