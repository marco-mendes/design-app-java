package laboratorio1.exemplos.exemplo3;

public class CalculadoraCientifica extends CalculadoraSimples {

    public CalculadoraCientifica() {

    }

    public double raizQuadrada(double valor) {
        return Math.sqrt(valor);
    }

    public double potencia(double valor, double potencia) {
        return Math.pow(valor, potencia);
    }

}
