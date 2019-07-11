package laboratorio2.exercicio;

import java.util.Optional;

/*
Com base no código abaixo altere o método filtraEImprimeSeHouverDescricao para filtrar se a propriedade descricao está presente no Optional.
Utilizando o Optional filtrado verifique se o Optional possui valor, se sim imprima a descrição do produto, se não imprima: "Descrição está vazia!"
* */

public class Exercicio_5 {

    public static void filtraEImprimeSeHouverDescricao(Optional<Produto> produto){
        /*
        Optional<Produto> filtrado = produto.filter(p -> p.getDescricao().isPresent());
        if(filtrado.isPresent()){
            System.out.println(filtrado.get().getDescricao());
        } else {
            System.out.println("Descrição está vazia");
        }
        */
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
