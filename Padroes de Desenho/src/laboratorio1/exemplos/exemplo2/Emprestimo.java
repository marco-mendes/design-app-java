package laboratorio1.exemplos.exemplo2;

import java.util.List;

public class Emprestimo {

    public void realizarEmprestimo(ContaCorrente conta, double valor) {
        if(contaJaFoiNegativada(conta)) {
            System.out.println("Emprestimo negado!");
        } else {
            System.out.println("Emprestimo aprovado!");
        }
    }

    private boolean contaJaFoiNegativada(ContaCorrente conta) {
        List<ContaCorrente> contasJaNegativadas = ContasJaNegativadas.obtemContasJaNegativadas();
        boolean contaJaFoiNegativada = contasJaNegativadas.stream()
                .filter(c -> c.getNumeroConta()
                        .equals(conta.getNumeroConta()))
                .findFirst()
                .isPresent();
        return contaJaFoiNegativada;
    }

}
