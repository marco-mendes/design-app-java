package laboratorio2.exercicios.exercicio1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercicio1 {

    public static List<ContaCorrente> obterContasCorrente() {
        List<ContaCorrente> contasCorrente = Arrays.asList(
                new ContaCorrente("Silvio", 23456, 250.00),
                new ContaCorrente("Carlos", 55990, 750.00),
                new ContaCorrente("Raquel", 75690, 300.00),
                new ContaCorrente("Marcia", 11790, 800.00),
                new ContaCorrente("Joana", 01134, 100.00),
                new ContaCorrente("Michelle", 80902, 1000.00)
        );
        return contasCorrente;
    }


    public static void main(String[] args) {
        List<ContaCorrente> contasAptasParaEmprestimo = obterContasCorrente().stream().filter(conta -> {

            List<ContaCorrente> contasJaNegativadas = ContasJaNegativadas.obtemContasJaNegativadas();
            boolean contaJaFoiNegativada = contasJaNegativadas.stream()
                    .filter(c -> c.getNumeroConta()
                            .equals(conta.getNumeroConta()))
                    .findFirst()
                    .isPresent();

            if(contaJaFoiNegativada) {
                return false;
            } else {
                return true;
            }

        }).collect(Collectors.toList());

        contasAptasParaEmprestimo.forEach(conta -> System.out.println(conta));

    }

    public static boolean verificarSeAContaJaFoiNegativada(ContaCorrente conta) {
        List<ContaCorrente> contasJaNegativadas = ContasJaNegativadas.obtemContasJaNegativadas();
        boolean contaJaFoiNegativada = contasJaNegativadas.stream()
                .filter(c -> c.getNumeroConta()
                        .equals(conta.getNumeroConta()))
                .findFirst()
                .isPresent();

        if(contaJaFoiNegativada) {
            return false;
        } else {
            return true;
        }
    }

}
