package laboratorio1.exemplos.exemplo2;

public class ContaCorrente{
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

}