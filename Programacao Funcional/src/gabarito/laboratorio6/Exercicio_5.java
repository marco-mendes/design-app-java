package gabarito.laboratorio6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercicio_5 {

    public static void main(String[] args) {
        List<Produto> listaProdutos = Arrays.asList(
                new Produto("Xiaomi Mi 9", 1799.99, Tipo.ELETRONICOS),
                new Produto("Microondas", 299.00, Tipo.ELETRODOMESTICOS),
                new Produto("IPhone XS", 5299.99, Tipo.ELETRONICOS),
                new Produto("Notebook Dell", 2999.00, Tipo.ELETRONICOS),
                new Produto("Geladeira", 1299.99, Tipo.ELETRODOMESTICOS),
                new Produto("Samsung J5 Prime", 899.99, Tipo.ELETRONICOS)
        );

        Stream<Produto> streamProduto = listaProdutos.stream();
        Stream<String> streamNomeProdutos = streamProduto.map(p -> p.getNome());
        List<String> listaNomeProtudos = streamNomeProdutos.collect(Collectors.toList());
        listaNomeProtudos.forEach(p -> System.out.println(p));
    }

}
