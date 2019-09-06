package laboratorio1.parte4.exercicio;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Exercicio_1 {

    public static void main(String[] args) {
        Optional<Carro> carro1 = Carro.buscarCarroPorModelo("Palio");
        Optional<Carro> carro2 = Carro.buscarCarroPorModelo("Siena");

    }

}

class Carro {
    private String modelo;
    private String marca;

    public Carro(String modelo, String marca) {
        this.modelo = modelo;
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public static Optional<Carro> buscarCarroPorModelo(String modelo) {
        List<Carro> listaCarros = Arrays.asList(
                new Carro("Palio", "Fiat"),
                new Carro("Gol", "Volkswagen"),
                new Carro("Versa", "Nissan")
        );

        Optional<Carro> resultado = listaCarros.stream().filter(carro -> carro.getModelo().equals(modelo)).findFirst();
        return resultado;
    }

    public void imprimeCarro() {
        System.out.println(String.format("Carro modelo: %s, Marca: %s", this.modelo, this.marca));
    }

}
