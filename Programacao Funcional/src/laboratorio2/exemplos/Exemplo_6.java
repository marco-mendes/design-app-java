package laboratorio2.exemplos;

import java.util.Optional;

public class Exemplo_6 {

    public static void main(String[] args) {

        Optional<Integer> avaliacao = Optional.of(10);
        Optional<Integer> avaliacaoFiltrada = avaliacao.filter(v -> v > 0);
        if ((avaliacaoFiltrada.isPresent())) {
            System.out.println(avaliacaoFiltrada.get());
        } else {
            System.out.println("Valor não está de acordo com o filtro");
        }

    }

}