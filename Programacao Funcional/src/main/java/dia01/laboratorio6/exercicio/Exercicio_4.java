package dia01.laboratorio6.exercicio;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Com base no código abaixo realize uma filtragem na lista de produtos para que a mesma contenha apenas produtos com o preço acima de 1299.99<br/>
Após ser realizada a filtragem converta o Stream criado para uma nova lista de produtos e imprima no console todos os produtos da lista criada.
* */

public class Exercicio_4 {

    public static void main(String[] args) {
        List<Produto> listaProdutos = Arrays.asList(
                new Produto("Xiaomi Mi 9", 1799.99, Tipo.ELETRONICOS),
                new Produto("Microondas", 299.00, Tipo.ELETRODOMESTICOS),
                new Produto("IPhone XS", 5299.99, Tipo.ELETRONICOS),
                new Produto("Notebook Dell", 2999.00, Tipo.ELETRONICOS),
                new Produto("Geladeira", 1299.99, Tipo.ELETRODOMESTICOS),
                new Produto("Samsung J5 Prime", 899.99, Tipo.ELETRONICOS)
        );
    }

}