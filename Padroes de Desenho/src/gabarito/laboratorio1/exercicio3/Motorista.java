package gabarito.laboratorio1.exercicio3;

public class Motorista {

    public static void dirigir(Veiculo veiculo) {
        veiculo.ligarVeiculo();
        veiculo.acelerar();
    }

    public static void main(String[] args) {
        Carro carro = new Carro();
        dirigir(carro);
    }

}
