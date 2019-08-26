package laboratorio2.exercicios.exercicio1;

public class ContaCorrente{
    private String nomeCorrentista;
    private Integer numeroConta;
    private double saldoConta = 0;

    public ContaCorrente(String nomeCorrentista, Integer numeroConta) {
        this.nomeCorrentista = nomeCorrentista;
        this.numeroConta = numeroConta;
    }

    public ContaCorrente(String titular, Integer nconta, double saldo){
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

    public double getSaldoConta() {
        return saldoConta;
    }

    public void depositar(double valorDeposito){
        saldoConta = saldoConta + valorDeposito;
    }

    public void sacar(double valorSaque){
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

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "nomeCorrentista='" + nomeCorrentista + '\'' +
                ", numeroConta=" + numeroConta +
                ", saldoConta=" + saldoConta +
                '}';
    }
}