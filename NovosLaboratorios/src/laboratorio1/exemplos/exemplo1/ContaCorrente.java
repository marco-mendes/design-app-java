package laboratorio1.exemplos.exemplo1;

import java.util.List;

public class ContaCorrente {
    private String nomeCorrentista;
    private Integer numeroConta;
    private float saldoConta = 0;

    public ContaCorrente(String nomeCorrentista, Integer numeroConta) {
        this.nomeCorrentista = nomeCorrentista;
        this.numeroConta = numeroConta;
    }

    public ContaCorrente(String titular, Integer nconta, float saldo){
        this.nomeCorrentista = titular;
        this.numeroConta = nconta;
        this.saldoConta = saldo;
    }

    public String getNomeCorrentista() {
        return nomeCorrentista;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public float getSaldoConta() {
        return saldoConta;
    }

    public void depositar(float valorDeposito){
        saldoConta = saldoConta + valorDeposito;
    }

    public void sacar(float valorSaque){
        if (valorSaque <= saldoConta) {
            saldoConta = saldoConta - valorSaque;
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void mostrarStatus(){
        System.out.println(nomeCorrentista);
        System.out.println(numeroConta);
        System.out.println("R$ " + saldoConta);
    }

    public void realizarEmprestimo(float valor) {
        if(contaJaFoiNegativada(this)) {
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