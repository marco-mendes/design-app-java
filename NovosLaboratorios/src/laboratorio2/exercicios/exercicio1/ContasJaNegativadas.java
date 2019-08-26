package laboratorio2.exercicios.exercicio1;

import java.util.Arrays;
import java.util.List;

public class ContasJaNegativadas {

    private static List<ContaCorrente> contasJaNegativadas;

    public static List<ContaCorrente> obtemContasJaNegativadas() {
        contasJaNegativadas = Arrays.asList(
                new ContaCorrente("Marcos", 12345),
                new ContaCorrente("Silvio", 23456),
                new ContaCorrente("Raquel", 75690),
                new ContaCorrente("Joana", 01134),
                new ContaCorrente("Fábio", 57123)
        );
        return contasJaNegativadas;
    }

}
