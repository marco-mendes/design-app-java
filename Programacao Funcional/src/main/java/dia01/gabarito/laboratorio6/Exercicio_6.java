package dia01.gabarito.laboratorio6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Exercicio_6 {

    public static void main(String[] args) {
        List<Produto> listaProdutos = Arrays.asList(
                new Produto("Xiaomi Mi 9", 1799.99, Tipo.ELETRONICOS),
                new Produto("Microondas", 299.00, Tipo.ELETRODOMESTICOS),
                new Produto("IPhone XS", 5299.99, Tipo.ELETRONICOS),
                new Produto("Notebook Dell", 2999.00, Tipo.ELETRONICOS),
                new Produto("Geladeira", 1299.99, Tipo.ELETRODOMESTICOS),
                new Produto("Samsung J5 Prime", 899.99, Tipo.ELETRONICOS)
        );

        List<Produto> listaEletronicos = listaProdutos
                .stream()
                .filter(p -> p.getTipo().equals(Tipo.ELETRONICOS))
                .collect(Collectors.toList());

        List<Produto> listaEletrodomesticos = listaProdutos
                .stream()
                .filter(p -> p.getTipo().equals(Tipo.ELETRODOMESTICOS))
                .collect(Collectors.toList());

        List<List<Produto>> listaTiposProduto = Arrays.asList(listaEletrodomesticos, listaEletronicos);

        List<Produto> listaTodosOsTipos = listaTiposProduto.stream().flatMap(lista -> lista.stream()).collect(Collectors.toList());
        listaTodosOsTipos.forEach(p -> System.out.println(p));
    }

}