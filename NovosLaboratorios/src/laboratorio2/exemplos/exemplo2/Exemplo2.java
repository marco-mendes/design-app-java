package laboratorio2.exemplos.exemplo2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exemplo2 {

    public static void encadeamentoExcessivoDeMetodosStream() {
        List<String> eletronicosComPrecoAcimaDe899 = Produto.obterProdutos()
                .stream()
                .filter(p -> p.getTipoProduto().equals(TipoProduto.ELETRONICO))
                .filter(p -> p.getPreco() > 899.00)
                .map(p -> String.format("ID: %s - Nome: %s", p.getId(), p.getNome()))
                .collect(Collectors.toList());

        eletronicosComPrecoAcimaDe899.forEach(p -> System.out.println(p));

    }

    public static void encadeamentoExcessivoRefatoradoEmVariaveisExplicativas() {
        Stream<Produto> streamEletronicosAcima899 = Produto.obterProdutos()
                .stream()
                .filter(p -> p.getTipoProduto().equals(TipoProduto.ELETRONICO))
                .filter(p -> p.getPreco() > 899.00);

        Stream<String> streamResultadoFormatado = streamEletronicosAcima899.map(p -> String.format("ID: %s - Nome: %s", p.getId(), p.getNome()));
        List<String> listaResultadoFormatado = streamResultadoFormatado.collect(Collectors.toList());
    }


    public static void main(String[] args) {
        encadeamentoExcessivoDeMetodosStream();
        encadeamentoExcessivoRefatoradoEmVariaveisExplicativas();
    }


}